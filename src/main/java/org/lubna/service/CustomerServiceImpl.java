package org.lubna.service;

import org.lubna.dao.AccountDao;
import org.lubna.dao.CustomerDao;
import org.lubna.exception.DataNotFoundException;
import org.lubna.model.Account;
import org.lubna.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceImpl implements CustomerService{

    AccountDao accountDao;
    CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(AccountDao accountDao, CustomerDao customerDao) {
        this.accountDao = accountDao;
        this.customerDao = customerDao;
    }

    @Override
    public Customer registerCustomer(Customer customerData) {
        if(customerData == null) throw new IllegalArgumentException("Customer data was null");
        if(customerData.getAccount() == null) throw new IllegalArgumentException("Account data was null");
        Account accountData = customerData.getAccount();
        Account createdAccount = accountDao.create(accountData);
        customerData.setAccount(createdAccount);

        Customer createdCustomer = customerDao.create(customerData);
        return createdCustomer;
    }

    @Override
    public Customer findById(Long id) throws DataNotFoundException {
        if(id == null) throw new IllegalArgumentException("Customer id was null");
        return customerDao.findById(id).orElseThrow(()->new DataNotFoundException("Data not found"));
    }
}
