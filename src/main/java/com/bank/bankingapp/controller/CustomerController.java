package com.bank.bankingapp.controller;

import com.bank.bankingapp.model.Customer;
import com.bank.bankingapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String getAllCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customer/customer-list";  // Returns the Thymeleaf template for the customer list
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());  // Empty form object to bind to
        return "customer/customer-create";  // Thymeleaf template to render the form
    }

    @PostMapping
    public String createCustomer(@ModelAttribute Customer customer) {
        customerService.createCustomer(customer);  // Create the new customer
        return "redirect:/customers";  // Redirect to the list of customers after creation
    }

    @GetMapping("/{id}")
    public String showCustomerDetail(@PathVariable String id, Model model) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        if (customer.isPresent()) {
            model.addAttribute("customer", customer.get());
            return "customer/customer-detail";  // Thymeleaf template for displaying customer details
        }
        return "redirect:/customers";  // Redirect if the customer is not found
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable String id, Model model) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        if (customer.isPresent()) {
            model.addAttribute("customer", customer.get());
            return "customer/customer-edit";  // Thymeleaf template for editing the customer
        }
        return "redirect:/customers";  // Redirect if the customer is not found
    }

    @PostMapping("/{id}/edit")
    public String updateCustomer(@PathVariable String id, @ModelAttribute Customer customer) {
        customerService.updateCustomer(id, customer);  // Update the customer
        return "redirect:/customers";  // Redirect to the list of customers after updating
    }

    @GetMapping("/{id}/delete")
    public String deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);  // Delete the customer
        return "redirect:/customers";  // Redirect to the list of customers after deletion
    }
}
