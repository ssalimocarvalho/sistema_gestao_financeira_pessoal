package org.bootcamp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import org.bootcamp.utils.LoaderContent;

import java.io.IOException;

public class mainController {


    @FXML private Button categoriaButton;
    @FXML private AnchorPane contentArea;
    @FXML private Button dashboardButton;
    @FXML private Button despesasButton;
    @FXML private Button receitasButton;
    @FXML private Button relatoriosButton;
    @FXML private Label welcomeLabel;

    private LoaderContent loaderContent = new LoaderContent();




    @FXML private void initialize() throws IOException {
    VBox contentPane = loaderContent.content("/views/dashboard.fxml");
    contentArea.getChildren().add(contentPane);
    }



    @FXML
    void handleCategorias() throws IOException {
        VBox contentPane = loaderContent.content("/views/categorias.fxml");
        contentArea.getChildren().add(contentPane);
    }
    @FXML
    void handleDashboard() throws IOException {
        VBox contentPane = loaderContent.content("/views/dashboard.fxml");
        contentArea.getChildren().add(contentPane);
    }

    @FXML
    void handleDespesas() throws IOException {
        VBox contentPane = loaderContent.content("/views/despesas.fxml");
        contentArea.getChildren().add(contentPane);
    }

    @FXML
    void handleReceitas() throws IOException {
        VBox contentPane = loaderContent.content("/views/receitas.fxml");
        contentArea.getChildren().add(contentPane);
    }

    @FXML
    void handleRelatorios() throws IOException {
        VBox contentPane = loaderContent.content("/views/relatorios.fxml");
        contentArea.getChildren().add(contentPane);
    }
}
