package org.hectorsomer.estudiantes.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.hectorsomer.estudiantes.AppEstudiantes;
import org.hectorsomer.estudiantes.models.*;

import java.time.LocalDate;

public class HomeController {

    @FXML
    private Button ViewStudentsUnach;

    @FXML
    private Button buttonAddStudent;

    @FXML
    private Button buttonEditStudent;

    @FXML
    private Button buttonExit;

    @FXML
    private Button buttonViewStudentsTec;

    @FXML
    private Button buttonViewStudentsUp;

    @FXML
    private TextField txtAddBirthdate;

    @FXML
    private TextField txtAddCarrera;

    @FXML
    private TextField txtAddName;

    @FXML
    private TextField txtEditBirthdate;

    @FXML
    private TextField txtEditCarrera;

    @FXML
    private TextField txtEditName;

    @FXML
    private TextField txtMatricula;
    @FXML
    void onClickButtonAddStudent(MouseEvent event) {
        if (txtAddBirthdate.getText().trim().isEmpty() || txtAddCarrera.getText().trim().isEmpty() || txtAddName.getText().trim().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setContentText("Por favor rellene todos los campos");
            alert.showAndWait();
        }else {
            String name=txtAddName.getText();
            String carrera=txtAddCarrera.getText();
            LocalDate birthdate;
            try {
                birthdate = LocalDate.parse(txtAddBirthdate.getText());
                Student student = new Student(name, birthdate, carrera);
                if (AppEstudiantes.getUniversities().addStudentToUniversity(student)){
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Éxito");
                    alert.setContentText("Estudiante agregado con éxito en las 3 universidades");
                    alert.showAndWait();
                }else{
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setContentText("Ha habido un error al agregar el estudiante, por favor intente de nuevo");
                    alert.showAndWait();
                }
            }catch (Exception e){
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setContentText("Formato de fecha de nacimiento incorrecto, el formato debería ser AAAA-MM-DD");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void onClickButtonEditStudent(MouseEvent event) {
    if (txtMatricula.getText().trim().isEmpty()){
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setContentText("No ha ingresado ninguna matrícula");
        alert.showAndWait();
    }else {
        if (txtEditBirthdate.getText().trim().isEmpty()&&txtEditCarrera.getText().trim().isEmpty() && txtEditName.getText().trim().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setContentText("Todos los campos están en blanco...");
            alert.showAndWait();
        }else {
            int matricula=0;
            String name=txtEditName.getText();
            String carrera=txtEditCarrera.getText();
            LocalDate birthdate=null;
            boolean error=false;
            try {
                matricula=Integer.parseInt(txtMatricula.getText());
            }catch (Exception e){
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setContentText("Formato de matrícula incorrecto, ingrese solamente números");
                alert.showAndWait();
                error=true;
            }
            if (!txtEditBirthdate.getText().trim().isEmpty()) {
                try {
                    birthdate = LocalDate.parse(txtEditBirthdate.getText());
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setContentText("Formato de fecha de nacimiento incorrecto, el formato debería ser AAAA-MM-DD");
                    alert.showAndWait();
                    error = true;
                }
            }
            if(!error){
                if (AppEstudiantes.getUniversities().editStudentOfUniversity(matricula,name,birthdate,carrera)){
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Éxito");
                    alert.setContentText("Editado con éxito");
                    alert.showAndWait();
                } else {
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setContentText("Esta matrícula no está dentro de la lista de estudiantes");
                    alert.showAndWait();
                }
            }
        }
    }
    }

    @FXML
    void onClickButtonExit(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void onClickButtonViewStudentsTec(MouseEvent event) {
        AppEstudiantes.newStage("viewStudentsTec-view","Estudiantes del tecológico");
    }

    @FXML
    void onClickButtonViewStudentsUnach(MouseEvent event) {
        AppEstudiantes.newStage("viewStudentsUnach-view","Estudiantes de la UNACH");
    }

    @FXML
    void onClickButtonViewStudentsUp(MouseEvent event) {
        AppEstudiantes.newStage("viewStudentsUp-view","Estudiantes de la UP");
    }

}
