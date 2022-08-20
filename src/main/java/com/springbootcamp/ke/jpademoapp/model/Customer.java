package com.springbootcamp.ke.jpademoapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Alex Maina
 * @created 20/08/2022
 **/
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "customer_data")
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String walletAddress;
    private String creditCard;
    private String location;
//    @OneToMany(mappedBy = "customer")
//    private List<CustomerOrder> customerOrderList;
}
