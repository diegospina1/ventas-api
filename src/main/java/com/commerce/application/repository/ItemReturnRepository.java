package com.commerce.application.repository;

import com.commerce.application.dto.itemReturn.ItemReturnDto;
import com.commerce.application.model.entity.ItemReturn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface ItemReturnRepository extends JpaRepository<ItemReturn, Integer> {

    @Query("select it from ItemReturn it where it.orderItem.order.customer.id = :id")
    List<ItemReturn> findAllByCustomerId(Integer id);

    @Query("select it from ItemReturn it where it.orderItem.product.id = :id")
    List<ItemReturn> findAllByProductId(Integer id);
}
