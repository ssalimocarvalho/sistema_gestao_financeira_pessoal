package org.bootcamp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.bootcamp.dao.CategoryDAO;
import org.bootcamp.dao.CategoryDAOImpl;
import org.bootcamp.dao.UserDAO;
import org.bootcamp.dao.UserDAOImpl;
import org.bootcamp.enums.Type;
import org.bootcamp.models.Category;
import org.bootcamp.models.Incomes;
import org.bootcamp.models.Transactions;
import org.bootcamp.models.User;
import org.bootcamp.services.ServiceReceitas;

import java.time.LocalDate;

public class ReceitasController {
    @FXML private TableColumn<?, ?> amountCol;
    @FXML private TableColumn<?, ?> categoryCol;
    @FXML private ComboBox<?> categoryCombo;
    @FXML private TableColumn<?, ?> dataCol;
    @FXML private DatePicker dataPicker;
    @FXML private TableColumn<?, ?> descriptionCol;
    @FXML private TextField descriptorField;
    @FXML private TableView<?> incomesTable;
    @FXML private Label messageLabel;

    @FXML
    private TextField valorField;

    private ServiceReceitas serviceReceitas = new ServiceReceitas();
    private User currentUser;

    @FXML private void initialize(){
        UserDAO userDAO = new UserDAOImpl();
        currentUser =  userDAO.getUser(1);
    };

    @FXML
    void handleAdicionar() {
        String  descriptor = descriptorField.getText();
//        String category = categoryCombo.getSelectionModel().getSelectedItem().toString();
        double  amount = Double.parseDouble(valorField.getText());
        LocalDate  date = dataPicker.getValue();

        CategoryDAO categoryDAO = new CategoryDAOImpl();
        Category category = categoryDAO.getCategory(1) ;


        Transactions transactions = new Incomes(0,date,descriptor,amount, Type.INCOMES,category,currentUser);
        serviceReceitas.registar(transactions);

    }

    @FXML
    void handleApagar() {

    }
}
