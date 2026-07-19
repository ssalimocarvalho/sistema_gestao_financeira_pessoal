package org.bootcamp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.bootcamp.enums.Type;
import org.bootcamp.services.ServiceDashboard;
import org.bootcamp.services.ServiceReceitas;

public class DashboardController {

    @FXML private Label balanceLabel;
    @FXML private Label totalExpensesLabel;
    @FXML private Label totalIncomesLabel;
    @FXML private Label totalTransactionsLabel;
    @FXML private ListView<?> transactionList;
    @FXML private Label welcomeLabel;

    private ServiceDashboard serviceDashboard = new ServiceDashboard();
    private ServiceReceitas serviceReceitas = new ServiceReceitas();

    @FXML
    private void initialize(){
       double totalIncomes = serviceDashboard.totalAmount(Type.INCOMES);
       double totalExpenses = serviceDashboard.totalAmount(Type.EXPENSES);
        totalIncomesLabel.setText(String.valueOf(totalIncomes));
        totalExpensesLabel.setText(String.valueOf(totalExpenses));


        double saldo = totalIncomes -  totalExpenses;

        balanceLabel.setText(saldo + "");

        totalTransactionsLabel.setText(serviceReceitas.listar().size() + "");


    }





}
