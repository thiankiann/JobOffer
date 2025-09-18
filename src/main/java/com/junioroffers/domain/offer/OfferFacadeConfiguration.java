package com.junioroffers.domain.offer;


import com.junioroffers.domain.offer.dto.OfferResponseDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
public class OfferFacadeConfiguration {

    @Bean
    OfferFacade offerFacade(OfferFetchable offerFetchable) {
        OfferRepository repo = new OfferRepository() {

            @Override
            public Optional<Offer> findOfferById(String id) {
                return Optional.empty();
            }

            @Override
            public Offer save(Offer offer) {
                return null;
            }

            @Override
            public List<OfferResponseDto> findAllOffers() {
                return null;
            }

            @Override
            public boolean isUrlDuplicated(String offerUrl) {
                return false;
            }

            @Override
            public List<Offer> saveAll(List<Offer> offers) {
                return null;
            }
        };
        OfferService offerService = new OfferService(repo,offerFetchable);
        return new OfferFacade(offerService);//, repo);
    }
}
