package base;

import com.google.gson.*;
import model.Employee;
import model.FixedEmployee;
import model.OutsourceEmployee;

import java.lang.reflect.Type;

public class EmployeeDeserializer implements JsonDeserializer<Employee> {

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String RATE = "rate";
    private static final String TYPE = "type";

    @Override
    public Employee deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        switch (jsonObject.get(TYPE).getAsString()) {
            case FixedEmployee.TYPE:
                return new FixedEmployee(jsonObject.get(ID).getAsInt(), jsonObject.get(NAME).getAsString(), jsonObject.get(RATE).getAsDouble());
            case OutsourceEmployee.TYPE:
                return new OutsourceEmployee(jsonObject.get(ID).getAsInt(), jsonObject.get(NAME).getAsString(), jsonObject.get(RATE).getAsDouble());
            default: throw new JsonParseException("Not found class " + jsonObject.get(TYPE).getAsString());
        }
    }
}
