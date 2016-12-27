package com.msc.dao.facturierswing.webservice;

/**
 *
 * @author micky
 */
public class Token {

    private static String token;

    public static final String HEADER_AUTH = "AUTHORIZATION";
    public static final String HEADER_ALLOW = "ALLOW";
     public static final String HEADER_ID_ALLOW = "1";
    
    
    public static String getHeaderBuild() {
        return HEADER_AUTH+ ":" + getToken();
    }    
    
    public static void setToken(String tk) {
        token = tk;
    }

    /**
     * @return the token
     */
    public static String getToken() {
        return token;
    }



}
