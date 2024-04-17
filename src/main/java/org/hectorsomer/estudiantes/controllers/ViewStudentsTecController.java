package org.hectorsomer.estudiantes.controllers;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.hectorsomer.estudiantes.AppEstudiantes;
import org.hectorsomer.estudiantes.models.Student;

import java.time.LocalDate;
import java.util.ArrayList;

public class ViewStudentsTecController {

    @FXML
    private TableColumn birthdateColumn;

    @FXML
    private TableColumn carreraColumn;

    @FXML
    private TableColumn matriculaColumn;

    @FXML
    private TableColumn nameColumn;

    @FXML
    private TableView<Student> tableStudentsTec;
    private ObservableList<Student> studentsList;


    @FXML
    void initialize() {
        studentsList= FXCollections.observableArrayList();
        ArrayList<Student> estudiantes;
        estudiantes= AppEstudiantes.getUniversities().showStudentsTecnologico();
        this.matriculaColumn.setCellValueFactory(new PropertyValueFactory("matricula"));
        this.nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
        this.birthdateColumn.setCellValueFactory(new PropertyValueFactory("birthdate"));
        this.carreraColumn.setCellValueFactory(new PropertyValueFactory("carrera"));
        for (short i=0;i<estudiantes.size();i++){
            studentsList.add(estudiantes.get(i));
        }
        tableStudentsTec.setItems(studentsList);
    }
    @FXML
    void OnClickExitButton(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
