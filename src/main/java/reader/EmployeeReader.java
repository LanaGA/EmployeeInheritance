package reader;

import model.Employee;

import java.io.IOException;
import java.util.List;

public interface EmployeeReader {
    List<Employee> readEmployee(String path) throws IOException;
}
