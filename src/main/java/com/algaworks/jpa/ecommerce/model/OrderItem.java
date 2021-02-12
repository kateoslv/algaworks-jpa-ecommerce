package com.algaworks.jpa.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "order_item")
@Entity
public class OrderItem {

    @EmbeddedId
    private OrderItemId id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_order", insertable = false, updatable = false)
    private Order order;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_product", insertable = false, updatable = false)
    private Product product;

    @Column(name = "product_price")
    private BigDecimal productPrice;

    private Integer amount;

}
