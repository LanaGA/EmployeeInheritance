package reader;

import base.BaseEmployeeReader;
import model.Employee;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class HttpEmployeeReader extends BaseEmployeeReader {
    OkHttpClient client;

    public HttpEmployeeReader(OkHttpClient client) {
        this.client = client;
    }

    @Override
    public List<Employee> readEmployee(String path) throws IOException {
        Request request = new Request.Builder().url(path).build();
        try (Response response = client.newCall(request).execute()) {
            String responseBody = Objects.requireNonNull(response.body()).string();
            return jsonConvertToEmployee(responseBody);
        }
    }

}
