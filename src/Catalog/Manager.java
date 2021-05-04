package Catalog;

import java.util.ArrayList;

public class Manager {
    private final ArrayList <Clasa> classes;
    private final ArrayList <Professor> professors;

    private static Manager manager = null;
    private Manager ()
    {
        classes = new ArrayList<>();
        professors = new ArrayList<>();
    }

    public static Manager getInstance () {
        if (manager == null)
            manager = new Manager();
        return  manager;
    }

    public ArrayList <Clasa> getClasses () {
        return classes;
    }

    public ArrayList <Professor> getProfessors () {
        return professors;
    }

    public void addClasa (Clasa iClasa) {
        classes.add(iClasa);
    }

    public void addProfessor (Professor prof) {
        professors.add(prof);
    }

    public Clasa getClasa (Integer iId, String iName) {
        for (Clasa clasa : classes) {
            if (clasa.getName().equals(iName) && clasa.getId().equals(iId))
                return  clasa;
        }
        return null;
    }
    public Clasa getClasa(Clasa iClasa) {
        for (Clasa clasa: classes) {
            if (clasa.equals(iClasa))
                return clasa;
        }
        return  null;
    }
    public Professor getProfessor(String iLastName, String iFirstName){
        for (Professor prof : professors)
            if (prof.getmLastName().equals(iLastName) && prof.getmFistName().equals(iFirstName))
                return prof;
        return null;
    }

    public Clasa getClasaByName(Integer id, String name) {
        for (Clasa clasa: classes)
            if (clasa.getId().equals(id) && clasa.getName().equals(name))
                return  clasa;
        return null;
    }
    public void showProfessors () {
        for(Professor professor : professors) {
            System.out.println(professor);
        }
    }



}
