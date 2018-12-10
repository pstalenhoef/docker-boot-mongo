package nl.stalenhoef.coin.searchservice.validate;

public class InputValidator {

    public static boolean validateSearchTerm(String searchTerm) {
        return true;
    }

    public static boolean validatePageNr(int pagenr) {
        return (pagenr >= 0);
    }
}
