package nl.stalenhoef.coin.searchservice.converter;

import nl.stalenhoef.coin.searchservice.model.Address;
import nl.stalenhoef.coin.searchservice.model.MongoSearchResult;

import java.util.ArrayList;
import java.util.List;

import static nl.stalenhoef.coin.searchservice.config.Config.NUMBER_OF_RESULTS_PER_PAGE;

public class Converter {
    public static List<Address> convertMongoResultToSearchResult(List<MongoSearchResult> results) {
        List<Address> addressList = new ArrayList<Address>();
        for (MongoSearchResult mongoResult : results) {
            addressList.add(convertAddress(mongoResult));
        }

        return addressList;
    }

    private static Address convertAddress(MongoSearchResult mongoResult) {
        Address address = new Address(
                mongoResult.getId(),
                mongoResult.getCompanyName(),
                mongoResult.getFirstName(),
                mongoResult.getLastName(),
                mongoResult.getAddress(),
                mongoResult.getGender(),
                mongoResult.getPhoneNumber()
        );

        return address;
    }

    public static int calculateNumberOfPages(Long totalNumber) {
        if (totalNumber < 0) {
            return 0;
        } else {
            return totalNumber.intValue() / NUMBER_OF_RESULTS_PER_PAGE
                    + (totalNumber % NUMBER_OF_RESULTS_PER_PAGE == 0 ? 0 : 1);
        }
    }


}
