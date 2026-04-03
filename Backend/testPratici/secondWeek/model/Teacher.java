package model;

import java.util.ArrayList;
import java.util.List;

import interfaces.Registrable;

// Classe Docente
public class Teacher extends Person implements Registrable {
    private String subject;
    private List<Student> students;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
        this.students = new ArrayList<>();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    // Aggiunge uno studente alla lista del docente
    public void addStudent(Student student) {
        students.add(student);
    }

    // Assegna voto solo se lo studente appartiene al docente
    public void assignGrade(Student student, int grade) {
        if (students.contains(student)) {
            student.addGrade(grade);
        } else {
            System.out.println("Errore: lo studente non appartiene a questo docente!");
        }
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public void describeRole() {
        System.out.println("Sono un docente di " + subject);
    }

    @Override
    public void register() {
        System.out.println("Registrazione tramite segreteria didattica");
    }
}