package base;

import model.Employee;
import model.FixedEmployee;
import model.OutsourceEmployee;
import reader.EmployeeReader;

import java.util.List;

public abstract class BaseEmployeeReader implements EmployeeReader {

    @Override
    abstract public List<Employee> readEmployee(String path);

    protected static Employee declareEmployee(String line) {
        String[] tokens = line.split(" ");
        switch (tokens[0].toLowerCase()) {
            case "fixed":
                return new FixedEmployee(Integer.parseInt(tokens[1]), tokens[2], Double.parseDouble(tokens[3]));
            case "outsource":
                return new OutsourceEmployee(Integer.parseInt(tokens[1]), tokens[2], Double.parseDouble(tokens[3]));
        }
        throw new ClassCastException();
    }
}
