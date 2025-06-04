package com.junioroffers.domain.offer;

import com.junioroffers.domain.offer.dto.OfferResponseDto;

import java.util.List;
import java.util.Optional;


interface OfferRepository {
   Optional<Offer> findOfferById(String id);

   Offer save(Offer offer);

    List<OfferResponseDto> findAllOffers();

    boolean isUrlDuplicated(String offerUrl);

    List<Offer> saveAll(List<Offer> offers);
}
