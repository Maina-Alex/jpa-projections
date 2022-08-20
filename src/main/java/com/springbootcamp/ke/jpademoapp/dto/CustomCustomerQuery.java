package com.springbootcamp.ke.jpademoapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Alex Maina
 * @created 20/08/2022
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomCustomerQuery {
    private String firstName;
    private String lastName;
}
