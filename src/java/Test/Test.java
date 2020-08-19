/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import EbangoServices.CreateUserSession;
import EbangoServices.Optin;
import EbangoServices.SendNotification;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author DATA PC
 */
public class Test {
    public static void main(String args[]) throws IOException{
       
    
        
       CreateUserSession createSession = new CreateUserSession();
       HashMap params = new HashMap<>();
       
       params.put("email","toyosio@ebanqo.com");
       params.put("identifier", "07067120949");
       params.put("name", "Toyosi Oyesola");
       params.put("user_type", "user");
       params.put("phone", "2347067120940");
       params.put("user_code", "2347067120940");
       params.put("agent_code", "TING12378");
       params.put("platform", "whatsapp");
       params.put("meta", "");
       
//       createSession.CreateSession(params);
       
        Optin optin = new Optin();
        HashMap param = new HashMap<>();
        param.put("agent_code", "TING12378");
        param.put("mobile_no", "2347067120940");
        
//        optin.Optin(param);
        
       SendNotification sendnotification = new SendNotification();
      
       JSONArray jae = new JSONArray();
       jae.put("whatsapp");
       JSONObject jo = new JSONObject();
       jo.put("platforms", jae);
       jo.put("identifier", "07067120949");
       jo.put("agent_code", "TING12378");
       jo.put("message", "Check-in of 845738364838 - Toyosi Oyesola was successful at OMC Obanikoro");
       jo.put("message_type", "text");
       jo.put("tag", "CONFIRMED_EVENT_UPDATE");
      
        System.out.println(jo);
      
        
//       sendnotification.SendNotification(jo);
       
    }
}
