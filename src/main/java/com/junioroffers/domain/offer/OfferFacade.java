package com.junioroffers.domain.offer;

import com.junioroffers.domain.offer.dto.OfferRequestDto;
import com.junioroffers.domain.offer.dto.OfferResponseDto;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class OfferFacade {

    private final OfferService offerService;

    public List<OfferResponseDto> findAllOffers(){
        return offerService.findAllOffers();
    }
   // public List<OfferResponseDto> fetchAllOffersAndSaveAllifNotExist(){ return null;}

    public OfferResponseDto findOfferById(String id){
        return offerService.findOfferById(id);
    }

    public OfferResponseDto saveOffer(OfferRequestDto offerDto){

        return offerService.saveOffer(offerDto);
    }
    public void saveIfOfferUrlIsNotDuplicated(OfferRequestDto offerRequestDto ){

         offerService.saveIfOfferIfUrlIsNotDuplicated(offerRequestDto );
       //  return offerRequestDto;
    }
}
