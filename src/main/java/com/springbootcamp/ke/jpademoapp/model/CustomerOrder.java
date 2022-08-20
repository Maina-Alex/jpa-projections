package com.springbootcamp.ke.jpademoapp.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author Alex Maina
 * @created 20/08/2022
 **/
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "customer_orders")
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String orderId;
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    public CustomerOrder(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
    }
}
