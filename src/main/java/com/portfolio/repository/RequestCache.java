package com.portfolio.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.portfolio.model.AttributionResponse;

@Repository
public class RequestCache {

	private final Map<String, AttributionResponse> cache =
            new ConcurrentHashMap<>();

    public AttributionResponse get(String requestId){
        return cache.get(requestId);
    }

    public void save(String requestId,
                     AttributionResponse response){

        cache.put(requestId,response);
    }
}
