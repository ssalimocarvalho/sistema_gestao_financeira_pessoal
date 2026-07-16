package org.bootcamp.dao;

import org.bootcamp.models.Transactions;
import org.bootcamp.models.User;

import java.util.List;

public interface TransactioDAO {
    void createTransaction(Transactions transaction);
    void updateTransaction(Transactions transaction);
    void deleteTransaction(int id);
    Transactions getTransactions(int id);
    List<Transactions> showAllTransactions();
}
