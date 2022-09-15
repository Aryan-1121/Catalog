package com.order.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.bean.OrderItem;
@Repository
public interface OrderItemDao extends JpaRepository<OrderItem, Long>{

}



