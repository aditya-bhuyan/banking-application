package com.bank.bankingapp.service;

import com.bank.bankingapp.model.BankAccount;
import com.bank.bankingapp.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    @Autowired
    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public List<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll();
    }

    public Optional<BankAccount> getBankAccountById(String id) {
        return bankAccountRepository.findById(id);
    }

    public BankAccount createBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    public BankAccount updateBankAccount(String id, BankAccount bankAccount) {
        bankAccount.setAccountNumber(id);
        return bankAccountRepository.save(bankAccount);
    }

    public void deleteBankAccount(String id) {
        bankAccountRepository.deleteById(id);
    }
}
