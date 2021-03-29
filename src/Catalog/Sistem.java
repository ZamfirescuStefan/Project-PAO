package Catalog;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Sistem {

    public Clasa readClasa() {
        Scanner scanner = new Scanner(System.in);
        Integer classId;
        String className;
        System.out.println("Enter class id: ");
        classId = scanner.nextInt();
        System.out.println("Enter class name: ");
        className = scanner.next();
        return new Clasa(classId, className);
    }
    Sistem() {
    }

    public void menu() {
        Manager manager = Manager.getInstance();
        Student student;
        String lastName;
        String firstName;
        Data bDay;
        Clasa clasa;
        Professor teacher;
        Integer salary, grade;
        Nota nota;
        int chosen;

        initValues(manager);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1) Add a new class");
            System.out.println("2) Add a new student");
            System.out.println("3) Add a new teacher");
            System.out.println("4) Add a grade");
            System.out.println("5) Show the students from a class");
            System.out.println("6) Show the list of all teachers");
            System.out.println("7) Show subjects for a class");
            System.out.println("8) Show grades for a student");
            System.out.println("9) Show all grades for a student");
            System.out.println("10) Show all classes");

            System.out.println("\nEnter your option ");
            chosen = scanner.nextInt();
            System.out.println(chosen);
            try {
            switch (chosen) {
                case 1:
                    System.out.println("     ----- Add a new class -----");
                    clasa = readClasa();
                    manager.addClasa(clasa);

                    break;
                case 2:
                    System.out.println("     ----- Add a new student -----");

                    System.out.println("Enter the last name for the student");
                    lastName = scanner.next();
                    System.out.println("Enter the last name for the student");
                    firstName = scanner.next();
                    System.out.println("Enter the birth date for the student");
                    bDay = new Data(scanner.next());
                    System.out.println("Enter the class where you want to add the user:");
                    clasa = readClasa();
                    student = new Student(lastName, firstName, bDay, clasa);
                    manager.getClasa(clasa).addStudent(student);
                    break;

                case 3:
                    System.out.println("     ----- Add a new teacher in data base -----");
                    System.out.println("Enter the last name:");
                    lastName = scanner.next();
                    System.out.println("Enter the first name: ");
                    firstName = scanner.next();
                    System.out.println("Enter the birth date:");
                    bDay = new Data(scanner.next());
                    System.out.println("Enter the salary: ");
                    salary = scanner.nextInt();
                    teacher = new Professor(lastName, firstName, bDay, salary);
                    manager.addProfessor(teacher);
                    break;

                case 4:
                    System.out.println("     ----- Add Grade -----");
                    System.out.println("Enter the last name:");
                    lastName = scanner.next();
                    System.out.println("Enter the first name:");
                    firstName = scanner.next();
                    clasa = readClasa();
                    System.out.println("Enter the subject:");
                    AllSubjects subj = AllSubjects.valueOf(scanner.next());
                    System.out.println("Enter the grade:");
                    grade = scanner.nextInt();
                    nota = new Nota(grade);

                    student = manager.getClasa(clasa).getStudent(lastName, firstName);
                    manager.getClasa(clasa).addGrade(student, subj, nota);
                    manager.getClasa(clasa).showGrades(student);
                    break;

                case 5:
                    System.out.println("     ----- Show Students -----");
                    clasa = readClasa();
                    System.out.println("The students are:");
                    manager.getClasa(clasa).showStudents();
                    break;

                case 6:
                    System.out.println("     ----- Show Teachers -----");
                    System.out.println(" List of professors:");
                    manager.showProfessors();
                    break;

                case 7:
                    System.out.println("     ----- Show Subjects ------");
                    clasa = readClasa();
                    manager.getClasa(clasa).showSubjects();
                    break;

                case 8:
                    System.out.println("     ----- Show the grades for a student -----");
                    System.out.println("Enter the last name:");
                    lastName = scanner.next();
                    System.out.println("Enter the first name:");
                    firstName = scanner.next();
                    clasa = readClasa();
                    student = manager.getClasa(clasa).getStudent(lastName, firstName);
                    manager.getClasa(clasa).showGrades(student);
                    break;

                case 9:
                    System.out.println("     ----- Show all grades for a student -----");

                    System.out.println("Enter the last name for the student");
                    lastName = scanner.next();
                    System.out.println("Enter the last name for the student");
                    firstName = scanner.next();
                    clasa = readClasa();
                    student = manager.getClasa(clasa).getStudent(lastName, firstName);
                    manager.getClasa(clasa).getCatalog().showAllGrades(student);
                    break;

                case 10:
                    System.out.println("All classes:");
                    int index = 1;
                    for (Clasa elem : manager.getClasses()) {
                        System.out.println(index + ") " + elem);
                        index++;
                    }
                    System.out.println();
                    break;

                default:
                    return;
            }
            }
            catch (Exception e) {
                System.out.println("Invalid input, try again");
            }

        }
    }
    void initValues (Manager manager) {
        Integer initInt = 3500;
        Data initDate = new Data("02/02/2000");
        Clasa initClass = new Clasa(11, "C");
        Clasa initClass2 = new Clasa(12, "F");
        Student initStudent = new Student("Zamfirescu", "Stefan", initDate, initClass);
        Professor initProfessor = new Professor("Dumitrascu", "Octavian", initDate, initInt);
        manager.addClasa(initClass);
        manager.addClasa(initClass2);
        ArrayList<Subject> initSubjectList = new ArrayList<>();
        Subject initSubject = new Subject(initProfessor, AllSubjects.Romana);
        Subject initSubject1 = new Subject(initProfessor, AllSubjects.Matematica);
        initSubjectList.add(initSubject);
        initSubjectList.add(initSubject1);
        Nota initNota = new Nota(10);
        Nota initNota1 = new Nota(9);
        manager.getClasa(initClass).setSubjects(initSubjectList);
        manager.getClasa(initClass).addGrade(initStudent, initSubject.getSubject(), initNota);
        manager.getClasa(initClass).addGrade(initStudent, initSubject.getSubject(), initNota1);
        manager.getClasa(initClass).addGrade(initStudent, AllSubjects.Matematica, initNota);
        manager.addProfessor(initProfessor);

    }
}
