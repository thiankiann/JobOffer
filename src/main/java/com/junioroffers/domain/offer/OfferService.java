package com.junioroffers.domain.offer;


import com.junioroffers.domain.offer.dto.OfferRequestDto;
import com.junioroffers.domain.offer.dto.OfferResponseDto;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;


@AllArgsConstructor
class OfferService {

        private final OfferFetchable offerFetcher;
        private final OfferRepository offerRepository;
        // Deterministic ID sequence for offers fetched from external HTTP source (integration tests expect 1000, 2000, ...)
        private final AtomicLong fetchedOfferIdSequence = new AtomicLong(1000);

        List<Offer> fetchAllOffersAndSaveAllIfNotExists() {
            List<Offer> jobOffers = fetchOffers();
            final List<Offer> offers = filterNotExistingOffers(jobOffers);
            return offerRepository.saveAll(offers);
        }

        private List<Offer> fetchOffers() {
            return offerFetcher.fetchOffers()
                    .stream()
                    .map(OfferMapper::mapFromJobOfferResponseToOffer)
                    .map(offer -> Offer.builder()
                            .id(String.valueOf(fetchedOfferIdSequence.getAndAdd(1000)))
                            .companyName(offer.companyName())
                            .position(offer.position())
                            .salary(offer.salary())
                            .offerUrl(offer.offerUrl())
                            .build())
                    .toList();
        }

        private List<Offer> filterNotExistingOffers(List<Offer> jobOffers) {
            return jobOffers.stream()
                    .filter(offerDto -> !offerDto.offerUrl().isEmpty())
                    .filter(offerDto -> !offerRepository.existsByOfferUrl(offerDto.offerUrl()))
                    .collect(Collectors.toList());

        }

}
