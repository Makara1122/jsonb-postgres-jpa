package org.example.hybernatev6jsonbjpa.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Address {
    private String city;
    private String zipCode;
}
