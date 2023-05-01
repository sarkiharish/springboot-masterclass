package com.example.demoo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository;
    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {

        //given
        Customer hira = new Customer(
                1L,
                "hira",
                "hira123",
                "hira@gmail.com"
        );
        Customer ana = new Customer(
                2L,
                "ana",
                "ana123",
                "ana@gmail.com"
        );

        customerRepository.saveAll(Arrays.asList(hira, ana));

        //when
        List<Customer> customers = underTest.getCustomers();

        //then
        assertEquals(2, customers.size());
    }

    @Test
    void getCustomer() {

        //given
        Customer hira = new Customer(
                1L,
                "hira",
                "hira123",
                "hira@gmail.com"
        );

        customerRepository.save(hira);

        //when
        Customer actual = underTest.getCustomer(1L);

        //then
        assertEquals(1L, actual.getId());
        assertEquals("hira", actual.getName());
        assertEquals("hira123", actual.getPassword());
        assertEquals("hira@gmail.com", actual.getEmail());
    }
}