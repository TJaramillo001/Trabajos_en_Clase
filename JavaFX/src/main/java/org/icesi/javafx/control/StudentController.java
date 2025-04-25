package org.icesi.javafx.control;

import org.icesi.javafx.model.Student;

import java.util.ArrayList;

public class StudentController {
    //Regular controller class

    private ArrayList<Student> students;

    public StudentController() {
        students = new ArrayList<>();
    }

    public void addStudent(String name, String code, int years){
        Student student = new Student(name, code, years);

        students.add(student);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public String printStudents(){
        String msg = "";
        for(Student s : students){
            msg += s.getName() + ", " + s.getCode() +", "+ s.getYears() + "\n";
        }
        return msg;
    }
}
