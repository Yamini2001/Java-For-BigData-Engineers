
package JavaFileHandling;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

class Student implements Serializable {

    int sid;
    String name;
    double marks;

    public Student(int id, String name, double marks) {
        this.sid = id;
        this.name = name;
        this.marks = marks;
    }
}

public class WriteAndReadStudentObjectSerialization {

    public static void main(String[] args)
            throws IOException, ClassNotFoundException {

        // Step 1: Create five Student objects

        Student s1 = new Student(101, "Yamini", 85.6);
        Student s2 = new Student(102, "Shreya", 98.5);
        Student s3 = new Student(103, "Suresh", 76.8);
        Student s4 = new Student(104, "Mukesh", 95.3);
        Student s5 = new Student(105, "Amit", 87.7);

        // Step 2: Serialization

        FileOutputStream fos = new FileOutputStream("student.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(s1);
        oos.writeObject(s2);
        oos.writeObject(s3);
        oos.writeObject(s4);
        oos.writeObject(s5);

        oos.close();

        System.out.println("Student objects successfully written!");

        // Step 3: Deserialization

        FileInputStream fis = new FileInputStream("student.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Student st1 = (Student) ois.readObject();
        Student st2 = (Student) ois.readObject();
        Student st3 = (Student) ois.readObject();
        Student st4 = (Student) ois.readObject();
        Student st5 = (Student) ois.readObject();

        // Step 4: Display student details

        System.out.println("\nStudent Details:");

        System.out.println(st1.sid + " " + st1.name + " " + st1.marks);
        System.out.println(st2.sid + " " + st2.name + " " + st2.marks);
        System.out.println(st3.sid + " " + st3.name + " " + st3.marks);
        System.out.println(st4.sid + " " + st4.name + " " + st4.marks);
        System.out.println(st5.sid + " " + st5.name + " " + st5.marks);

        ois.close();
    }
}
