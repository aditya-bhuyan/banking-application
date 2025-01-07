package com.bank.bankingapp.repository;

import com.bank.bankingapp.model.BankAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends MongoRepository<BankAccount, String> {
    // Custom query methods can be defined here if needed
}
