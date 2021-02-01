package com.algaworks.jpa.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "card_payment")
@Entity
public class CardPayment {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;

    @Column(name = "order_id")
    private Integer orderId;

    @Enumerated(EnumType.STRING)
    private StatusPayment status;

    private String number;

}
