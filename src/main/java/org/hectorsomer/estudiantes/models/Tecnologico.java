package org.hectorsomer.estudiantes.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tecnologico implements IDataBase{
    private ArrayList<Student> studentsTec=new ArrayList<>();
    public boolean addStudent(Student student){
        return studentsTec.add(student);
    }
    public boolean editStudent(int matricula, String name, LocalDate birthdate, String carrera){
        boolean encontrado=false;
        for (short i=0; i<studentsTec.size(); i++){
            encontrado=true;
            if (matricula==studentsTec.get(i).getMatricula()){
                if (!name.trim().isEmpty()){
                    studentsTec.get(i).setName(name);
                }
                if (birthdate!=null){
                    studentsTec.get(i).setBirthdate(birthdate);
                }
                if (!carrera.trim().isEmpty()){
                    studentsTec.get(i).setCarrera(carrera);
                }
            }
        }
        return encontrado;
    }

    @Override
    public ArrayList<Student> showStudents() {
        return studentsTec;
    }
}
