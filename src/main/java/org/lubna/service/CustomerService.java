package org.lubna.service;

import org.lubna.exception.DataNotFoundException;
import org.lubna.model.Customer;

public interface CustomerService {

    Customer registerCustomer(Customer customerData);

    Customer findById(Long id) throws DataNotFoundException;
}
