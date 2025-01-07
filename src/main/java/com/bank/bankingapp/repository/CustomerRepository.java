package com.bank.bankingapp.repository;

import com.bank.bankingapp.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    // Custom query methods can be defined here if needed
}
