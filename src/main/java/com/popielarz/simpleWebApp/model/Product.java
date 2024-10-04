package com.popielarz.simpleWebApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Data
@AllArgsConstructor
@Component
@NoArgsConstructor
public class Product {

    private int prodId;
    private String prodName;
    private int price;



}
