package org.hectorsomer.estudiantes.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Up implements IDataBase{
    private ArrayList<Student> studentsUp=new ArrayList<>();
    @Override
    public boolean addStudent(Student student){
        return studentsUp.add(student);
    }
    @Override
    public boolean editStudent(int matricula, String name, LocalDate birthdate, String carrera){
        boolean encontrado=false;
        for (short i=0; i<studentsUp.size(); i++){
            if (matricula==studentsUp.get(i).getMatricula()){
                encontrado=true;
                if (!name.trim().equals("")){
                    studentsUp.get(i).setName(name);
                }
                if (birthdate!=null){
                    studentsUp.get(i).setBirthdate(birthdate);
                }
                if (!carrera.trim().equals("")){
                    studentsUp.get(i).setCarrera(carrera);
                }
            }
        }
        return encontrado;
    }

    @Override
    public ArrayList<Student> showStudents() {
        return studentsUp;
    }
}
