package org.bootcamp.services;

import org.bootcamp.dao.TransactioDAO;
import org.bootcamp.dao.TransactionDAOImple;
import org.bootcamp.models.Incomes;
import org.bootcamp.models.Transactions;

import java.util.ArrayList;
import java.util.List;


public class ServiceReceitas {

    private TransactioDAO transactioDAO = new TransactionDAOImple();



    public void registar(Transactions transactions){
        transactioDAO.createTransaction(transactions);
    }

    public List<Transactions> listar(){
        return transactioDAO.getTransactionsByType();
    }

    public void delete(int id){
        transactioDAO.deleteTransaction(id);
    }


}
