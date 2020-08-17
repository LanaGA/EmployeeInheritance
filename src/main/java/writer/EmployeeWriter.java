package writer;

import model.Employee;

import java.io.File;
import java.util.ArrayList;

public interface EmployeeWriter {
    void writeEmployee(File file, ArrayList<Employee> allEmployee);
}
