package org.lubna.dao.impl;

import org.lubna.dao.AccountDao;
import org.lubna.exception.DataNotFoundException;
import org.lubna.model.Account;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.lubna.dao.sequencer.AccountIdGenerator.generateAccountNumber;

public class AccountDaoImpl implements AccountDao {

    private final List<Account> storage = new ArrayList<>();

    @Override
    public Account create(Account account) {
        if (account == null) throw new IllegalArgumentException("Account was null");
        account.setId(generateAccountNumber());
        storage.add(account);
        return account;
    }

    @Override
    public Optional<Account> findById(Long id) {
        if (id == null) throw new IllegalArgumentException("Account Id was null");
        return storage.stream().filter(account -> account.getId().equals(id)).findFirst();
    }

    @Override
    public Collection<Account> findAll() {
        return storage;
    }

    @Override
    public void remove(Long accountId) throws DataNotFoundException {
        Optional<Account> removeAccount = findById(accountId);
        if (removeAccount.isPresent())
            storage.remove(removeAccount.get());
        else throw new DataNotFoundException("ID Invalid");
    }

    @Override
    public void updateBalance(Account account) throws DataNotFoundException {
      if (account== null) throw new IllegalArgumentException("Account data was null");
        Optional<Account> checkIdExists = findById(account.getId());
        if (checkIdExists.isPresent()) storage.forEach(element -> {
            if(element.getId().equals( account.getId())){
                element.setBalance(account.getBalance());
            }
        });
        else throw new DataNotFoundException("ID Invalid");

    }
}
