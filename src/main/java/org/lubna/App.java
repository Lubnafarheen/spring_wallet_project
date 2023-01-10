package org.lubna;

import org.lubna.config.AppConfig;
import org.lubna.dao.AccountDao;
import org.lubna.dao.CustomerDao;
import org.lubna.model.Account;
import org.lubna.model.Customer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CustomerDao customerDao = context.getBean(CustomerDao.class);
        AccountDao accountDao = context.getBean(AccountDao.class);

        // create account
        Account lubnaAccount = accountDao.create(new Account(10));

        // create customer
        Customer customer = customerDao.create(new Customer("Lubna", "Farheen", lubnaAccount));
        System.out.println(customer);
    }
}
