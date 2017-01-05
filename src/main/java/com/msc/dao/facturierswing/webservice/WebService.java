package com.msc.dao.facturierswing.webservice;

import java.util.Properties;

/**
 *
 * @author micky
 */
public class WebService {

    public static void setDebugMode(boolean parseBoolean) {
        DEBUG_MODE = parseBoolean;
        Response.DEBUG_MODE = parseBoolean;
    }

    public enum METHOD {
        GET, POST
    }
    public static Properties prop;
    public static boolean DEBUG_MODE = false;

    public String getWsServer() {
        if (prop.getProperty("ws.url").endsWith("/")) {
            return prop.getProperty("ws.url");
        }
        return prop.getProperty("ws.url") + '/';
    }

    public static void setToken(com.msc.rest.tokenrestjersey.Token t) {
        Token.setToken(t.getToken());
    }

}
