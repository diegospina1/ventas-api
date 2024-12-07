package com.commerce.application.repository;

import com.commerce.application.model.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

    @Query("select oi from OrderItem oi where oi.order.id = :#{#orderId}")
    List<OrderItem> findAllByOrderId(@Param("orderId") Integer orderId);
}
