package writer;

import model.Employee;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileEmployeeAllWriter implements EmployeeWriter {


    @Override
    public void writeEmployee(FileOutputStream writer, List<Employee> allEmployee) throws IOException {
        for (Employee inter : allEmployee) {
            writer.write((String.format("Name: %s, id: %d, Wage: %s, Type: %s\n", inter.getName(), inter.getId(), inter.wage(), inter.getType())).getBytes());
        }
        writer.write('\n');
    }

}
