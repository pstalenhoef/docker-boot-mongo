package nl.stalenhoef.coin.searchservice.converter;

import nl.stalenhoef.coin.searchservice.model.Address;
import nl.stalenhoef.coin.searchservice.model.MongoSearchResult;
import nl.stalenhoef.coin.searchservice.model.SearchResult;
import org.junit.Test;
import org.xmlunit.util.Convert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ConverterTest {

    @Test
    public void convertMongoResultToSearchResult() {
        MongoSearchResult mongoSearchResult = new MongoSearchResult(null, "1","companyName",
                "firstName", "lastName", "address", "+123456789", "Male");
        List<MongoSearchResult> mongoSearchResultList = new ArrayList<>();
        mongoSearchResultList.add(mongoSearchResult);

        List<Address> addressList = Converter.convertMongoResultToSearchResult(mongoSearchResultList);

        assertEquals(1, addressList.size());
        assertEquals("1", addressList.get(0).getId());
        assertEquals("companyName", addressList.get(0).getCompanyName());
        assertEquals("firstName", addressList.get(0).getFirstName());
        assertEquals("lastName", addressList.get(0).getLastName());
        assertEquals("address", addressList.get(0).getAddress());
        assertEquals("+123456789", addressList.get(0).getPhoneNumber());
        assertEquals("Male", addressList.get(0).getGender());

    }

    @Test
    public void calculateNumberOfPagesNoResults() {
        assertEquals(0, Converter.calculateNumberOfPages(0L));
    }

    @Test
    public void calculateNumberOfPagesNegativeResult() {
        assertEquals(0, Converter.calculateNumberOfPages(-1L));
    }

    @Test
    public void calculateNumberOfPagesOneResult() {
        assertEquals(1, Converter.calculateNumberOfPages(1L));
    }

    @Test
    public void calculateNumberOfPagesNineResults() {
        assertEquals(1, Converter.calculateNumberOfPages(9L));
    }

    @Test
    public void calculateNumberOfPagesTenResults() {
        assertEquals(1, Converter.calculateNumberOfPages(10L));
    }

    @Test
    public void calculateNumberOfPagesElevenResults() {
        assertEquals(2, Converter.calculateNumberOfPages(11L));
    }

    @Test
    public void calculateNumberOfPagesNineteenResults() {
        assertEquals(2, Converter.calculateNumberOfPages(19L));
    }

    @Test
    public void calculateNumberOfPagesTwentyResults() {
        assertEquals(2, Converter.calculateNumberOfPages(20L));
    }

    @Test
    public void calculateNumberOfPagesTwentyOneResults() {
        assertEquals(3, Converter.calculateNumberOfPages(21L));
    }
}