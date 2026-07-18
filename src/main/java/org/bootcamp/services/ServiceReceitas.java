package org.bootcamp.services;

import org.bootcamp.dao.TransactioDAO;
import org.bootcamp.dao.TransactionDAOImple;
import org.bootcamp.models.Incomes;
import org.bootcamp.models.Transactions;


public class ServiceReceitas {

    public void registar(Transactions transactions){
        TransactioDAO transactioDAO = new TransactionDAOImple();
        transactioDAO.createTransaction(transactions);
    }
}
