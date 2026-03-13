package com.junioroffers.http.errors;

import com.junioroffers.domain.offer.OfferFetchable;
import com.junioroffers.infrastructure.http.OfferClientConfig;
import jdk.jfr.RecordingState;
import org.springframework.web.client.RestTemplate;

class OfferFetcherRestTemplateIntegrationTestConfig extends OfferClientConfig {

    OfferFetchable remoteOfferClient(int port , int connectionTimeout, int readTimeout){
        RestTemplate restTemplate = restTemplate(restTemplateResponseErrorHandler(),connectionTimeout,readTimeout);
;        return remoteOfferClient(restTemplate,"http://localhost",port);
    }
}
