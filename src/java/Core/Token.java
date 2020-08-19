/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.json.JSONObject;

/**
 *
 * @author DATA PC
 */
class Token {


    private String TEST_TOKEN;
   
    void initKeys() throws FileNotFoundException {
        JSONObject tokenObject;
        String fileContent = "";
        File file = new File("C:\\Users\\DATA PC\\Documents\\NetBeansProjects\\EbanqoApi\\src\\java\\Secret\\Token.json");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            fileContent += scanner.nextLine();
        }
        tokenObject = new JSONObject(fileContent).getJSONObject("API_TOKEN");
        this.TEST_TOKEN= tokenObject.getString("TEST_TOKEN");

    }

   
    protected void setTest_SECRET_TOKEN(String token) {
        this.TEST_TOKEN = token;
    }

     protected String getTEST_SECRET_TOKEN() {
        return this.TEST_TOKEN;
    }

}


