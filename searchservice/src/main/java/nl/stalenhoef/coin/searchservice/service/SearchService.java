package nl.stalenhoef.coin.searchservice.service;

import nl.stalenhoef.coin.searchservice.converter.Converter;
import nl.stalenhoef.coin.searchservice.model.Address;
import nl.stalenhoef.coin.searchservice.model.MongoSearchResult;
import nl.stalenhoef.coin.searchservice.model.SearchResult;
import nl.stalenhoef.coin.searchservice.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static nl.stalenhoef.coin.searchservice.config.Config.NUMBER_OF_RESULTS_PER_PAGE;

@Service
public class SearchService {

    @Autowired
    SearchRepository searchRepository;

    public SearchResult getSearchResult(String searchTerm) {
        return getPagedSearchResult(searchTerm, 1);
    }

    public SearchResult getPagedSearchResult(String searchTerm, int pagenr) {

        Long totalNumber = this.searchRepository.countUsersByRegexpName(searchTerm);
        int numberOfPages = Converter.calculateNumberOfPages(totalNumber);

        List<MongoSearchResult> results = this.searchRepository.findUsersByRegexpName(searchTerm , new PageRequest((pagenr - 1), NUMBER_OF_RESULTS_PER_PAGE));
        List<Address> addresses = Converter.convertMongoResultToSearchResult(results);

        return new SearchResult(pagenr, numberOfPages, addresses);
    }

    private List<Address> createDummyAddressList() {
        Address address1 = new Address("1", null, "Paul", "Stalenhoef","Beiershof 72", "Male", "+31629528468");
        Address address2 = new Address("2", null, "Liesbeth", "De Wolf","Beiershof 72", "Male", null);

        List<Address> addressList = new ArrayList<Address>();
        addressList.add(address1);
        addressList.add(address2);
        return addressList;
    }
}
