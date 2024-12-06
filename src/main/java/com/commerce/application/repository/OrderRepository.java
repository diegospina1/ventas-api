package com.commerce.application.repository;

import com.commerce.application.model.entity.Customer;
import com.commerce.application.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    @Query("select o from Order o where o.customer.id = :#{#id}")
    List<Order> findAllByCustomerId(@Param("id") Integer id);
}
