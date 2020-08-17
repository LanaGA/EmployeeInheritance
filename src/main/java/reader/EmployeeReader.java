package reader;

import model.Employee;

import java.io.File;
import java.util.ArrayList;

public interface EmployeeReader {
    ArrayList<Employee> readEmployee(String path);
}
