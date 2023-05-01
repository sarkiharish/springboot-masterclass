package com.example.demoo.customer;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

//public class CustomerRepository implements CustomerRepo{
//    @Override
//    public List<Customer> getCustomers() {
//        //TODO connect to real db
////         return Collections.emptyList();
//        return Collections.singletonList(
//                new Customer(1L, "TODO. IMPLEMENTING REAL DB HARI.", "todo", "email@gmail.com")
//        );
//    }
//}

@Repository
public interface CustomerRepository
        extends JpaRepository<Customer, Long> {

}
