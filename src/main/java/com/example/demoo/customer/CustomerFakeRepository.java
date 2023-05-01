package com.example.demoo.customer;

import java.util.Arrays;
import java.util.List;

public class CustomerFakeRepository implements CustomerRepo{
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "Harish Sarki", "password123,", "email@gmail.com"),
                new Customer(2L, "Aarush Sarki", "123password", "email@gmail.com")
        );
    }
}
