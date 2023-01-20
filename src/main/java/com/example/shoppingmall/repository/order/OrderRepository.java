package com.example.shoppingmall.repository.order;

import com.example.shoppingmall.data.entity.Order;
import com.example.shoppingmall.data.entity.Product;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, OrderRepositoryCustom{

}
