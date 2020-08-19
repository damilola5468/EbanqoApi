/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EbangoServices;

import Core.ApiConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 *
 * @author DATA PC
 */
public class CreateUserSession {
     public void CreateSession(HashMap <String,String> params) throws MalformedURLException ,IOException{
         URL url = new URL (Constants.UrlConstants.CREATE_USER_SESSION);
          ApiConnection connect = new ApiConnection(url);
          connect.connectAndQueryWithPost(params);
    }
}
