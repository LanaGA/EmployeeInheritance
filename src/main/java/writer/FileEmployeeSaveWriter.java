package writer;

import model.Employee;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class FileEmployeeSaveWriter implements EmployeeWriter {
    @Override
    public void writeEmployee(FileOutputStream writer, List<Employee> allEmployee) throws IOException {
        for (Employee inter : allEmployee) {
            writer.write((String.format("Name: %s, id: %d, rate: %s, Type: %s\n", inter.getName(), inter.getId(), inter.getRate(), inter.getType())).getBytes());
        }
        writer.write('\n');
    }
}
