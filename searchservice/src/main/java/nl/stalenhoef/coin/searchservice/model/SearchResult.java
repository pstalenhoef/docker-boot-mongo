package nl.stalenhoef.coin.searchservice.model;

import java.util.List;

public class SearchResult {

    private final int currentPage;
    private final int numberOfPages;
    private final List<Address> addressList;

    public SearchResult(int currentPage, int numberOfPages, List<Address> addressList) {
        this.currentPage = currentPage;
        this.numberOfPages = numberOfPages;
        this.addressList = addressList;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public List<Address> getAddressList() {
        return addressList;
    }
}
