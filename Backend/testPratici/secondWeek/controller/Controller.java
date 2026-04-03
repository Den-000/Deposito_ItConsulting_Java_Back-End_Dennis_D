package controller;

import java.util.*;

import model.*;
import view.*;

public class Controller {
    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private View view = new View();

    public void start() {
        int choice;

        do {
            choice = view.showMenu();

            switch (choice) {
                case 1 -> createStudent();
                case 2 -> createTeacher();
                case 3 -> assignGrade();
                case 4 -> printStudentGrades();
            }

        } while (choice != 0);
    }

    private void createStudent() {
        String name = view.getStringInput("Inserisci nome: ");
        int age = view.getIntInput("Inserisci età: ");
        String className = view.getStringInput("Inserisci classe: ");

        Student student = new Student(name, age, className);
        students.add(student);

        student.register();
    }

    private void createTeacher() {
        String name = view.getStringInput("Inserisci nome: ");
        int age = view.getIntInput("Inserisci età: ");
        String subject = view.getStringInput("Inserisci materia: ");

        Teacher teacher = new Teacher(name, age, subject);
        teachers.add(teacher);

        teacher.register();
    }

    private void assignGrade() {
        if (students.isEmpty() || teachers.isEmpty()) {
            System.out.println("Errore: servono studenti e docenti!");
            return;
        }

        // Selezione docente
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println(i + " - " + teachers.get(i).getName());
        }
        int teacherIndex = view.getIntInput("Scegli docente: ");
        Teacher teacher = teachers.get(teacherIndex);

        // Selezione studente
        for (int i = 0; i < students.size(); i++) {
            System.out.println(i + " - " + students.get(i).getName());
        }
        int studentIndex = view.getIntInput("Scegli studente: ");
        Student student = students.get(studentIndex);

        // Controllo se studente già associato ad un docente
        for (Teacher t : teachers) {
            if (t.getStudents().contains(student)) {
                System.out.println("Errore: studente già associato al docente " + t.getName());
                return;
            }
        }

        // Associa studente al docente
        teacher.addStudent(student);

        int grade = view.getIntInput("Inserisci voto: ");
        teacher.assignGrade(student, grade);

        System.out.println("Voto assegnato!");
    }

    private void printStudentGrades() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(i + " - " + students.get(i).getName());
        }

        int index = view.getIntInput("Scegli studente: ");
        students.get(index).describeRole();
        students.get(index).printGrades();
    }
}