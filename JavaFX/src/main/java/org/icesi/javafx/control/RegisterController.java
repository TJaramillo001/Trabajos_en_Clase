package org.icesi.javafx.control;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML
    private TextField nameTextF;

    @FXML
    private TextField codeTextF;

    @FXML
    private TextField yearsTextF;

    private StudentController controller;

    @FXML
    private Label listStudentsLabel;

    public void onRegisterStudent(javafx.event.ActionEvent actionEvent){
        String name = nameTextF.getText();
        String code = codeTextF.getText();
        int years = 0;

        try {
            years = Integer.parseInt(yearsTextF.getText());
            controller.addStudent(name, code, years);

        } catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR DE ENTRADA");
            alert.setContentText("La edad debe ser un valor entero");
            alert.showAndWait();
        }




        String msg = "Lista de Usuarios \n" + controller.printStudents();

        listStudentsLabel.setText(msg);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //en este metodo inicializamos todos los elementos de codigos necesarios antes de mostrar una interfaz grafica
        controller = new StudentController();
    }
}