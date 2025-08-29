package com.junioroffers.features;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.junioroffers.BaseIntegrationTest;
import com.junioroffers.SampleJobOfferResponse;
import com.junioroffers.domain.offer.OfferFetchable;
import com.junioroffers.domain.offer.dto.JobOfferResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.List;

//import static com.junioroffers.features.SampleJobOfferResponse.bodyWithZeroOffersJson;

public class TypicalScenarioUserWantToSeeOffersIntegrationTest extends BaseIntegrationTest implements SampleJobOfferResponse {

    public static OfferFetchable offerFetchable;
    @Test
    public void user_want_to_see_offers_but_have_to_be_logged_in_and_external_server_should_have_some_offers(){
//    step 1: there are no offers in external HTTP server
        wireMockServer.stubFor(WireMock.get("/offers")
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", "application/json")
                        .withBody(bodyWithZeroOffersJson())));
       // List<JobOfferResponse> jobOfferResponses = offerFetchable.fetchAllOffers();

//        List<JobOfferResponse> jobOfferResponses = offerFetchable.fetchAllOffers();
//        wireMockServer.stubFor(WireMock.get("ec2-3-127-218-34.eu-central-1.compute.amazonaws.com:5057/offers")
//                .willReturn(WireMock.aResponse()
//                        .withStatus(HttpStatus.OK.value())
//                        .withHeader("Content-Type", "application/json")
//                        .withBody("""
//                                [
//                                    {
//                                        "title": "Junior Java Developer NOWA",
//                                        "company": "Netcompany Poland Sp. z o.o.",
//                                        "salary": null,
//                                        "offerUrl": "https://nofluffjobs.com/pl/job/junior-java-developer-netcompany-poland-warsaw-3"
//                                    },
//                                    {
//                                        "title": "Praktykant Java Developer NOWA",
//                                        "company": "Pentacomp Systemy Informatyczne S.A.",
//                                        "salary": null,
//                                        "offerUrl": "https://nofluffjobs.com/pl/job/praktykant-java-developer-pentacomp-systemy-informatyczne-warszawa"
//                                    },
//                                    {
//                                        "title": "Junior Java Backend Developer",
//                                        "company": "VHV Informatyka Sp. z o.o.",
//                                        "salary": null,
//                                        "offerUrl": "https://nofluffjobs.com/pl/job/junior-java-backend-developer-vhv-informatyka-warszawa"
//                                    },
//                                    {
//                                        "title": "Software Developer",
//                                        "company": "BrainworkZ",
//                                        "salary": null,
//                                        "offerUrl": "https://nofluffjobs.com/pl/job/software-developer-brainworkz-warsaw"
//                                    },
//                                    {
//                                        "title": "AI Engineer",
//                                        "company": "Strategy",
//                                        "salary": null,
//                                        "offerUrl": "https://nofluffjobs.com/pl/job/ai-engineer-strategy-warsaw"
//                                    },
//                                    {
//                                        "title": "Salesforce Developer - Force Academy",
//                                        "company": "Britenet",
//                                        "salary": null,
//                                        "offerUrl": "https://nofluffjobs.com/pl/job/salesforce-developer-force-academy-britenet-lublin-4"
//                                    },
//                                    {
//                                        "title": "Java Software Engineer NOWA",
//                                        "company": "VISA",
//                                        "salary": "Sprawdź zarobki",
//                                        "offerUrl": "https://nofluffjobs.com/pl/job/java-software-engineer-visa-warszawa"
//                                    },
//                                    {
//                                        "title": "Junior Software Engineer - Java NOWA",
//                                        "company": "VISA",
//                                        "salary": "Sprawdź zarobki",
//                                        "offerUrl": "https://nofluffjobs.com/pl/job/junior-software-engineer-java-visa-warszawa"
//                                    },
//                                    {
//                                        "title": "Intern - Java Developer with German NOWA",
//                                        "company": "Capgemini Polska Sp. z o.o.",
//                                        "salary": "Sprawdź zarobki",
//                                        "offerUrl": "https://nofluffjobs.com/pl/job/intern-java-developer-with-german-capgemini-polska-wroclaw"
//                                    },
//                                    {
//                                        "title": "Junior Java Developer with German NOWA",
//                                        "company": "Capgemini Polska Sp. z o.o.",
//                                        "salary": "Sprawdź zarobki",
//                                        "offerUrl": "https://nofluffjobs.com/pl/job/junior-java-developer-with-german-capgemini-polska-gdansk"
//                                    },
//                                    {
//                                        "title": "Junior Java Developer",
//                                        "company": "Bersi Sp. z o.o.",
//                                        "salary": "Sprawdź zarobki",
//                                        "offerUrl": "https://nofluffjobs.com/pl/job/junior-java-developer-bersi-bydgoszcz-3"
//                                    },
//                                    {
//                                        "title": "Junior .NET Backend Software Engineer NOWA",
//                                        "company": "VISA",
//                                        "salary": "Sprawdź zarobki",
//                                        "offerUrl": "https://nofluffjobs.com/pl/job/junior-net-backend-software-engineer-visa-warszawa-1"
//                                    },
//                                    {
//                                        "title": "Database Staff Software Engineer NOWA",
//                                        "company": "VISA",
//                                        "salary": "Sprawdź zarobki",
//                                        "offerUrl": "https://nofluffjobs.com/pl/job/database-staff-software-engineer-visa-warszawa"
//                                    },
//                                    {
//                                        "title": "Junior Android Developer 63428 NOWA",
//                                        "company": "Indeema Software",
//                                        "salary": "Sprawdź zarobki",
//                                        "offerUrl": "https://nofluffjobs.com/pl/job/junior-android-developer-63428-indeema-software-wroclaw-1"
//                                    },
//                                    {
//                                        "title": "Java Developer (with German) NOWA",
//                                        "company": "Capgemini Polska Sp. z o.o.",
//                                        "salary": "Sprawdź zarobki",
//                                        "offerUrl": "https://nofluffjobs.com/pl/job/java-developer-with-german-capgemini-polska-krakow-kavvfy59"
//                                    },
//                                    {
//                                        "title": "Java Developer",
//                                        "company": "Scalo",
//                                        "salary": null,
//                                        "offerUrl": "https://nofluffjobs.com/pl/job/java-developer-scalo-warszawa-qggrh5px"
//                                    },
//                                    {
//                                        "title": "Java Developer NOWA",
//                                        "company": "ASTEK Polska",
//                                        "salary": null,
//                                        "offerUrl": "https://nofluffjobs.com/pl/job/java-developer-astek-polska-lublin-txltjbtr"
//                                    },
//                                    {
//                                        "title": "Fullstack Java Developer NOWA",
//                                        "company": "Matrix Global Services",
//                                        "salary": null,
//                                        "offerUrl": "https://nofluffjobs.com/pl/job/fullstack-java-developer-matrix-global-services-remote-i3ym3lsw"
//                                    },
//                                    {
//                                        "title": "Cloud Data Engineer (Snowflake)",
//                                        "company": "Capgemini Polska Sp. z o.o.",
//                                        "salary": "Sprawdź zarobki",
//                                        "offerUrl": "https://nofluffjobs.com/pl/job/cloud-data-engineer-snowflake-capgemini-polska-krakow-3bq8x5yw"
//                                    },
//                                    {
//                                        "title": "Java Developer (with German) NOWA",
//                                        "company": "Capgemini Polska Sp. z o.o.",
//                                        "salary": "Sprawdź zarobki",
//                                        "offerUrl": "https://nofluffjobs.com/pl/job/java-developer-with-german-capgemini-polska-wroclaw-wz2dwg2i"
//                                    }
//                                ]
//                                          """.trim()
//                        )));

//    step 2: scheduler ran 1st time and made GET to external server and system added 0 offers to database
//    step 3: user tried to get JWT token by requesting POST /token with username=someUser, password=somePassword and system returned UNAUTHORIZED(401)
//    step 4: user made GET /offers with no jwt token and system returned UNAUTHORIZED(401)
//    step 5: user made POST /register with username=someUser, password=somePassword and system registered user with status OK(200)
//    step 6: user tried to get JWT token by requesting POST /token with username=someUser, password=somePassword and system returned OK(200) and jwttoken=AAAA.BBBB.CCC
//    step 7: user made GET /offers with header “Authorization: Bearer AAAA.BBBB.CCC” and system returned OK(200) with 0 offers
//    step 8: there are 2 new offers in external HTTP server
//    step 9: scheduler ran 2nd time and made GET to external server and system added 2 new offers with ids: 1000 and 2000 to database
//    step 10: user made GET /offers with header “Authorization: Bearer AAAA.BBBB.CCC” and system returned OK(200) with 2 offers with ids: 1000 and 2000
//    step 11: user made GET /offers/9999 and system returned NOT_FOUND(404) with message “Offer with id 9999 not found”
//    step 12: user made GET /offers/1000 and system returned OK(200) with offer
//    step 13: there are 2 new offers in external HTTP server
//    step 14: scheduler ran 3rd time and made GET to external server and system added 2 new offers with ids: 3000 and 4000 to database
//    step 15: user made GET /offers with header “Authorization: Bearer AAAA.BBBB.CCC” and system returned OK(200) with 4 offers with ids: 1000,2000, 3000 and 4000
    }
}
