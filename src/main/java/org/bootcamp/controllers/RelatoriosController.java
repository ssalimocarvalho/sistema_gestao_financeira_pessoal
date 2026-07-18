package org.bootcamp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class RelatoriosController {
    @FXML
    private TableColumn<?, ?> amountCol;

    @FXML
    private Label balanceLabel;

    @FXML
    private DatePicker dataFimPicker;

    @FXML
    private DatePicker dataIniciopicker;

    @FXML
    private TableColumn<?, ?> dateCol;

    @FXML
    private TableColumn<?, ?> descriptionCol;

    @FXML
    private TableView<?> reportTable;

    @FXML
    private Label totalExpensesLabel;

    @FXML
    private Label totalIncomesLabel;

    @FXML
    private TableColumn<?, ?> typeCol;

    @FXML
    void handleExportarCSV() {

    }

    @FXML
    void handleFiltrar() {

    }
}
