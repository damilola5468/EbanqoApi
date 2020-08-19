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
import org.json.JSONObject;

/**
 *
 * @author DATA PC
 */
public class SendNotification {
     public void SendNotification (JSONObject obj) throws MalformedURLException ,IOException{
         URL url = new URL (Constants.UrlConstants.SEND_NOTIFICATION);
          ApiConnection connect = new ApiConnection(url);
          connect.connectAndQueryWithPosts(obj);
    }
}
