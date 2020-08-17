package reader;

import model.Employee;

import java.util.List;

public interface EmployeeReader {
    List<Employee> readEmployee(String path);
}
