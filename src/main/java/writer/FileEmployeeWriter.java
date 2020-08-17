package writer;

import model.Employee;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileEmployeeWriter implements EmployeeWriter {

    FileWriter writer;

    @Override
    public void writeEmployee(File file, List<Employee> allEmployee) {
        try (FileWriter writer = new FileWriter(file)) {
            for (Employee inter : allEmployee) {
                writer.write(inter.save());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
