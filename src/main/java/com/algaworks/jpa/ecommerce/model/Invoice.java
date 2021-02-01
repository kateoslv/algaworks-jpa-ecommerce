package com.algaworks.jpa.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    private Integer id;

    @Column(name = "order_id")
    private Integer orderId;

    private String xml;

    @Column(name = "issue_date")
    private Date issueDate;

}
