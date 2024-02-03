package com.example.demo.repository;

import com.example.demo.repository.common.Cmn;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;


@Component
public class RestaurantRepoImpl {
    public String queryDbAll() throws Exception {
        HttpURLConnection connection = Cmn.getHttpURLConnectionDBNotion("707a02c2e7f44df1a8e78c99831756cd");

        StringBuilder content = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return content.toString();
    }

//    public String queryById(String id) throws Exception {
//        HttpURLConnection connection = Cmn.getHttpURLConnectionDBNotion("707a02c2e7f44df1a8e78c99831756cd");
//
//        StringBuilder content = new StringBuilder();
//        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
//            String inputLine = null;
//            while ((inputLine = in.readLine()) != null) {
//                content.append(inputLine);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return content.toString();
//    }
}
