package ru.raiffeisen.remoteStartStt.clients;

import okhttp3.*;
import java.io.IOException;

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

    public Response post(String url, String template, String serviceName) throws IOException {
        MediaType XML = MediaType.parse("text/xml; charset=utf-8");
        RequestBody body = RequestBody.create(XML,template);
        Headers headers = Headers.of("SOAPAction", "", "Content-Type", body.contentType().toString(), "Content-Length",  Long.toString(body.contentLength()),
                "Host", url);

        Request request = new Request.Builder()
                .headers(headers)
                .url(url+ "solar-tt/ws/" + serviceName)
                .post(body)
                .build();
        return send(request);
    }

    private Response send(Request request) throws IOException {
        try {
            return client.newCall(request).execute();
        } catch (IOException e){
            throw new IOException("Что-то пошло не так при попытке отправить HTTP запрос. " + e);
        }
    }

}
