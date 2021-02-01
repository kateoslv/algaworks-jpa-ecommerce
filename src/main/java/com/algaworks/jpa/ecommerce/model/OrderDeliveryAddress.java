package com.algaworks.jpa.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class OrderDeliveryAddress {

    @Column(name = "postal_code")
    private String postalCode;

    private String neighborhood;

    private Integer number;

    private String city;

    private String state;

}
