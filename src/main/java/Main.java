import model.Employee;
import reader.EmployeeReader;
import reader.FileEmployeeReader;
import reader.HttpEmployeeReader;
import writer.EmployeeWriter;
import writer.FileEmployeeWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    final static String OUTPUTFILE = "sortedData.txt";

    public static void main(String[] args) throws IOException {
        EmployeeReader eReader = new HttpEmployeeReader();
        EmployeeWriter eWriter = new FileEmployeeWriter();

        try (FileOutputStream fos = new FileOutputStream(OUTPUTFILE)) {
            List<Employee> allEmployee = eReader.readEmployee("https://raw.githubusercontent.com/LanaGA/EmployeeInheritance/master/src/main/java/input.json");

            //Упорядочить всю последовательность рабочих по убыванию среднемесячной зарплаты.
            fos.write("Упорядочить всю последовательность рабочих по убыванию среднемесячной зарплаты\n".getBytes());
            Collections.sort(allEmployee);
            eWriter.writeEmployee(fos, allEmployee);

            //Вывести первые 5 имен работников из полученного выше списка
            fos.write("Вывести первые 5 имен работников из полученного выше списка\n".getBytes());
            eWriter.writeEmployeeName(fos, allEmployee.subList(0, 5));

            //Вывести последние 3 идентификатора работников из полученного выше списка
            fos.write("Вывести последние 3 идентификатора работников из полученного выше списка\n".getBytes());
            eWriter.writeEmployeeId(fos, allEmployee.subList(allEmployee.size() - 3, allEmployee.size()));

        }
    }
}
