package org.lubna.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lubna.config.AppConfig;
import org.lubna.exception.DataNotFoundException;
import org.lubna.model.Account;
import org.lubna.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class CustomerServiceTest {

    @Autowired
    CustomerService testObject;

    Customer customerTom;


    @BeforeEach
    public void setUp() {
        Account accountData = new Account(10);
        Customer tom = new Customer("Tom", "Andersson", accountData);
        customerTom = testObject.registerCustomer(tom);
    }

    @Test
    public void testFindById(){
        assertDoesNotThrow( () -> testObject.findById(customerTom.getId()));
    }


}
