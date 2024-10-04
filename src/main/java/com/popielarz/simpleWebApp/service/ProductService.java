package com.popielarz.simpleWebApp.service;

import com.popielarz.simpleWebApp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = Arrays.asList(
            new Product(101, "Iphone 16", 5000),
            new Product(102, "Iphone 16 plus", 5500),
            new Product(103, "Iphone 17", 6000));

    public List<Product> getProducts() {
        return products;
    }
}
