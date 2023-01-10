package org.lubna.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lubna.config.AppConfig;
import org.lubna.exception.DataNotFoundException;
import org.lubna.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class AccountDaoTest {

    @Autowired
    AccountDao testAccountDoa;

    Account tomAccount;
    Account LisaAccount;

    @BeforeEach
    public void setUp() {
        Account tom = new Account(1000);
        tomAccount = testAccountDoa.create(tom);

        Account lisa = new Account(500);
        LisaAccount = testAccountDoa.create(lisa);
    }

    @Test
    void testFindAll_ShouldReturnListOfAccounts() {
        int expected = 2;
        int actual = testAccountDoa.findAll().size();
        assertEquals(expected, actual);
    }

    @Test
    void testFindById_ShouldReturnAccount() {

        Account expected = new Account(tomAccount.getId(), 1000);
        Optional<Account> result = testAccountDoa.findById(tomAccount.getId());
        Account actual = result.orElse(null);
        assertEquals(expected, actual);

    }

    @Test
    void testRemove_ShouldDeleteAccount() {
        assertDoesNotThrow(() -> {
            testAccountDoa.remove(tomAccount.getId());
        });
    }

    @Test
    void testRemove_throwsException() {
        assertThrows(DataNotFoundException.class, () ->
                testAccountDoa.remove(1L)
        );
    }


}
