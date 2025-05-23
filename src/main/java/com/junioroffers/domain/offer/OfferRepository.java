package com.junioroffers.domain.offer;

import java.util.Optional;


interface OfferRepository {
   Optional<Offer> findOfferById(String id);

   Offer save(Offer offer);

}
