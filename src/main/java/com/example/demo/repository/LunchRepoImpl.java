package com.example.demo.repository;

import com.example.demo.repository.common.Cmn;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;


@Component
public class LunchRepoImpl {
    public String queryDbAll(String idDb) throws Exception {
        HttpURLConnection connection = Cmn.getHttpURLConnectionDBNotion(idDb);

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

    public String queryDbAllFromDate(String idDb, String date) throws Exception {
        HttpURLConnection connection = Cmn.getHttpURLConnectionDBNotion(idDb, date);

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

    public boolean ChooseARestaurant(String idDb, String idDbRes, String name, String startDate) throws Exception {
        HttpURLConnection connection = Cmn.getHttpURLConnectionDBNotionRegister(idDb, idDbRes, name, startDate);
        StringBuilder content = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
