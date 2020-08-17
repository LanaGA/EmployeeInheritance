package writer;

import model.Employee;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public interface EmployeeWriter {
    void writeEmployee(File file, List<Employee> allEmployee);
}
