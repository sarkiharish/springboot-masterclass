package com.example.demoo.customer;

import com.example.demoo.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    private  final  CustomerRepository customerRepository;

//    @Autowired
//    public CustomerService(
//            CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }

    List<Customer> getCustomers() {
//        return new Customer(1L, "Harish Sarki");
        log.info("getCustomers was called");
        return customerRepository.findAll();
    }

    Customer getCustomer(Long id) {
//
        return customerRepository
                .findById(id)
                .orElseThrow(
                        () -> {

                            NotFoundException notFoundException = new NotFoundException(
                                    "customer with id " + id + " doesn't exist!");
                            log.error("Error in getting customer {}", id, notFoundException);
                            return notFoundException;
                        });
    }
}
