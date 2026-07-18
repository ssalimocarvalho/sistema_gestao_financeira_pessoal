package org.bootcamp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class DespesasController {
    @FXML
    private TableColumn<?, ?> amountCol;

    @FXML
    private TableColumn<?, ?> categoryCol;

    @FXML
    private ComboBox<?> categoryCombo;

    @FXML
    private TableColumn<?, ?> dataCol;

    @FXML
    private DatePicker dataPicker;

    @FXML
    private TableColumn<?, ?> descriptionCol;

    @FXML
    private TextField descriptorField;

    @FXML
    private TableView<?> expensesTable;

    @FXML
    private Label messageLabel;

    @FXML
    private TextField valorField;

    @FXML
    void handleAdicionar() {

    }

    @FXML
    void handleApagar() {

    }
}
