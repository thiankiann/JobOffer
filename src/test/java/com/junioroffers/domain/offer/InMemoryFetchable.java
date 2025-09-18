package com.junioroffers.domain.offer;

import com.junioroffers.domain.offer.dto.JobOfferResponse;

import java.util.List;

class InMemoryFetchable implements OfferFetchable{
//!!! check it later
    List<JobOfferResponse> listOfOffers;
    InMemoryFetchable(List<JobOfferResponse> listOfOffers) {
        this.listOfOffers = listOfOffers;
    }

    @Override
    public List<JobOfferResponse> fetchOffers() {
        return   listOfOffers;
//                List.of(
//                new JobOfferResponse("Tesla","engineer","£200 000","www.tesla.com/offer83698"),
//                new JobOfferResponse("Tesla", "mechanic", "£80 000", "www.tesla.com/offer8369"),
//                new JobOfferResponse("Tesla", "manager", "£400 000", "www.tesla.com/offer83688"),
//                new JobOfferResponse("Tesla", "owner", "£400 000 000", "www.tesla.com/offer88898"),
//                new JobOfferResponse("Tesla", "lawyer", "£40 000", "www.tesla.com/offer8865598"),
//                new JobOfferResponse("Tesla", "expert", "£100 000", "www.tesla.com/offer84156998")
//        );
    }
}
