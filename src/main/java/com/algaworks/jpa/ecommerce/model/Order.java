package com.algaworks.jpa.ecommerce.model;

import com.algaworks.jpa.ecommerce.listener.GenerateInvoiceListener;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "ordering")
@EntityListeners({GenerateInvoiceListener.class})
@Entity
public class Order {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_client")
    private Client client;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @Column(name = "conclusion_date")
    private LocalDateTime conclusionDate;

    @OneToOne(mappedBy = "order")
    private Invoice invoice;

    @OneToOne(mappedBy = "order")
    private CardPayment payment;

    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    private StatusOrder status;

    @Embedded
    private OrderDeliveryAddress deliveryAddress;

    public boolean isPaid() {
        return StatusOrder.PAID.equals(status);
    }

}
