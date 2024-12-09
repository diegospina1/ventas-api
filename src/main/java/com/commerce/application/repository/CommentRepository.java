package com.commerce.application.repository;

import com.commerce.application.model.document.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment, Integer> {

    @Query("{ 'customer.id': ?0 }")
    List<Comment> findCommentsByCustomerId(Integer customerId);

    @Query("{ 'product.id': ?0 }")
    List<Comment> findCommentsByProductId(Integer id);
}
