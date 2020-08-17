package writer;

import model.Employee;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileEmployeeWriter implements EmployeeWriter {


    @Override
    public void writeEmployee(FileOutputStream writer, List<Employee> allEmployee) throws IOException {
            for (Employee inter : allEmployee) {
                writer.write(inter.toString().getBytes());
                writer.write('\n');
            }
        writer.write('\n');
    }

    @Override
    public void writeEmployeeName(FileOutputStream writer, List<Employee> allEmployee) throws IOException {
            for (Employee inter : allEmployee) {
                writer.write(inter.printName().getBytes());
            }
        writer.write('\n');
    }

    @Override
    public void writeEmployeeId(FileOutputStream writer, List<Employee> allEmployee) throws IOException {
            for (Employee inter : allEmployee) {
                writer.write(inter.printId().getBytes());
            }
        writer.write('\n');
    }
}
