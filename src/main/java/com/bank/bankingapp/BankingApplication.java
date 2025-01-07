package com.bank.bankingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.bank.bankingapp","com.bank.bankingapp.service","com.bank.bankingapp.controller","com.bank.bankingapp.model","com.bank.bankingapp.repository"})
public class BankingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankingApplication.class, args);
    }

}
