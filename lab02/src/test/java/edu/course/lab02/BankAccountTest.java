package edu.course.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankAccountTest {

    @Test
    void successfulDepositAndWithdraw() {
        BankAccount account = new BankAccount(100);
        account.deposit(50);
        assertEquals(150, account.getBalance());

        account.withdraw(40);
        assertEquals(110, account.getBalance());
    }

    @Test
    void throwsExceptionOnNegativeInitialBalance() {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount(-10));
    }

    @Test
    void throwsExceptionOnOverdraw() {
        BankAccount account = new BankAccount(50);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(100));
    }
}