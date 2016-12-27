package com.msc.dao.facturierswing.webservice;

import java.util.Properties;

/**
 *
 * @author micky
 */
public class WebService {

    public enum METHOD {
        GET, POST
    }
    public static Properties prop;


    public String getWsServer() {
        if (prop.getProperty("ws.url").endsWith("/")) {
            return prop.getProperty("ws.url");
        }
        return prop.getProperty("ws.url") + '/';
    }

    public static void setToken(com.msc.rest.tokenrestjersey.Token t ) {
        Token.setToken(new String(t.getToken()));
    }
        
    
}
