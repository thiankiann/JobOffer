package com.junioroffers.domain.offer;

import com.junioroffers.domain.offer.dto.JobOfferResponseDto;

import java.util.Optional;


interface OfferRepository {
   Optional<Offer> findOfferById(String id);
}
