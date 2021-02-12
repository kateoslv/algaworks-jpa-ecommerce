package com.algaworks.jpa.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class OrderItemId implements Serializable {

    @EqualsAndHashCode.Include
    @Column(name = "fk_order")
    private Integer idOrder;

    @EqualsAndHashCode.Include
    @Column(name = "fk_product")
    private Integer idProduct;

}
