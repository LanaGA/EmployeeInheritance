package reader;

import base.BaseEmployeeReader;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import model.Employee;
import model.FixedEmployee;
import model.OutsourceEmployee;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpEmployeeReader extends BaseEmployeeReader {
    OkHttpClient client;

    public HttpEmployeeReader(OkHttpClient client) {
        this.client = client;
    }

    @Override
    public List<Employee> readEmployee(String path) throws IOException {

        Request request = new Request.Builder().url(path).build();
        try (Response response = client.newCall(request).execute()) {
            String responseBody = response.body().string();
            return objectMapper.<ArrayList<Employee>>readValue(responseBody, new TypeReference<List<Employee>>() {
            });

        }
    }

    public static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.registerSubtypes(new NamedType(OutsourceEmployee.class, "outsource"));
        objectMapper.registerSubtypes(new NamedType(FixedEmployee.class, "fixed"));
    }
}
