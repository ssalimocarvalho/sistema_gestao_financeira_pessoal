package org.bootcamp.services;

import org.bootcamp.dao.TransactioDAO;
import org.bootcamp.dao.TransactionDAOImple;
import org.bootcamp.enums.Type;

public class ServiceDashboard {

    private TransactioDAO transactioDAO = new TransactionDAOImple();
    public double totalAmount(Type type) {
        return transactioDAO.getTotalAmountByType(type);
    }
}
