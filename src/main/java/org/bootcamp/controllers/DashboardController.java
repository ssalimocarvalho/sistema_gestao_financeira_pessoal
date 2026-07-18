package org.bootcamp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class DashboardController {

    @FXML
    private Label balanceLabel;

    @FXML
    private Label totalExpensesLabel;

    @FXML
    private Label totalIncomesLabel;

    @FXML
    private Label totalTransactionsLabel;

    @FXML
    private ListView<?> transactionList;

    @FXML
    private Label welcomeLabel;
}
