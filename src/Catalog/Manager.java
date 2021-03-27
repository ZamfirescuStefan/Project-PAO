package Catalog;

import java.util.ArrayList;

public class Manager {
    public ArrayList <Clasa> classes = new ArrayList<Clasa>();
    public ArrayList <Professor> professors = new ArrayList<Professor>();

    private static Manager manager = null;
    private Manager ()
    {
    }

    public static Manager getInstance () {
        if (manager == null)
            manager = new Manager();
        return  manager;
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
    public void showProfessors () {
        for(Professor professor : professors) {
            System.out.println(professor);
        }
    }



}
