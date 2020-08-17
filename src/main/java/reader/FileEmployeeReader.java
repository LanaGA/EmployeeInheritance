package reader;

import base.BaseEmployeeReader;
import model.Employee;

import java.io.*;
import java.util.ArrayList;


public class FileEmployeeReader extends BaseEmployeeReader {

    @Override
    public ArrayList<Employee> readEmployee(String path) {
        ArrayList<Employee> allEmployee = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();
            while (line != null) {
                allEmployee.add(declareEmployee(line));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allEmployee;
    }

}
