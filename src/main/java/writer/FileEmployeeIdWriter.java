package writer;

import model.Employee;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class FileEmployeeIdWriter implements EmployeeWriter {


    @Override
    public void writeEmployee(FileOutputStream writer, List<Employee> allEmployee) throws IOException {
        for (Employee inter : allEmployee) {
            writer.write(String.format("Id: %d\n", inter.getId()).getBytes());
        }
        writer.write('\n');
    }
}

