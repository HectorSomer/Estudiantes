package org.hectorsomer.estudiantes.models;
import java.time.LocalDate;
import java.util.ArrayList;

public interface IDataBase {
    boolean addStudent(Student student);
    boolean editStudent(int matricula, String name, LocalDate birthdate, String carrera);
    ArrayList<Student> showStudents();

}
