package com.example.demo.repository.common;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

public class Cmn {
    public static HttpURLConnection getHttpURLConnectionDBNotion(String dbId) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL("https://api.notion.com/v1/databases/" + dbId + "/query").openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", "Bearer secret_KK4pICzMqmCpD5dDRGydCkq5uImZi64L2lBt8Ms6GW5");
        connection.setRequestProperty("Notion-Version", "2022-06-28");
        connection.setRequestProperty("Content-Type", "application/json");

        connection.setConnectTimeout(5000);
        return connection;
    }

    private static String getFilterBodyReq(String inputValue) {
        return "{\n" +
                "    \"filter\": {\n" +
                "        \"property\": \"Pick Date\",\n" +
                "        \"date\": {\n" +
                "            \"after\": \"" + inputValue + "\"\n" +
                "        }\n" +
                "    }\n" +
                "}\n";
    }

    public static HttpURLConnection getHttpURLConnectionDBNotion(String dbId, String bodyValue) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) new URL("https://api.notion.com/v1/databases/" + dbId + "/query").openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Authorization", "Bearer secret_KK4pICzMqmCpD5dDRGydCkq5uImZi64L2lBt8Ms6GW5");
        connection.setRequestProperty("Notion-Version", "2022-06-28");
        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        connection.setRequestProperty("Accept", "application/json");

        if(bodyValue != null) {
            try (OutputStream os = connection.getOutputStream();) {
                os.write(getFilterBodyReq(bodyValue).getBytes());
                os.flush();
            }
        }

        connection.setConnectTimeout(5000);
        return connection;
    }

    private static String getRegisterForm(String idDb, String idDbRes, String name, String startDate) {
        return "{\n" +
                "    \"parent\": { \"database_id\": \"" + idDb + "\" },\n" +
                "    \"properties\": {\n" +
                "        \"RestaurantDB\": {\n" +
                "            \"relation\": [\n" +
                "                {\n" +
                "                    \"id\": \"" + idDbRes + "\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        \"Pick Date\": {\n" +
                "            \"date\": {\n" +
                "                \"start\": \"" + startDate + "\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"Name\": {\n" +
                "            \"title\": [\n" +
                "                {\n" +
                "                    \"text\": {\n" +
                "                        \"content\": \"" + name + "\"\n" +
                "                    }\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    }\n" +
                "}\n";
    }
    public static HttpURLConnection getHttpURLConnectionDBNotionRegister(String idDb, String idDbRes, String name, String startDate) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) new URL("https://api.notion.com/v1/pages").openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Authorization", "Bearer secret_KK4pICzMqmCpD5dDRGydCkq5uImZi64L2lBt8Ms6GW5");
        connection.setRequestProperty("Notion-Version", "2022-06-28");
        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        connection.setRequestProperty("Accept", "application/json");

        try (OutputStream os = connection.getOutputStream();) {
            os.write(getRegisterForm(idDb, idDbRes, name, startDate).getBytes());
            os.flush();
        }

        connection.setConnectTimeout(5000);
        return connection;
    }
}
