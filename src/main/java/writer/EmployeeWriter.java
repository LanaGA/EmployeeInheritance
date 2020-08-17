package writer;

import model.Employee;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface EmployeeWriter {
    void writeEmployee(FileOutputStream writer, List<Employee> allEmployee) throws IOException;

    void writeEmployeeName(FileOutputStream writer, List<Employee> allEmployee) throws IOException;

    void writeEmployeeId(FileOutputStream writer, List<Employee> allEmployee) throws IOException;
}
