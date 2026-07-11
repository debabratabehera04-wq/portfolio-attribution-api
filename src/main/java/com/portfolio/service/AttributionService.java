package com.portfolio.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.exception.InvalidInputException;
import com.portfolio.model.AttributionRequest;
import com.portfolio.model.AttributionResponse;
import com.portfolio.model.GroupContribution;
import com.portfolio.model.GroupRequest;
import com.portfolio.repository.RequestCache;

@Service
public class AttributionService {

	@Autowired
    private RequestCache cache;

    public AttributionResponse calculate(AttributionRequest request){

        //Idempotency

        if(cache.get(request.getRequestId())!=null){

            return cache.get(request.getRequestId());
        }

        double totalWeight = request.getGroups()
                .stream()
                .mapToDouble(GroupRequest::getWeightPct)
                .sum();

        if(totalWeight<99 || totalWeight>101){

            throw new InvalidInputException("Weight must be between 99 and 101");
        }

        AttributionResponse response =
                new AttributionResponse();

        List<GroupContribution> contributions =
                new ArrayList<>();

        List<String> warnings =
                new ArrayList<>();

        double totalContribution=0;

        int missingCount=0;

        boolean degraded=false;

        for(GroupRequest g : request.getGroups()){

            Double returnPct=g.getReturnPct();

            String pricingMode="PRIMARY";

            if(returnPct==null){

                if(g.getFallbackReturnPct()!=null){

                    returnPct=g.getFallbackReturnPct();

                    pricingMode="FALLBACK_USED";

                    warnings.add("Fallback pricing used for "
                            + g.getGroupName());

                }else{

                    missingCount++;

                    degraded=true;

                    warnings.add("Missing pricing for "
                            + g.getGroupName());

                    continue;
                }

            }

            double contribution =
                    g.getWeightPct()*returnPct/100;

            totalContribution+=contribution;

            GroupContribution gc=
                    new GroupContribution();

            gc.setGroupName(g.getGroupName());

            gc.setContributionPct(contribution);

            gc.setPricingMode(pricingMode);

            contributions.add(gc);

        }

        response.setRequestId(request.getRequestId());

        response.setPortfolioId(request.getPortfolioId());

        response.setValuationDate(request.getValuationDate());

        response.setTotalContributionPct(totalContribution);

        response.setGroupContributions(contributions);

        response.setWarnings(warnings);

        response.setProcessedAt(LocalDateTime.now());

        response.setDegraded(degraded);

        if(missingCount==0){

            response.setStatus("VALID");

        }else if(missingCount==1){

            response.setStatus("DEGRADED");

        }else{

            response.setStatus("REVIEW_REQUIRED");

        }

        cache.save(request.getRequestId(),response);

        return response;

    }

}
