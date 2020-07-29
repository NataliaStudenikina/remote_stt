package ru.raiffeisen.remoteStartStt.clients;

import okhttp3.*;
import ru.raiffeisen.remoteStartStt.CreateTemplate;
import ru.raiffeisen.remoteStartStt.utils.Configuration;

import java.io.IOException;
import java.util.Map;

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

    private Response post(String url, String template, String serviceName){
        MediaType XML = MediaType.parse("text/xml; charset=utf-8");
        RequestBody body = RequestBody.create(XML,template);
        try {
            Headers headers = Headers.of("SOAPAction", "",
                    "Content-Type", body.contentType().toString(),
                    "Content-Length",  Long.toString(body.contentLength()),
                    "Host", url);

            Request request = new Request.Builder()
                    .headers(headers)
                    .url(url + serviceName)
                    .post(body)
                    .build();
            return send(request);
        } catch (IOException e) {
            throw new RuntimeException("Что-то пошло не так при попытке создать сообщение" + e);
        }
    }

    private Response send(Request request) {
        try {
            return client.newCall(request).execute();
        } catch (IOException e){
            throw new RuntimeException("Что-то пошло не так при попытке отправить HTTP запрос. " + e);
        }
    }

    private Response postRequest(String template, String serviceName) {
        String url = new Configuration().getPropertySheet().get("URL");
        return post(url,template,serviceName);
    }

    public Response sendPostRequest (Map<String,String> requestData, String templateName) {
        String template = new CreateTemplate().fillTemplate(templateName + ".xml",requestData);
        return postRequest(template,templateName);
    }

}
