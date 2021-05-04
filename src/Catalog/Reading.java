package Catalog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Reading {
    private static Reading reading_instance = null;
    public static Reading getInstance() {
        if (reading_instance == null)
            return new Reading();
        else
            return reading_instance;
    }

    public ArrayList<Professor> readProfessors() {
        ArrayList<Professor> professors_list = new ArrayList<>();
        try {

            BufferedReader csvReader = new BufferedReader(new FileReader(
                    "/Users/stefanzamfirescu/CollageProjects/Project-PAO/src/Catalog/CSV_file/Professor.csv"));
            String row;
            row = csvReader.readLine();
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");

                String pattern = "dd/MM/yyyy";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                Date tmp_date = simpleDateFormat.parse(data[2]);

                Integer tmp_salary = Integer.valueOf(data[3]);
                Professor tmp_professor = new Professor(data[0], data[1], tmp_date, tmp_salary);
                professors_list.add(tmp_professor);
            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return professors_list;
    }

    public ArrayList<Clasa> readClasa() {
        ArrayList<Clasa> clasa_list = new ArrayList<>();
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(
                    "/Users/stefanzamfirescu/CollageProjects/Project-PAO/src/Catalog/CSV_file/Clase.csv"));
            String row;
            row = csvReader.readLine();
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");

                Integer tmp_id = Integer.valueOf(data[0]);
                String tmp_name = data[1];
                Clasa tmp_clasa = new Clasa(tmp_id, tmp_name);
                clasa_list.add(tmp_clasa);

            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clasa_list;
    }

    public ArrayList<Student> readStudent() {
        ArrayList<Student> student_list = new ArrayList<>();
        Manager manager = Manager.getInstance();
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(
                    "/Users/stefanzamfirescu/CollageProjects/Project-PAO/src/Catalog/CSV_file/Students.csv"));
            String row;
            row = csvReader.readLine();
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");

                Date tmp_bday = new Date(data[2]);
                Integer tmp_id = Integer.valueOf(data[3]);
                Clasa tmp_clasa = manager.getClasaByName(tmp_id, data[4]);
                Student tmp_student = new Student(data[0], data[1], tmp_bday, tmp_clasa);
                student_list.add(tmp_student);
            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return student_list;
    }

//    public ArrayList<Subject> readSubject() {
//        ArrayList<Subject> subject_list = new ArrayList<>();
//        Manager manager = Manager.getInstance();
//        try {
//            BufferedReader csvReader = new BufferedReader(new FileReader(
//                    "/Users/stefanzamfirescu/CollageProjects/Project-PAO/src/Catalog/CSV_file/SubjectsForClasses.csv"));
//            String row;
//            row = csvReader.readLine();
//            while ((row = csvReader.readLine()) != null) {
//                String[] data = row.split(",");
//
//                Integer tmp_id = Integer.valueOf(data[0]);
//                String tmp_name = data[1];
//                Clasa tmp_clasa = manager.getClasaByName(tmp_id, tmp_name);
//                Professor tmp_prof = manager.getProfessor(data[3], data[2]);
//                tmp_clasa.addSubjects(tmp_prof, AllSubjects.valueOf(data[4]));
//
//            }
//            csvReader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
