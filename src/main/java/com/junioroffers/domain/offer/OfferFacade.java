package com.junioroffers.domain.offer;

import com.junioroffers.domain.offer.dto.JobOfferResponseDto;
import com.junioroffers.domain.offer.dto.OfferRequestDto;
import com.junioroffers.domain.offer.dto.OfferResponseDto;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class OfferFacade {

    private final OfferRepository offerRepository;
    private final OfferService offerService;
    private final OfferMapper mapper;

    public List<OfferResponseDto> findOffers(){
        return null;
    }
    public List<OfferResponseDto> fetchAllOffersAndSaveAllifNotExist(){ return null;}
    public OfferResponseDto findOfferById(String id){
//        return offerService.findOfferById(id);
        return null;
    }

    public OfferResponseDto saveOffer(OfferRequestDto offerDto){ return null;}
}
