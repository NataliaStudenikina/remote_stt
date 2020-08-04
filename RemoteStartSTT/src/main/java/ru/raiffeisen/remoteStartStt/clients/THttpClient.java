package ru.raiffeisen.remoteStartStt.clients;

import okhttp3.*;
import ru.raiffeisen.remoteStartStt.utils.Configuration;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class THttpClient {
    private static THttpClient instance;
    private OkHttpClient client;
    private THttpClient() {
        client = new OkHttpClient();
    }

    public static THttpClient create() {
        if (instance == null) instance = new THttpClient();
        return instance;
    }

    public String sendPostRequest (String xmlData, String serviceName) {
        String url = new Configuration().getPropertySheet().get("URL");
        try {
            return THttpClient.create().post(url,xmlData,serviceName).body().string();
        } catch (IOException e) {
            throw new RuntimeException("Что-то пошло не так при попытке получить тело зпроса");
        }
    }

    // =================================================================================================================
    // Implementation
    // =================================================================================================================

    private Response send(Request request) {
        try {
            return client.newCall(request).execute();
        } catch (IOException e){
            throw new RuntimeException("Something went wrong by trying send  HTTP request. " + e);
        }
    }

    private Response post(String url, String xml, String serviceName){
        MediaType XML = MediaType.parse("text/xml; charset=utf-8");
        RequestBody body = RequestBody.create(XML,xml);
        String host = getHost(url);
        try {
            Headers headers = Headers.of("SOAPAction", "",
                    "Content-Type", body.contentType().toString(),
                    "Content-Length",  Long.toString(body.contentLength()),
                    "Host", host);

            Request request = new Request.Builder()
                    .headers(headers)
                    .url(url + serviceName)
                    .post(body)
                    .build();
            return send(request);
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong by trying send create HTTP request" + e);
        }
    }

    private String getHost(String url) {
        Pattern pattern = Pattern.compile("(?<=:\\/\\/)(.*)(?=:)");
        Matcher m = pattern.matcher(url);
        m.find();
        return m.group();
    }
}
