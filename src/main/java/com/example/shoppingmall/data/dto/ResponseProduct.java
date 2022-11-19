package com.example.shoppingmall.data.dto;

import com.example.shoppingmall.data.entity.Product;
import com.example.shoppingmall.data.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseProduct {
    private Long id;

    private String name;

    private int price;

    @JsonProperty("user_id")
    private Long userId;
}
