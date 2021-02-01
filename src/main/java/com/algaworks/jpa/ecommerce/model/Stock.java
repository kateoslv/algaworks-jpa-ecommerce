package com.algaworks.jpa.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "stock")
@Entity
public class Stock {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;

    private Integer product;

    private Integer amount;

}
