import base.ComparatorEmployee;
import model.Employee;
import okhttp3.OkHttpClient;
import reader.EmployeeReader;
import reader.HttpEmployeeReader;
import writer.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Main {

    final static String OUTPUTFILE = "sortedData.txt";

    public static void main(String[] args) throws IOException {
        EmployeeReader eReader = new HttpEmployeeReader(new OkHttpClient());
        EmployeeWriter allWriter = new FileEmployeeAllWriter();
        EmployeeWriter nameWriter = new FileEmployeeNameWriter();
        EmployeeWriter idWriter = new FileEmployeeIdWriter();
        EmployeeWriter saveWriter = new FileEmployeeSaveWriter();

        try (FileOutputStream fos = new FileOutputStream(OUTPUTFILE)) {
            List<Employee> allEmployee = eReader.readEmployee("https://raw.githubusercontent.com/LanaGA/EmployeeInheritance/feature_HttpReader/src/main/java/input.json");

            //Упорядочить всю последовательность рабочих по убыванию среднемесячной зарплаты.
            fos.write("Упорядочить всю последовательность рабочих по убыванию среднемесячной зарплаты\n".getBytes());
            allEmployee.sort(new ComparatorEmployee());
            allWriter.writeEmployee(fos, allEmployee);

            //Вывести первые 5 имен работников из полученного выше списка
            fos.write("Вывести первые 5 имен работников из полученного выше списка\n".getBytes());
            nameWriter.writeEmployee(fos, allEmployee.subList(0, 5));

            //Вывести последние 3 идентификатора работников из полученного выше списка
            fos.write("Вывести последние 3 идентификатора работников из полученного выше списка\n".getBytes());
            idWriter.writeEmployee(fos, allEmployee.subList(allEmployee.size() - 3, allEmployee.size()));

            //Сохранение данных
            fos.write("Сохранение данных\n".getBytes());
            saveWriter.writeEmployee(fos, allEmployee);

        }
    }
}
