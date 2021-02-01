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
@Table(name = "category")
@Entity
public class Category {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;

    private String name;

    private Integer category;

}
