package com.bank.bankingapp.controller;

import com.bank.bankingapp.model.BankAccount;
import com.bank.bankingapp.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/bank-accounts")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @Autowired
    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping
    public String getAllBankAccounts(Model model) {
        List<BankAccount> bankAccounts = bankAccountService.getAllBankAccounts();
        model.addAttribute("bankAccounts", bankAccounts);
        return "bankaccount/bank-account-list";  // Returns the Thymeleaf template for the bank account list
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("bankAccount", new BankAccount());  // Empty form object to bind to
        return "bankaccount/bank-account-create";  // Thymeleaf template to render the form
    }

    @PostMapping
    public String createBankAccount(@ModelAttribute BankAccount bankAccount) {
        bankAccountService.createBankAccount(bankAccount);  // Create the new bank account
        return "redirect:/bank-accounts";  // Redirect to the list of bank accounts after creation
    }

    @GetMapping("/{id}")
    public String showBankAccountDetail(@PathVariable String id, Model model) {
        Optional<BankAccount> bankAccount = bankAccountService.getBankAccountById(id);
        if (bankAccount.isPresent()) {
            model.addAttribute("bankAccount", bankAccount.get());
            return "bankaccount/bank-account-detail";  // Thymeleaf template for displaying account details
        }
        return "redirect:/bank-accounts";  // Redirect if the account is not found
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable String id, Model model) {
        Optional<BankAccount> bankAccount = bankAccountService.getBankAccountById(id);
        if (bankAccount.isPresent()) {
            model.addAttribute("bankAccount", bankAccount.get());
            return "bankaccount/bank-account-edit";  // Thymeleaf template for editing the bank account
        }
        return "redirect:/bank-accounts";  // Redirect if the account is not found
    }

    @PostMapping("/{id}/edit")
    public String updateBankAccount(@PathVariable String id, @ModelAttribute BankAccount bankAccount) {
        bankAccountService.updateBankAccount(id, bankAccount);  // Update the bank account
        return "redirect:/bank-accounts";  // Redirect to the list of bank accounts after updating
    }

    @GetMapping("/{id}/delete")
    public String deleteBankAccount(@PathVariable String id) {
        bankAccountService.deleteBankAccount(id);  // Delete the bank account
        return "redirect:/bank-accounts";  // Redirect to the list of bank accounts after deletion
    }
}
