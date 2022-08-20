package com.springbootcamp.ke.jpademoapp.repository;

import com.springbootcamp.ke.jpademoapp.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepository  extends JpaRepository<CustomerOrder,Long> {
}
