package org.icesi.javafx.control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.icesi.javafx.model.Student;

import java.util.ArrayList;

public class StudentController {
    //Regular controller class

    private static StudentController instance; //Referencia a si mismo

    private ObservableList<Student> students;

    private StudentController() {
        students = FXCollections.observableArrayList();
    }

    public void addStudent(String name, String code, int years){
        Student student = new Student(name, code, years);

        students.add(student);
    }

    public static StudentController getInstance(){
        if(instance == null){
            instance = new StudentController();
        }
        return instance;
    }

    public ObservableList<Student> getStudents() {
        return students;
    }

    public void setStudents(ObservableList<Student> students) {
        this.students = students;
    }

    public String printStudents(){
        String msg = "";
        for(Student s : students){
            msg += s.getName() + ", " + s.getId() +", "+ s.getAge() + "\n";
        }
        return msg;
    }
}
