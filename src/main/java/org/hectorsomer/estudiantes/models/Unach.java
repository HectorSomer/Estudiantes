package org.hectorsomer.estudiantes.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Unach implements IDataBase{
    private ArrayList<Student> studentsUnach=new ArrayList<>();
    @Override
    public boolean addStudent(Student student){
        return studentsUnach.add(student);
    }
    @Override
    public boolean editStudent(int matricula, String name, LocalDate birthdate, String carrera){
        boolean encontrado=false;
        for (short i=0; i<studentsUnach.size(); i++){
            encontrado=true;
            if (matricula==studentsUnach.get(i).getMatricula()){
                if (!name.trim().isEmpty()){
                    studentsUnach.get(i).setName(name);
                }
                if (birthdate!=null){
                    studentsUnach.get(i).setBirthdate(birthdate);
                }
                if (!carrera.trim().isEmpty()){
                    studentsUnach.get(i).setCarrera(carrera);
                }
            }
        }
        return encontrado;
    }

    @Override
    public ArrayList<Student> showStudents() {
        return studentsUnach;
    }
}
