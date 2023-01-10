package org.lubna.dao.impl;

import org.lubna.dao.CustomerDao;
import org.lubna.dao.sequencer.CustomerIdSequencer;
import org.lubna.exception.DataNotFoundException;
import org.lubna.model.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.lubna.dao.sequencer.CustomerIdSequencer.*;

@Component
public class CustomerDaoImpl implements CustomerDao {

    private final List<Customer> storage = new ArrayList<>();

    @Override
    public Customer create(Customer customer) {
        if (customer == null) throw new IllegalArgumentException("Customer was null");
        long customerId = nextId();
        customer.setId(customerId);
        storage.add(customer);
        return customer;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        if (id == null) throw new IllegalArgumentException("Customer ID was null");
        return storage.stream().filter(account -> account.getId() == id).findFirst();
    }

    @Override
    public Collection<Customer> findAll() {
        return storage;
    }

    @Override
    public void remove(Long id) throws DataNotFoundException {
        Optional<Customer> removeCustomer = findById(id);
        if (removeCustomer.isPresent())
            storage.remove(removeCustomer.get());
        else throw new DataNotFoundException("Invalid Id");

    }

    @Override
    public List<Customer> findByName(String firstName) {
        if (firstName == null) throw new IllegalArgumentException("Customer firstname was null");
        //List<Customer> temp = new ArrayList<>();
        /*for (Customer element: storage) {
            if(element.getFirstName().equals(firstName))
                temp.add(element);
        }
        return temp;*/
        return storage.stream().filter(element -> element.getFirstName().equals(firstName)).collect(Collectors.toList());
    }
}
