package com.junioroffers.domain.offer;
import org.junit.jupiter.api.Test;

class OfferFacadeTest {
    OfferFacade loginFacade = new OfferFacade(
            new OfferService(new InMemoryOfferRepository(),new OfferNotFoundException("Offer NotFound Exception"))
                );
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

        //when

        //then
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
