package com.algaworks.jpa.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemId implements Serializable {

    @EqualsAndHashCode.Include
    private Integer idOrder;

    @EqualsAndHashCode.Include
    private Integer idProduct;

}
