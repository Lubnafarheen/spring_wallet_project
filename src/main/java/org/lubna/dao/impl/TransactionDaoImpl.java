package org.lubna.dao.impl;

import org.lubna.dao.TransactionDao;
import org.lubna.model.Transaction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class TransactionDaoImpl implements TransactionDao {
    List<Transaction> transactionStorage = new ArrayList<>();

    @Override
    public Transaction create(Transaction transaction) {
        if (transaction == null) throw new IllegalArgumentException("Transaction was null");
        transactionStorage.add(transaction);
        return transaction;
    }

    @Override
    public Optional<Transaction> findById(String id) {
        if (id == null) throw new IllegalArgumentException("id was null");
        return transactionStorage.stream().filter(transaction -> transaction.getId().equals(id)).findFirst();
    }

    @Override
    public Collection<Transaction> findAll() {
        return transactionStorage;
    }

    @Override
    public void remove(String id) {
    }
}
