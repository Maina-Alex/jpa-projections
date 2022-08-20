package com.springbootcamp.ke.jpademoapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbootcamp.ke.jpademoapp.dto.CustomCustomerQuery;
import com.springbootcamp.ke.jpademoapp.dto.CustomCustomerQueryInt;
import com.springbootcamp.ke.jpademoapp.dto.CustomerOrderQueryInt;
import com.springbootcamp.ke.jpademoapp.model.Customer;
import com.springbootcamp.ke.jpademoapp.model.CustomerOrder;
import com.springbootcamp.ke.jpademoapp.repository.CustomerOrderRepository;
import com.springbootcamp.ke.jpademoapp.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author Alex Maina
 * @created 20/08/2022
 **/
@SpringBootTest
@Slf4j
class JpaTest {
    @Autowired

    private CustomerRepository customerRepository;

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Test
     void getAllCustomerData(){
        List<Customer> customerList=customerRepository.findAll ();
         log.info ("customerData {}",customerList);
        assert (customerList.size ()>999);
    }


    @Test
    void getCustomerByGender(){
        List<Customer> customerList= customerRepository.findAllByGenderEqualsIgnoreCase ("female");
        log.info ("customerData {}",customerList);

    }
    @Test
    void getCustomerByNotInGender(){
        List<CustomCustomerQueryInt> customerList= customerRepository.findAllByGenderNotContainingIgnoreCase ("female");
        log.info ("customerData {}",customerList);
        log.info ("data size====> {}",customerList.size ());
    }

    @Test
    void getPaginatedCustomerDataTest(){
        Pageable pageable= PageRequest.of (10,20);
        Page<CustomCustomerQueryInt> customerPage= customerRepository.findAllByGenderNotContainingIgnoreCase ("male",pageable);
        log.info ("Customer data {}",customerPage);
        log.info ("data size====> {}",customerPage.getTotalElements ());

    }

    @Test
    void getAllCustomerOrders(){
        List<CustomerOrder> customerList =customerOrderRepository.findAll ();
//        log.info ("customerData {}",customerList);
        //select * from customer_order
        log.info ("data size====> {}",customerList.size ());
    }

    @Test
     void getJpqCustomerByName(){
        Optional<Customer> customer= customerRepository.getCustomerbyFiRstName ("Murdock");

        assert (customer.isPresent ());
    }
    @Test
     void getNAtiveCustomerByName(){
        Optional<Customer> customer= customerRepository.getCustomerbyFirStName("Murdock");
        assert (customer.isPresent ());
    }

    @Test
    void getCustomerOrder(){
        List<CustomerOrderQueryInt> customerOrders = customerRepository.findAllCustomerOrder ();
        assert(customerOrders.size ()!=0);
        customerOrders.forEach (co-> {
                log.info (" customer orders ===> {} {} {} {}",co.getFirstName (),co.getLastName (),co.getEmail (),co.getOrderId ());
        });
    }



}
