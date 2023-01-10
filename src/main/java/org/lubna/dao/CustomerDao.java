package org.lubna.dao;

import org.lubna.model.Customer;

import java.util.List;

public interface CustomerDao extends BaseDao<Customer, Long>{

    List<Customer> findByName(String firstName);
}
