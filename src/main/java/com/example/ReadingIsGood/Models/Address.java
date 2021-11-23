package com.example.ReadingIsGood.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {

    private String country;
    private String city;
    private String discrict;
    private String adressText;
    private String postCode;
}
