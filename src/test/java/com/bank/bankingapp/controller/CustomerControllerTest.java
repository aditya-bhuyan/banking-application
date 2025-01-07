package com.bank.bankingapp.controller;

import com.bank.bankingapp.model.Customer;
import com.bank.bankingapp.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer();
        customer.setId("1");
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");
        customer.setPhone("123456789");
        customer.setAddress("123 Main St");
    }

    @Test
    void testGetAllCustomers() throws Exception {
        // Arrange
        when(customerService.getAllCustomers()).thenReturn(Arrays.asList(customer));

        // Act & Assert
        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/customer-list"))
                .andExpect(model().attribute("customers", Arrays.asList(customer)));

        verify(customerService, times(1)).getAllCustomers();
    }

    @Test
    void testShowCreateForm() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/customers/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/customer-create"))
                .andExpect(model().attributeExists("customer"));
    }

    @Test
    void testCreateCustomer() throws Exception {
        // Arrange
        when(customerService.createCustomer(any(Customer.class))).thenReturn(customer);

        // Act & Assert
        mockMvc.perform(post("/customers")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "John Doe")
                        .param("email", "john.doe@example.com")
                        .param("phone", "123456789")
                        .param("address", "123 Main St"))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", "/customers"));

        verify(customerService, times(1)).createCustomer(any(Customer.class));
    }

    @Test
    void testShowCustomerDetail() throws Exception {
        // Arrange
        when(customerService.getCustomerById("1")).thenReturn(Optional.of(customer));

        // Act & Assert
        mockMvc.perform(get("/customers/{id}", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/customer-detail"))
                .andExpect(model().attribute("customer", customer));

        verify(customerService, times(1)).getCustomerById("1");
    }

    @Test
    void testShowEditForm() throws Exception {
        // Arrange
        when(customerService.getCustomerById("1")).thenReturn(Optional.of(customer));

        // Act & Assert
        mockMvc.perform(get("/customers/{id}/edit", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/customer-edit"))
                .andExpect(model().attribute("customer", customer));

        verify(customerService, times(1)).getCustomerById("1");
    }

    @Test
    void testUpdateCustomer() throws Exception {
        // Arrange
        when(customerService.updateCustomer(eq("1"), any(Customer.class))).thenReturn(customer);

        // Act & Assert
        mockMvc.perform(post("/customers/{id}/edit", "1")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "Updated John Doe")
                        .param("email", "updated.john.doe@example.com")
                        .param("phone", "987654321")
                        .param("address", "456 Updated St"))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", "/customers"));

        verify(customerService, times(1)).updateCustomer(eq("1"), any(Customer.class));
    }

    @Test
    void testDeleteCustomer() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/customers/{id}/delete", "1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", "/customers"));

        verify(customerService, times(1)).deleteCustomer("1");
    }
}
