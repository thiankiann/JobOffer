package com.junioroffers.infrastructure.http;

import com.junioroffers.domain.offer.OfferFetchable;
import com.junioroffers.domain.offer.OfferMapper;
import com.junioroffers.domain.offer.dto.JobOfferResponse;
import com.junioroffers.domain.offer.dto.OfferResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class OfferFetcherRestTemplate implements OfferFetchable {


    private final RestTemplate restTemplate;
    private final String uri;
    private final int port;
// get to http://ec2-3-127-218-34.eu-central-1.compute.amazonaws.com:5057/offers
    @Override
    public List<JobOfferResponse> fetchAllOffers() {
        String urlForService = getUrlForService("/offers");
        HttpHeaders headers = new HttpHeaders();
        final HttpEntity<HttpHeaders> requestEntity = new HttpEntity<>(headers);
        final String url = UriComponentsBuilder.fromHttpUrl(urlForService)
                .toUriString();
        ResponseEntity<List<JobOfferResponse>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
        List<JobOfferResponse> offers = response.getBody();
        System.out.println(offers);
     //   return OfferResponseDto.builder().numbers(numbers.stream().collect(Collectors.toSet())).build();
        return offers;
    }

    private String getUrlForService(String service) {
        return uri + ":" + port + service;
    }
}


