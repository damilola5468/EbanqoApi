/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/**
 *
 * @author DATA PC
 */
public class ApiConnection {

    private URL url;
    final  String apiToken;
    private String r_url;

    public ApiConnection(URL url) {
        this.url = url;
        Token token = new Token();

        try {
            token.initKeys();
        } catch (FileNotFoundException e) {
            System.out.print("Required Token.json file could not be found.");
            e.printStackTrace();
        }

        this.apiToken = token.getTEST_SECRET_TOKEN();

    }

    
    public void connectAndQueryWithPost(HashMap<String, String> query) throws IOException {

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        System.out.println(apiToken);
        connection.setRequestMethod("POST");
        connection.setConnectTimeout(5000);
        connection.setRequestProperty("content-type", "application/json");
        connection.setRequestProperty("token", apiToken);
        connection.setDoOutput(true);

        StringBuilder postData = new StringBuilder();
        postData.insert(0, "{");
        for (Map.Entry<String, String> que : query.entrySet()) {
            if (postData.length() > 1) {
                postData.append(',');
                
            }
            postData.append(('"' + que.getKey().toString() + '"'));
            postData.append(':');
            postData.append(('"' + que.getValue().toString() + '"'));
            
        }
        String result = postData.toString() + "}";
        System.out.println(postData);
        try (OutputStream writer = connection.getOutputStream()) {
            byte[] input = result.getBytes("utf-8");
            writer.write(input);
        }
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            int responseCode = connection.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            System.out.println(response.toString());
        }
    }
    


      public void connectAndQueryWithGet(String param) throws IOException {
          r_url = url + param;
          URL ri_url = new URL(r_url);
        HttpURLConnection connection = (HttpURLConnection) ri_url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("token",apiToken);
        connection.setDoOutput(true);
//          System.out.println(connection);
        try (BufferedReader br = new BufferedReader(
            new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            int responseCode = connection.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            System.out.println(response.toString());
        }
    }
      
      
      public void connectAndQueryWithPosts(JSONObject Obj) throws IOException {

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        System.out.println(apiToken);
        connection.setRequestMethod("POST");
        connection.setConnectTimeout(5000);
        connection.setRequestProperty("content-type", "application/json");
        connection.setRequestProperty("token", apiToken);
        connection.setDoOutput(true);

        try (OutputStream writer = connection.getOutputStream()) {
            byte[] input = Obj.toString().getBytes("utf-8");
            writer.write(input);
        }
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            int responseCode = connection.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            System.out.println(response.toString());
        }
    }

       public void connectAndQueryWithGet() throws IOException {
       
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("token",apiToken);
        connection.setDoOutput(true);
//          System.out.println(connection);
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            int responseCode = connection.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            System.out.println(response.toString());
        }
    }
   
}
