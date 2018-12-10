package nl.stalenhoef.coin.searchservice.repository;

import nl.stalenhoef.coin.searchservice.model.MongoSearchResult;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SearchRepository extends MongoRepository<MongoSearchResult, String> {

    MongoSearchResult findBy_id(ObjectId _id);

    List<MongoSearchResult> findAll();

    @Query("{$or: [ {'companyName' : { $regex: ?0, $options: 'i' }}, {'firstName' : { $regex: ?0, $options: 'i' }}, {'lastName' : { $regex: ?0, $options: 'i' }}]}")
    List<MongoSearchResult> findUsersByRegexpName(String regexp);

    @Query("{$or: [ {'companyName' : { $regex: ?0, $options: 'i' }}, {'firstName' : { $regex: ?0, $options: 'i' }}, {'lastName' : { $regex: ?0, $options: 'i' }}]}")
    List<MongoSearchResult> findUsersByRegexpName(String regexp, Pageable pageable);

    @Query(value = "{$or: [ {'companyName' : { $regex: ?0, $options: 'i' }}, {'firstName' : { $regex: ?0, $options: 'i' }}, {'lastName' : { $regex: ?0, $options: 'i' }}]}", count = true)
    Long countUsersByRegexpName(String regexp);
}

