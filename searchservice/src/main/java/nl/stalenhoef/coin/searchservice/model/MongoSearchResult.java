package nl.stalenhoef.coin.searchservice.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "address")
public class MongoSearchResult {

    @Id
    private final ObjectId _id;

    private final String id;

    private final String companyName;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String phoneNumber;
    private final String gender;

    public MongoSearchResult(ObjectId _id, String id, String companyName, String firstName, String lastName, String address, String phoneNumber, String gender) {
        this._id = _id;
        this.id = id;
        this.companyName = companyName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String get_Id() {
        return _id.toHexString();
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
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

    public String getGender() {
        return gender;
    }
}
