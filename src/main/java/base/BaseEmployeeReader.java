package base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Employee;
import model.FixedEmployee;
import model.OutsourceEmployee;
import reader.EmployeeReader;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseEmployeeReader implements EmployeeReader {

    @Override
    abstract public List<Employee> readEmployee(String path) throws IOException;

    protected static Employee declareEmployee(String line) {
        String[] tokens = line.split(" ");
        switch (tokens[0].toLowerCase()) {
            case "fixed":
                return new FixedEmployee(Integer.parseInt(tokens[1]), tokens[2], Double.parseDouble(tokens[3]));
            case "outsource":
                return new OutsourceEmployee(Integer.parseInt(tokens[1]), tokens[2], Double.parseDouble(tokens[3]));
            default:
                throw new ClassCastException();
        }
    }

    protected static List<Employee> jsonConvertToEmployee(String line) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Employee.class, new EmployeeDeserializer()).create();
        Type type = new TypeToken<ArrayList<Employee>>() {
        }.getType();
        return gson.fromJson(line, type);
    }

}
