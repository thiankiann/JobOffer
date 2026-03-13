package com.junioroffers.infrastructure.http;

import com.junioroffers.domain.offer.OfferFetchable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class OfferClientConfig {

    @Bean
    public RestTemplateResponseErrorHandler restTemplateResponseErrorHandler() {
        return new RestTemplateResponseErrorHandler();
    }

    @Bean
    public RestTemplate restTemplate(
            RestTemplateResponseErrorHandler restTemplateResponseErrorHandler,
            @Value("${offer.http.client.config.connectionTimeout:${offers.http.client.config.connectionTimeout:5000}}") long connectionTimeout,
            @Value("${offer.http.client.config.readTimeout:${offers.http.client.config.readTimeout:5000}}") long readTimeout
    ) {
        return new RestTemplateBuilder()
                .errorHandler(restTemplateResponseErrorHandler)
                .setConnectTimeout(Duration.ofMillis(connectionTimeout))
                .setReadTimeout(Duration.ofMillis(readTimeout))
                .build();
    }

    @Bean
    public OfferFetchable remoteOfferClient(
            RestTemplate restTemplate,
            @Value("${offer.http.client.config.uri:${offers.http.client.config.uri}}") String uri,
            @Value("${offer.http.client.config.port:${offers.http.client.config.port}}") int port
    ) {
        return new OfferFetcherRestTemplate(restTemplate, uri, port);
    }
}