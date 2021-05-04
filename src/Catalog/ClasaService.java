package Catalog;

public class ClasaService {
    public static ClasaService instance = null;
    public static ClasaService getInstance() {
        if (instance == null)
            instance = new ClasaService();
        return instance;
    }

    public void showStudents(Clasa cls) {
        int index = 1;
        for (Student student : cls.getStudents()) {
            System.out.println(index + ") " + student);
            index += 1;
        }
        System.out.println();
    }

    public void showSubjects (Clasa cls) {
        int index = 1;
        System.out.println("The subjects for " + cls.getId() + cls.getName() + " are: " );
        for (Subject subject : cls.getSubjects()) {
            System.out.println(index + ") " + subject);
            index += 1;
        }
        System.out.println();
    }

    public void showGrades(Clasa cls,Student iStudent) {
        cls.getCatalog().showGrades(iStudent);
    }

    public  void calcAverage (Clasa cls, Student iStudent, Subject iSubject) {
        cls.getCatalog().calcAverage(iStudent, iSubject);
    }

    public void addGrade(Clasa clasa, Student iStudent, AllSubjects iSubject, Integer iNota) {
        Subject subject = null;
        for (Subject item : clasa.getSubjects()) {
            if (item.getSubject() == iSubject)
                subject = item;
        }
        if (subject == null)
            System.out.println("This subject not exist");
        else
            clasa.getCatalog().addNote(iStudent, subject, iNota);
    }

    public void addSubjects(Clasa clasa, Professor iProfessor, AllSubjects iSubj) {

        boolean existSubj = false;
        for (Subject item : clasa.getSubjects()) {
            if (item.getSubject() == iSubj) {
                existSubj = true;
                break;
            }
        }
        if (!existSubj) {
            Subject sub = new Subject(iProfessor, iSubj);
            clasa.getSubjects().add(sub);
        }

    }

    public Student getStudent(Clasa clasa, String iLastName, String iFirstName) {
        for (Student student : clasa.getStudents())
            if (student.getmFistName().equals(iFirstName) && student.getmLastName().equals(iLastName))
                return student;
        return null;
    }
}
