package org.hectorsomer.estudiantes.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Universities {
    private IDataBase unach = new Unach();
    private  IDataBase tecnologico = new Tecnologico();
    private  IDataBase up= new Up();
    public boolean addStudentToUniversity(Student student){
        boolean exito=false;
        if (unach.addStudent(student)&& tecnologico.addStudent(student)&& up.addStudent(student)){
            exito=true;
        }
        return exito;
    }
    public boolean editStudentOfUniversity(int matricula, String name, LocalDate birthdate, String carrera){
        boolean exito=false;
      if (unach.editStudent(matricula,name,birthdate,carrera) && tecnologico.editStudent(matricula,name,birthdate,carrera)&&up.editStudent(matricula,name,birthdate,carrera)){
          return true;
        }
      return exito;
    }
    public ArrayList<Student> showStudentsUp(){
        return up.showStudents();
    }
    public ArrayList<Student> showStudentsUnach(){
        return unach.showStudents();
    }
    public ArrayList<Student> showStudentsTecnologico(){
        return tecnologico.showStudents();
    }
}
