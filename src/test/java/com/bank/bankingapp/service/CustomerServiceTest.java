package com.bank.bankingapp.service;

import com.bank.bankingapp.model.Customer;
import com.bank.bankingapp.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    private Customer customer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        customer = new Customer();
        customer.setId("1");
        customer.setName("John Doe");
        customer.setEmail("johndoe@example.com");
        customer.setPhone("1234567890");
        customer.setAddress("123 Main St");
    }

    @Test
    void createCustomerTest() {
        Mockito.when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        Customer createdCustomer = customerService.createCustomer(customer);

        assertNotNull(createdCustomer);
        assertEquals("John Doe", createdCustomer.getName());
        assertEquals("johndoe@example.com", createdCustomer.getEmail());
    }

    @Test
    void getCustomerByIdTest() {
        Mockito.when(customerRepository.findById("1")).thenReturn(Optional.of(customer));

        Optional<Customer> foundCustomer = customerService.getCustomerById("1");

        assertTrue(foundCustomer.isPresent());
        assertEquals("John Doe", foundCustomer.get().getName());
    }

    @Test
    void updateCustomerTest() {
        Mockito.when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        customer.setName("Jane Doe");
        Customer updatedCustomer = customerService.updateCustomer("1", customer);

        assertEquals("Jane Doe", updatedCustomer.getName());
    }

    @Test
    void deleteCustomerTest() {
        Mockito.doNothing().when(customerRepository).deleteById("1");

        customerService.deleteCustomer("1");

        Mockito.verify(customerRepository, Mockito.times(1)).deleteById("1");
    }
}
