//package nl.stalenhoef.coin.searchservice.controller;
//
//import nl.stalenhoef.coin.searchservice.model.Address;
//import nl.stalenhoef.coin.searchservice.model.SearchResult;
//import nl.stalenhoef.coin.searchservice.service.SearchService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import static org.hamcrest.core.Is.is;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(SearchController.class)
//@ContextConfiguration(classes = {SearchService.class})
//@WebAppConfiguration
//@EnableWebMvc
//public class SearchControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @Test
//    public void getSearchResult() throws Exception {
//
//        mvc.perform(get("/search/paulstalenhoef")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].currentPage", is("1")))
//                .andExpect(jsonPath("$[0].numberOfPages", is("1")))
//                .andExpect(jsonPath("$[0].addressList[0].id", is("1")));
//    }
//}
