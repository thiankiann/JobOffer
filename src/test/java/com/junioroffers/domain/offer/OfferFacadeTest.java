package com.junioroffers.domain.offer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

class OfferFacadeTest {
    OfferFacade offerFacade = new OfferFacade(new OfferService(new InMemoryOfferRepository()));
    @Test
    public void should_save_4_offers_when_there_are_no_offers_in_database() {
        //given

        //when

        //then
    }
    @Test
    public void should_save_2_offers_when_repository_had4_added_with_offer_urls() {
        //given

        //when

        //then
    }
    @Test
    public void should_duplicate_key_exception_when_with_offer_url_exists() {
        //given

        //when

        //then
    }
    @Test
    public void should_throw_not_found_exception_when_offer_not_found() {
        //given
        String id = "0";
        //when
        Throwable thrown = catchThrowable(() -> offerFacade.findOfferById(id));
        //then
        assertThat(thrown)
                .isInstanceOf(OfferNotFoundException.class)
                .hasMessage("Offer not Found");

    }
    @Test
    public void should_fetch_from_jobs_from_remote_and_save_all_offers_when_repository_is_empty() {
        //given

        //when

        //then
    }
    @Test
    public void should_find_offer_by_id_when_offer_was_saved() {
        //given

        //when

        //then
    }
}
