package com.algaworks.jpa.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "invoice")
@Entity
public class Invoice {

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "fk_order")
    private Integer id;

    @MapsId
    @OneToOne(optional = false)
    @JoinColumn(name = "fk_order")
    private Order order;

    private String xml;

    @Column(name = "issue_date")
    private Date issueDate;

}
