package com.junioroffers.domain.offer;

import com.junioroffers.domain.loginandregister.dto.RegisterUserDto;
import com.junioroffers.domain.loginandregister.dto.RegistrationResultDto;
import com.junioroffers.domain.offer.dto.JobOfferResponse;

import java.util.List;

public interface OfferFetchable {

     List<JobOfferResponse> fetchAllOffers();
}
