package com.example.shoppingmall.service;

import com.example.shoppingmall.data.dto.response.ResponseCart;
import com.example.shoppingmall.data.entity.User;

import java.util.List;

public interface CartService {
    List<ResponseCart> readCart(User user);

    List<ResponseCart> createCart(User user, Long product_id);

    List<ResponseCart> deleteCart(User user, Long product_id);
}
