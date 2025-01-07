package com.bank.bankingapp.service;

import com.bank.bankingapp.model.BankAccount;
import com.bank.bankingapp.repository.BankAccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class BankAccountServiceTest {

    @InjectMocks
    private BankAccountService bankAccountService;

    @Mock
    private BankAccountRepository bankAccountRepository;

    private BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        bankAccount = new BankAccount();
        bankAccount.setAccountNumber("123456789");
        bankAccount.setAccountType("Personal");
        bankAccount.setBalance(new BigDecimal(1000.00));
    }

    @Test
    void createBankAccountTest() {
        Mockito.when(bankAccountRepository.save(any(BankAccount.class))).thenReturn(bankAccount);

        BankAccount createdBankAccount = bankAccountService.createBankAccount(bankAccount);

        assertNotNull(createdBankAccount);
        assertEquals("123456789", createdBankAccount.getAccountNumber());
    }

    @Test
    void getBankAccountByIdTest() {
        Mockito.when(bankAccountRepository.findById("123456789")).thenReturn(Optional.of(bankAccount));

        Optional<BankAccount> foundBankAccount = bankAccountService.getBankAccountById("123456789");

        assertTrue(foundBankAccount.isPresent());
        assertEquals("123456789", foundBankAccount.get().getAccountNumber());
    }

    @Test
    void updateBankAccountTest() {
        Mockito.when(bankAccountRepository.save(any(BankAccount.class))).thenReturn(bankAccount);

        bankAccount.setBalance(new BigDecimal(1500.00));
        BankAccount updatedBankAccount = bankAccountService.updateBankAccount("123456789", bankAccount);

        assertEquals(1500.00, updatedBankAccount.getBalance());
    }

    @Test
    void deleteBankAccountTest() {
        Mockito.doNothing().when(bankAccountRepository).deleteById("123456789");

        bankAccountService.deleteBankAccount("123456789");

        Mockito.verify(bankAccountRepository, Mockito.times(1)).deleteById("123456789");
    }
}
