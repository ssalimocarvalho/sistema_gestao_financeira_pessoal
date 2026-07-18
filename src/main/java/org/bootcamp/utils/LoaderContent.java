package org.bootcamp.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class LoaderContent {

    public VBox content(String file) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(file));
        VBox loaderVBox = loader.load();

        return  loaderVBox;

    }


}
