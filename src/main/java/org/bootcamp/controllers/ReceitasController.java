package org.bootcamp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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

    @FXML private DatePicker dataPicker;
    @FXML private TextField descriptorField;
    @FXML private TableView<Transactions> incomesTable;
    @FXML private TableColumn<Transactions, String> descriptionCol;
    @FXML private TableColumn<Transactions, Type> categoryCol;
    @FXML private TableColumn<Transactions, Double> amountCol;
    @FXML private TableColumn<Transactions, LocalDate> dataCol;
    @FXML private ComboBox<Type> categoryCombo;
    @FXML private Label messageLabel;

    @FXML
    private TextField valorField;

    private ServiceReceitas serviceReceitas = new ServiceReceitas();
    private User currentUser;

    @FXML private void initialize(){
        UserDAO userDAO = new UserDAOImpl();
        currentUser =  userDAO.getUser(1);

        dataCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("type"));


      carregarDados();


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

        carregarDados();

    }

    @FXML
    void handleApagar() {

        int id = incomesTable.getSelectionModel().getSelectedItem().getId();
        serviceReceitas.delete(id);
        carregarDados();


    }

    private void carregarDados(){
        incomesTable.getItems().clear();
        incomesTable.getItems().addAll(serviceReceitas.listar());
    }
}
