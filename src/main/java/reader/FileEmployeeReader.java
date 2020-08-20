package reader;

import base.BaseEmployeeReader;
import model.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileEmployeeReader extends BaseEmployeeReader {

    @Override
    public List<Employee> readEmployee(String path) throws IOException {
        ArrayList<Employee> allEmployee = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();
            while (line != null) {
                allEmployee.add(declareEmployee(line));
                line = reader.readLine();
            }
            return allEmployee;
        }
    }

}
