package com.springbootcamp.ke.jpademoapp.repository;

import com.springbootcamp.ke.jpademoapp.dto.CustomCustomerQueryInt;
import com.springbootcamp.ke.jpademoapp.dto.CustomerOrderQueryInt;
import com.springbootcamp.ke.jpademoapp.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository  extends JpaRepository<Customer,Long> {
    List<Customer> findAllByGenderEqualsIgnoreCase(String gender);

//    List<Customer> findAllByGenderNotContainingIgnoreCase(String gender);

    List<CustomCustomerQueryInt> findAllByGenderNotContainingIgnoreCase(String gender);
//    List<CustomCustomerQueryInt> findAllByGenderNotContainingIgnoreCase(String gender, Pageable pageable);

    Page<CustomCustomerQueryInt> findAllByGenderNotContainingIgnoreCase(String gender, Pageable pageable);

    @Query("select s from Customer s where s.firstName= ?1 ")
    Optional<Customer> getCustomerbyFiRstName(String name);

    @Query(nativeQuery = true,value = "select * from customer_data where first_name= :name  ")
    Optional<Customer> getCustomerbyFirStName(String name);


    @Query(nativeQuery = true,
            value = "select c.first_name firstName, c.last_name lastName, c.email, co.order_id orderId from customer_data c" +
                    " JOIN customer_orders co ON c.id= co.customer_id ")
    List<CustomerOrderQueryInt> findAllCustomerOrder();
}
