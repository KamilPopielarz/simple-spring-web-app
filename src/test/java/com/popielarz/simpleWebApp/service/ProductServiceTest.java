package com.popielarz.simpleWebApp.service;

import com.popielarz.simpleWebApp.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    @Test
    public void testGetProducts(){
        ProductService productService = new ProductService();
        List<Product> products = productService.getProducts();
        Assertions.assertEquals(3,products.size());
    }

    @Test
    public void testGetProductsById(){
        ProductService productService = new ProductService();
        Product product103 = productService.getProductsById(103);
        Assertions.assertEquals(103,product103.getProdId());
        Assertions.assertEquals("Iphone 17",product103.getProdName());
        Assertions.assertEquals(6000,product103.getPrice());
    }

    @Test
    public void testGetProductsByIdMissingProduct(){
        // given
        ProductService productService = new ProductService();
        // when
        Product product103 = productService.getProductsById(-1);
        // then
        Assertions.assertEquals(100,product103.getProdId());
        Assertions.assertEquals("No Item",product103.getProdName());
        Assertions.assertEquals(0,product103.getPrice());
    }

    @Test
    public void testAddProduct(){
        // given
        ProductService productService = new ProductService();
        Product newProduct = new Product(104, "Ip 11 pro max", 4000);
        // when
        productService.addProduct(newProduct);
        // then
        List<Product> products = productService.getProducts();
        Assertions.assertEquals(4,products.size());
        Product product104 = productService.getProductsById(104);
        Assertions.assertEquals(104, product104.getProdId());
        Assertions.assertEquals("Ip 11 pro max", product104.getProdName());
        Assertions.assertEquals(4000, product104.getPrice());
    }

    @Test
    public void testDeleteProduct(){
        // given
        ProductService productService = new ProductService();
        // when
        productService.deleteProduct(102);
        // then
        List<Product> products = productService.getProducts();
        Assertions.assertEquals(2,products.size());
        Product product103 = productService.getProductsById(102);
        Assertions.assertEquals(100,product103.getProdId());
        Assertions.assertEquals("No Item",product103.getProdName());
        Assertions.assertEquals(0,product103.getPrice());

    }


}