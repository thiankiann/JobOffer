package com.junioroffers.domain.offer;

import com.junioroffers.domain.offer.dto.OfferRequestDto;
import com.junioroffers.domain.offer.dto.OfferResponseDto;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class OfferFacade {

    private final OfferService offerService;

//    public List<OfferResponseDto> findOffers(){
//        return null;
//    }
   // public List<OfferResponseDto> fetchAllOffersAndSaveAllifNotExist(){ return null;}

    public OfferResponseDto findOfferById(String id){
        return offerService.findOfferById(id);
    }

   // public OfferResponseDto saveOffer(OfferRequestDto offerDto){ return null;}
}
