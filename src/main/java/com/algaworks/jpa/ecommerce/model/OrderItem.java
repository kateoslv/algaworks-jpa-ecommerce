package com.algaworks.jpa.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@IdClass(OrderItemId.class)
@Table(name = "order_item")
@Entity
public class OrderItem {

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "fk_order")
    private Integer idOrder;

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "fk_product")
    private Integer idProduct;

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
