package ru.raiffeisen.remoteStartStt.solanteq.soap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import okhttp3.Response;
import ru.raiffeisen.remoteStartStt.CreateTemplate;
import ru.raiffeisen.remoteStartStt.clients.THttpClient;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.projectresult.GetProjectResultSoapWrapper;
import ru.raiffeisen.remoteStartStt.utils.Configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SolanteqAPI {
    private final String testXml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/xmlns:sol=\"http://www.solanteq.com/solar-proof-api\"><soapenv:Header/><soapenv:Body><sol:getProjectResultResponse><sol:header><sol:protocol><sol:name>solar-ws</sol:name><sol:version>2.0</sol:version></sol:protocol><sol:messageId>2ca7f8f0-5c92-4619-b2f5-592ca75ad6de</sol:messageId><sol:messageDate>2015-12-24T13:53:55</sol:messageDate><sol:originator><sol:system>EXTERNAL</sol:system></sol:originator></sol:header><sol:body><sol:response><sol:type>SUCCESS</sol:type><sol:code>SLR-0001</sol:code><sol:message>Successfully completed</sol:message></sol:response><sol:result>OK</sol:result><sol:passed>0</sol:passed><sol:failed>0</sol:failed><sol:skipped>0</sol:skipped><sol:scenarios><sol:scenario><sol:id>12</sol:id><sol:result>OK</sol:result></sol:scenario></sol:scenarios></sol:body></sol:getProjectResultResponse></soapenv:Body></soapenv:Envelope>";

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

        return sendPostRequest(requestData);
    }

    private Response sendPostRequest(Map<String,String> requestData) {
        String url = new Configuration().getPropertySheet().get("URL");
        String serviceName = "executeProject";
        try {
            String template = new CreateTemplate().fillTemplate(serviceName + ".xml",requestData);
            return THttpClient.create().post(url,template,serviceName);
        } catch (IOException e) {
            throw new RuntimeException("Что-то пошло не так при попытке получить или заполнить шаблон сообщения" + e);
        }
    }

    private void bodyResponse() {
        XmlMapper responseMapper = new XmlMapper();
        try {
            GetProjectResultSoapWrapper result = responseMapper.readValue(testXml, GetProjectResultSoapWrapper.class);
            System.out.println(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Что-то пошло не так при попытке десериализовать XML объект" + e);
        }
    }
}
