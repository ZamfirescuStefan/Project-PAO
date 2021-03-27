package Catalog;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Sistem {

    Sistem() {
    }

    private void infForClass (Scanner scanner,Integer classId, String className){
        System.out.println("Enter class name:");
        className = scanner.next();
        System.out.println("Enter class id:");
        classId = scanner.nextInt();
    }

    public void menu() {
        Manager manager = Manager.getInstance();
        Student student;
        String className;
        String lastName;
        String firstName;
        Date bDay;
        Clasa clasa;
        Professor teacher;
        Integer salary, grade;



        // TODO For debug
        Integer debugInt = 3500;
        Date debugDate = new Date("02/02/2000");
        Clasa debugClass = new Clasa(11, "C");
        Student debugStudent = new Student("Zamfirescu", "Stefan", debugDate, debugClass);
        Professor debugProfessor = new Professor("Zamfirescu", "Stefan", debugDate, debugInt);
        manager.addClasa(debugClass);
        ArrayList<Subject> debugSubjectList = new ArrayList<Subject>();
        Subject debugSubject = new Subject(debugProfessor, AllSubjects.Romana);
        Subject debugSubject1 = new Subject(debugProfessor, AllSubjects.Matematica);
        debugSubjectList.add(debugSubject);
        debugSubjectList.add(debugSubject1);
        manager.getClasa(debugClass).setSubjects(debugSubjectList);
        manager.getClasa(debugClass).addGrade(debugStudent, debugSubject.getSubject(), 10);
        manager.getClasa(debugClass).addGrade(debugStudent, debugSubject.getSubject(), 9);
        manager.getClasa(debugClass).addGrade(debugStudent, AllSubjects.Matematica, 9);
        int classId = 0;
        int choosen;

        MyScanner scanner = new MyScanner();

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
            System.out.println("10) ");

            System.out.println("\nEnter your option ");
            choosen = scanner.nextInt();
            System.out.println(choosen);
            try {
            switch (choosen) {
                case 1:
                    System.out.println("     ----- Add a new class -----");
                    clasa = scanner.nextClasa();
                    manager.addClasa(clasa);

                    break;
                case 2:
                    System.out.println("     ----- Add a new student -----");

                    System.out.println("Enter the last name for the student");
                    lastName = scanner.nextString();
                    System.out.println("Enter the last name for the student");
                    firstName = scanner.nextString();
                    System.out.println("Enter the birth date for the student");
                    bDay = new Date(scanner.nextString());
                    System.out.println("Enter the class where you want to add the user:");
                    clasa = scanner.nextClasa();
                    student = new Student(lastName, firstName, bDay, clasa);
                    manager.getClasa(clasa).addStudent(student);
                    // TODO debug shit
                    manager.getClasa(clasa).showStudents();
                    break;

                case 3:
                    System.out.println("     ----- Add a new teacher in data base -----");
                    System.out.println("Enter the last name:");
                    lastName = scanner.nextString();
                    System.out.println("Enter the first name: ");
                    firstName = scanner.nextString();
                    System.out.println("Enter the birth date:");
                    bDay = new Date(scanner.nextString());
                    System.out.println("Enter the salary: ");
                    salary = scanner.nextInt();
                    teacher = new Professor(lastName, firstName, bDay, salary);
                    manager.addProfessor(teacher);
                    break;

                case 4:
                    System.out.println("     ----- Add Grade -----");
                    System.out.println("Enter the last name:");
                    lastName = scanner.nextString();
                    System.out.println("Enter the first name:");
                    firstName = scanner.nextString();
                    clasa = scanner.nextClasa();
                    System.out.println("Enter the subject:");
                    AllSubjects subj = AllSubjects.valueOf(scanner.nextString());
                    System.out.println("Enter the grade:");
                    grade = scanner.nextInt();

                    student = manager.getClasa(clasa).getStudent(lastName, firstName);
                    manager.getClasa(clasa).addGrade(student, subj, grade);
                    manager.getClasa(clasa).showGrades(student);
                    break;

                case 5:
                    System.out.println("     ----- Show Students -----");
                    clasa = scanner.nextClasa();
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
                    clasa = scanner.nextClasa();
                    manager.getClasa(clasa).showSubjects();
                    break;

                case 8:
                    System.out.println("     ----- Show the grades for a student -----");
                    System.out.println("Enter the last name:");
                    lastName = scanner.nextString();
                    System.out.println("Enter the first name:");
                    firstName = scanner.nextString();
                    clasa = scanner.nextClasa();
                    student = manager.getClasa(clasa).getStudent(lastName, firstName);
                    manager.getClasa(clasa).showGrades(student);
                    break;

                case 9:
                    System.out.println("     ----- Show all grades for a student -----");

                    System.out.println("Enter the last name for the student");
                    lastName = scanner.nextString();
                    System.out.println("Enter the last name for the student");
                    firstName = scanner.nextString();
                    clasa = scanner.nextClasa();
                    student = manager.getClasa(clasa).getStudent(lastName, firstName);
                    manager.getClasa(clasa).getCatalog().showAllGrades(student);
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
}
