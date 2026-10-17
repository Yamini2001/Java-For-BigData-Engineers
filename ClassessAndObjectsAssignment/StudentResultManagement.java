package ClassessAndObjectsAssignment;

import java.util.Scanner;

class Student {
    int studentID;
    String studentName;
    int marks;

    public void read() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Student ID:");
        studentID = sc.nextInt();

        System.out.println("Enter Student Name:");
        studentName = sc.next();

        System.out.println("Enter Marks:");
        marks = sc.nextInt();
    }

    public String findResult() {
        if (marks >= 50) {
            return "Pass";
        } else {
            return "Fail";
        }
    }

    public void display() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Student Name: " + studentName);
        System.out.println("Marks: " + marks);
        System.out.println("Result: " + findResult());
    }

}

public class StudentResultManagement {
    public static void main(String[] args) {

        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();

        s1.read();
        s1.display();
        System.out.println("Final Result: "+s1.findResult());

        s2.read();
        s2.display();
        System.out.println("Final Result: "+s2.findResult());

        s3.read();
        s3.display();
        System.out.println("Final Result: "+s3.findResult());
        
    }
}