package model;

import java.util.ArrayList;
import java.util.List;

import interfaces.Registrable;

// Classe Studente
public class Student extends Person implements Registrable {
    private String className;
    private List<Integer> grades;

    public Student(String name, int age, String className) {
        super(name, age);
        this.className = className;
        this.grades = new ArrayList<>();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    // Aggiunge un voto
    public void addGrade(int grade) {
        grades.add(grade);
    }

    // Stampa voti
    public void printGrades() {
        System.out.println("Voti dello studente " + getName() + ": " + grades);
    }

    @Override
    public void describeRole() {
        System.out.println("Sono uno studente della classe " + className);
    }

    @Override
    public void register() {
        System.out.println("Registrazione tramite modulo online");
    }
}