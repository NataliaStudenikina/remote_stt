package ru.raiffeisen.remoteStartStt.solanteq.soap;

import ru.raiffeisen.remoteStartStt.clients.THttpClient;

import java.util.HashMap;
import java.util.Map;

public class CheckOfResponse {

    private final String executeProjectResponseResponse = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Header/><soapenv:Body><slq:executeProjectResponse xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:slq=\"http://www.solanteq.com/solar-proof-api\"><slq:header><slq:protocol><slq:name>solar-ws</slq:name><slq:version>2.0</slq:version></slq:protocol><slq:messageId>2ca7f8f0-5c92-4619-b2f5-592ca75ad6de</slq:messageId><slq:messageDate>2015-12-24T13:53:55</slq:messageDate><slq:originator><slq:system>EXTERNAL</slq:system></slq:originator></slq:header><slq:body><slq:response><slq:type>SUCCESS</slq:type><slq:code>SLR-0001</slq:code><slq:message>Successfully completed</slq:message></slq:response><slq:projectResultRef><slq:id>102909</slq:id></slq:projectResultRef></slq:body></slq:executeProjectResponse></soapenv:Body></soapenv:Envelope>";
    ProcessingOfResults processingOfResults = new ProcessingOfResults();

    private boolean checkResponseCode(String projectResultXML) {
        String codeResponse = processingOfResults.getCodeFomResponse(projectResultXML);
        if (codeResponse.equals("SUCCESS")){
           return true;
        } else
            System.out.println("Код равен: " + codeResponse);
            return false;
    }

    public void sendGetProjectResult(String projectResultXML) {
        Map<String, String> requestData = new HashMap<String, String>();
        if(checkResponseCode(projectResultXML)){
            requestData.put("projectResultId",processingOfResults.getIdResponse(executeProjectResponseResponse).toString());
            THttpClient.create().sendPostRequest(requestData, "getProjectResult");
        }
    }
}
