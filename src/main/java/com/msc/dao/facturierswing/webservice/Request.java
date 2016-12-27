package com.msc.dao.facturierswing.webservice;

import com.msc.dao.facturierswing.webservice.WebService.METHOD;
import static com.msc.dao.facturierswing.webservice.WebService.METHOD.GET;
import static com.msc.dao.facturierswing.webservice.WebService.METHOD.POST;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.FormParam;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.WriterOutputStream;
import org.apache.commons.lang3.reflect.FieldUtils;

/**
 *
 * @author micky
 */
public class Request {

    private String endpoint;
    private String urlSuite;

    public Request() {
    }

    public Request(String endpoit, String suiteUrl) {
        this.endpoint = endpoit;
        this.urlSuite = suiteUrl;
    }

    /**
     * @return the endpoint
     */
    public String getEndpoint() {
        return endpoint.endsWith("/") ? endpoint : endpoint + "/";
    }

    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(date);
    }

    public static String formatDate(String dateStr, String patternDeDateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(patternDeDateStr);
            Date d = sdf.parse(dateStr);
            return formatDate(d);
        } catch (ParseException ex) {
            Logger.getLogger(Request.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * @param endpoint the endpoint to set. ne jamais mettre '/' avant.
     */
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * @return the urlSuite
     */
    public String getUrlSuite() {
        return urlSuite;
    }

    /**
     * @param urlSuite the urlSuite to set ne jamais mettre '/' avant.
     */
    public void setUrlSuite(String urlSuite) {
        this.urlSuite = urlSuite;
    }

    /**
     * envois rien. ne fais qu'executer l'url.
     *
     * @return
     * @throws IOException
     */
    public Response sendRequest() throws IOException {
        return sendRequest(null, GET);
    }

    public Response sendRequest(Object tosend, METHOD method) throws IOException {
        WebService ws = new WebService();

        String url = ws.getWsServer() + getEndpoint() + urlSuite;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add reuqest header
        if (method == POST) {
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
        }

        con.setRequestProperty(Token.HEADER_AUTH, Token.getToken());
        con.setRequestProperty(Token.HEADER_ALLOW, Token.HEADER_ID_ALLOW);
        StringBuilder sb = new StringBuilder();

        if (tosend != null) {
            List<Field> fs = FieldUtils.getAllFieldsList(tosend.getClass());
            for (Field field : fs) {
                field.setAccessible(true);
                if (field.getDeclaredAnnotation(FormParam.class) == null) {
                    continue;
                }
                sb.append(field.getName());
                sb.append("=");
                if (field.getType() == List.class) {
                    sb.append(convertList(tosend, field));
                } else {
                    sb.append(convertField(tosend, field));
                }
                sb.append("&");
            }// Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            String tst = sb.toString();
            wr.writeBytes(tst);
            wr.flush();
            wr.close();
        }

        //int responseCode = con.getResponseCode();
        StringWriter sw = new StringWriter();
        WriterOutputStream fos = new WriterOutputStream(sw, Charset.forName("UTF-8"));
        IOUtils.copy(con.getInputStream(), fos);
        IOUtils.closeQuietly(fos);

        return new Response(sw.toString());
    }

    private String convertList(Object ob, Field f) {
        try {
            List lo = (List) FieldUtils.readDeclaredField(ob, f.getName(), true);
            if (lo == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (Object o : lo) {
                sb.append(o.toString());
                sb.append(";");
            }
            return URLEncoder.encode(sb.toString(), "UTF-8");
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Request.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Request.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private String convertField(Object ob, Field f) {
        try {
            Object o = f.get(ob);
            if (o == null) {
                return "";
            }
            return URLEncoder.encode(o.toString(), "UTF-8");
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Request.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Request.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
