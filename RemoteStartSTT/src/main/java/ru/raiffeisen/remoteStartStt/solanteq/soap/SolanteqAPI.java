package ru.raiffeisen.remoteStartStt.solanteq.soap;

import okhttp3.Response;
import ru.raiffeisen.remoteStartStt.clients.THttpClient;

import java.util.HashMap;
import java.util.Map;

public class SolanteqAPI {
    public static void main(String[] attrs){
        new SolanteqAPI().executeProject();
    }

    public Response executeProject() {
        Map<String, String> requestData = new HashMap<String, String>();
        requestData.put("project_id", "100005");
        requestData.put("project_code", "ecom acq");
        requestData.put("project_description", "Test text");
        requestData.put("project_interrupt", "true");
        requestData.put("project_environmentId", "100011");
        requestData.put("project_environmentCode","onlinec" );
        String serviceName = "executeProject";

        return THttpClient.create().sendPostRequest(requestData, serviceName);
    }
}
