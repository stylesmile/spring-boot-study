package com.futve.common.tools;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author chenye
 */
public class UrlUtil {

    /**
     * 判断地址链接是否存在
     *
     * @param sourceUrl url
     * @param type      "GET" or "POST"
     */
    public static Boolean isUrlTrue(String sourceUrl, String type) throws IOException {
        //sourceUrl = URLEncoder.encode(sourceUrl, "utf-8");
        sourceUrl = sourceUrl.trim();//.replaceAll(" ", "%20");
        type = StringUtils.isBlank(type) ? "GET" : type;
        URL url = new URL(sourceUrl);
        HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();
        urlcon.setRequestMethod(type);
        urlcon.setRequestProperty("Content-type",
                "application/x-www-form-urlencoded");
        if (urlcon.getResponseCode() == HttpURLConnection.HTTP_OK) {
            System.out.println(HttpURLConnection.HTTP_OK + "," + sourceUrl
                    + ":posted ok!");
            return true;
        } else {
            System.out.println(urlcon.getResponseCode() + "," + sourceUrl
                    + ":Bad post...");
            return false;
        }
    }

    public static Boolean isGetUrlTrue(String url) throws IOException {
        return isUrlTrue(url, "GET");
    }


    public static void main(String[] args) {
        try {
            System.out.println(isUrlTrue("http://oss.futve.com/Multiple languages/MultipleEnglish/20200105/M_DA78_DA-78-46_n_283.wav", ""));
            System.out.println(isUrlTrue("http://oss.futve.com/Multiple languages/MultipleEnglish/20200105/M_DA78_DA-78-46_n_283.wav", ""));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
