package com.popielarz.simpleWebApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@AllArgsConstructor
@Component
public class Product {

    private int prodId;
    private String prodName;
    private int price;

    public Product(){} //Dlaczego bez tej metody to nie działa? Co ona zmienia? Bez niej wywala błąd, że prodId musi być intem, a przecież jest intem (np 101)??


}
