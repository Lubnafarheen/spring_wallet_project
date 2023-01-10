package org.lubna.dao;

import org.lubna.exception.DataNotFoundException;
import org.lubna.model.Account;

public interface AccountDao extends BaseDao<Account, Long> {

    void updateBalance(Account account) throws DataNotFoundException;
}
