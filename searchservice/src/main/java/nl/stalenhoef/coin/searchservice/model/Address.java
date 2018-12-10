package nl.stalenhoef.coin.searchservice.model;

public class Address {
    private final String id;
    private final String companyName;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String gender;
    private final String phoneNumber;

    public Address(String id, String companyName, String firstName, String lastName, String address, String gender, String phoneNumber) {
        this.id = id;
        this.companyName = companyName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
