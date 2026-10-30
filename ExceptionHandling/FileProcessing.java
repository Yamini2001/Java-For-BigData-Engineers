
package ExceptionHandling;

import java.io.*;

class EmployeeFileReader {

    public void readEmployeeDetails() throws IOException {

        FileReader fr = new FileReader("employee.txt");

        BufferedReader br = new BufferedReader(fr);

        String line;

        System.out.println("Employee Details:");

        while((line = br.readLine()) != null) {

            System.out.println(line);

        }

        br.close();

    }

}

public class FileProcessing {

    public static void main(String[] args) {

        EmployeeFileReader e = new EmployeeFileReader();

        try {

            e.readEmployeeDetails();

        }

        catch(IOException ex) {

            System.out.println("Error reading employee file: "
                               + ex.getMessage());

        }

    }

}
