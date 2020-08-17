package reader;

import base.BaseEmployeeReader;
import model.Employee;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class HttpEmployeeReader extends BaseEmployeeReader {

    @Override
    public ArrayList<Employee> readEmployee(String path) {
        httpReader(path);
        return null;
    }

    protected void httpReader(String URL) {
        try {
            // HttpConnection
            HttpURLConnection connection = (HttpURLConnection) new URL(URL).openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            // Getting information from html page
            StringBuilder sb = new StringBuilder();
            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String line;
                while ((line = in.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                //OutputHandler(sb.toString());
            } else
                System.out.println("fail: " + connection.getResponseCode() + " " + connection.getResponseMessage());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
