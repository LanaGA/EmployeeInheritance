package reader;

import base.BaseEmployeeReader;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Employee;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import model.FixedEmployee;
import model.OutsourceEmployee;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HttpEmployeeReader extends BaseEmployeeReader {

    @Override
    public List<Employee> readEmployee(String path) {
        OkHttpClient client = new OkHttpClient();


        Request request = new Request.Builder().url(path).build();
        try (Response response = client.newCall(request).execute()) {
            String responseBody = response.body().string();

            ArrayList<Employee> allEmployee = objectMapper.readValue(responseBody, new TypeReference<List<Employee>>(){});
            return allEmployee;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return Collections.EMPTY_LIST;
    }

    public static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.registerSubtypes(new NamedType(OutsourceEmployee.class, "outsource"));
        objectMapper.registerSubtypes(new NamedType(FixedEmployee.class, "fixed"));
    }
}
