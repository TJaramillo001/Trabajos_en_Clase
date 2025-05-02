package org.icesi.javafx.control;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import org.icesi.javafx.model.Student;

import java.net.URL;
import java.util.ResourceBundle;

public class ListStudentsController implements Initializable {

    @FXML
    private TableView<Student> studentsTableView;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, String> idColumn;

    @FXML
    private TableColumn<Student, Integer> ageColumn;

    private StudentController controller;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controller = StudentController.getInstance();

        //Table view se suscribe a un objeto observable.
        //Actualiza la lista cuando se añade un objeto nuevo
        studentsTableView.setItems(controller.getStudents());

        nameColumn.setCellValueFactory( //Factory es lo que construye las columnas de cualquier tipo indicado. Almacena info de estudiantes y un atributo de un tipo de dato particular
                new PropertyValueFactory<Student, String>("name")); //el "name" obtiene el nobre de manera predeterminada

        idColumn.setCellValueFactory(
                new PropertyValueFactory<Student, String>("id"));

        ageColumn.setCellValueFactory(
                new PropertyValueFactory<Student, Integer>("age"));

    }
}
