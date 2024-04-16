package org.hectorsomer.estudiantes.models;

import java.util.ArrayList;

public class Universidades {
    Student student;
    IDataBase dataBase;
    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public IDataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(IDataBase dataBase) {
        this.dataBase = dataBase;
    }
    public boolean addStudent(){
        return dataBase.addStudent(student);
    }
    public void editStudent(){

    }
}
