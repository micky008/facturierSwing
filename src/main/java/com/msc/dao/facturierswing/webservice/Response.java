package com.msc.dao.facturierswing.webservice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;

/**
 *
 * @author micky
 */
public class Response {

    private String reponse;

    public Response(String reponse) {
        this.reponse = reponse;
    }

    private void replaceforHelper() {
        
    }

    public Object getObject(Class c, Type type) {
        final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();
        if (type != null) {
            return gson.fromJson(reponse, type);
        }
        return gson.fromJson(reponse, c);
    }

    public Object getObject(Class c) {
        return getObject(c, null);
    }

    public void consumeToken() {
        com.msc.rest.tokenrestjersey.Token token = (com.msc.rest.tokenrestjersey.Token) getObject(com.msc.rest.tokenrestjersey.Token.class);
        WebService.setToken(token);
    }

    public void setToken(com.msc.rest.tokenrestjersey.Token token) {
        WebService.setToken(token);
    }

}
