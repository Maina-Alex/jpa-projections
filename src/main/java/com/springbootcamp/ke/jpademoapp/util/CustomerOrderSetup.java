package com.springbootcamp.ke.jpademoapp.util;

import com.springbootcamp.ke.jpademoapp.model.CustomerOrder;
import com.springbootcamp.ke.jpademoapp.repository.CustomerOrderRepository;
import com.springbootcamp.ke.jpademoapp.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Alex Maina
 * @created 20/08/2022
 **/
@Component
@RequiredArgsConstructor
public class CustomerOrderSetup {
    private final CustomerOrderRepository customerOrderRepository;
    private final CustomerRepository customerRepository;

//    @PostConstruct
//    public  void generateCustomerOrder(){
//        customerOrderRepository.deleteAll ();
//        customerRepository.findAll ().forEach (customer-> {
//                    List<CustomerOrder> customerOrderList= new ArrayList<> ();
//                    for(int i=0; i<5;i++){
//                        CustomerOrder customerOrder= new CustomerOrder (UUID.randomUUID ().toString (),customer);
//                        customerOrderList.add (customerOrder);
//                        customerOrderRepository.save (customerOrder);
//                    }
//                });
//    }
}
