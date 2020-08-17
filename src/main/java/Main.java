import model.Employee;
import reader.EmployeeReader;
import reader.FileEmployeeReader;
import reader.HttpEmployeeReader;
import writer.EmployeeWriter;
import writer.FileEmployeeWriter;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EmployeeReader eReader = new HttpEmployeeReader();
        EmployeeWriter eWriter = new FileEmployeeWriter();

        List<Employee> allEmployee = eReader.readEmployee("https://raw.githubusercontent.com/LanaGA/EmployeeInheritance/master/src/main/java/input.json");
        Collections.sort(allEmployee);
        eWriter.writeEmployee(new File("sortedData.txt"), allEmployee);

    }
}
