package Catalog;

import java.util.Date;
import java.util.Scanner;

public class MyScanner {
    private static Scanner scanner = new Scanner(System.in);
    public int nextInt (){
        return scanner.nextInt();
    }
    public String nextString() {
        return scanner.next();
    }
    public Clasa nextClasa() {
        Integer classId;
        String className;
        System.out.println("Enter class id: ");
        classId = scanner.nextInt();
        System.out.println("Enter class name: ");
        className = scanner.next();
        return new Clasa(classId, className);
    }

}
