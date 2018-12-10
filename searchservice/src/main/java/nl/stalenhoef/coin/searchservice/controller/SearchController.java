package nl.stalenhoef.coin.searchservice.controller;

import nl.stalenhoef.coin.searchservice.model.SearchResult;
import nl.stalenhoef.coin.searchservice.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

//    @Autowired
//    private InputValidator inputValidator;

    @GetMapping("/{searchTerm}")
    @ResponseBody
    public SearchResult getSearchResult(@PathVariable("searchTerm") String searchTerm) {

        return searchService.getSearchResult(searchTerm);
    }

    @GetMapping("/{searchTerm}/{pagenr}")
    @ResponseBody
    public SearchResult getSearchResult(@PathVariable("searchTerm") String searchTerm, @PathVariable("pagenr") int pagenr) {
        return searchService.getPagedSearchResult(searchTerm, pagenr);
    }
}
