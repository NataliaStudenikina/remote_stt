package ru.raiffeisen.remoteStartStt.solanteq.soap.model.response.projectresult;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.executeprojectresponse.ExecuteProjectResponseWrapper;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getprojectresult.GetProjectResultSoapWrapper;

public class GetProjectResultSoapWrapperTest {
    private final String ProjectResultResponse = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
            "xmlns:sol=\"http://www.solanteq.com/solar-proof-api\"><soapenv:Header/><soapenv:Body><sol:getProjectResultResponse>" +
            "<sol:header><sol:protocol><sol:name>solar-ws</sol:name><sol:version>2.0</sol:version></sol:protocol>" +
            "<sol:messageId>2ca7f8f0-5c92-4619-b2f5-592ca75ad6de</sol:messageId><sol:messageDate>2015-12-24T13:53:55" +
            "</sol:messageDate><sol:originator><sol:system>EXTERNAL</sol:system></sol:originator></sol:header>" +
            "<sol:body><sol:response><sol:type>SUCCESS</sol:type><sol:code>SLR-0001</sol:code><" +
            "sol:message>Successfully completed</sol:message></sol:response><sol:result>OK</sol:result><sol:passed>0</sol:passed>" +
            "<sol:failed>0</sol:failed><sol:skipped>0</sol:skipped><sol:scenarios><sol:scenario><sol:id>12</sol:id>" +
            "<sol:result>OK</sol:result></sol:scenario></sol:scenarios></sol:body></sol:getProjectResultResponse></soapenv:Body></soapenv:Envelope>";


    private final String executeProjectResponseResponse = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Header/><soapenv:Body><slq:executeProjectResponse xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:slq=\"http://www.solanteq.com/solar-proof-api\"><slq:header><slq:protocol><slq:name>solar-ws</slq:name><slq:version>2.0</slq:version></slq:protocol><slq:messageId>2ca7f8f0-5c92-4619-b2f5-592ca75ad6de</slq:messageId><slq:messageDate>2015-12-24T13:53:55</slq:messageDate><slq:originator><slq:system>EXTERNAL</slq:system></slq:originator></slq:header><slq:body><slq:response><slq:type>SUCCESS</slq:type><slq:code>SLR-0001</slq:code><slq:message>Successfully completed</slq:message></slq:response><slq:projectResultRef><slq:id>102909</slq:id></slq:projectResultRef></slq:body></slq:executeProjectResponse></soapenv:Body></soapenv:Envelope>";

    private final String executeScenarioResponse = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Header/><soapenv:Body><sol:getScenarioResultResponse><sol:header><sol:protocol><sol:name>solar-ws</sol:name><sol:version>2.0</sol:version></sol:protocol><sol:messageId>2ca7f8f0-5c92-4619-b2f5-592ca75ad6de</sol:messageId><sol:messageDate>2015-12-24T13:53:55</sol:messageDate><sol:originator><sol:system>EXTERNAL</sol:system></sol:originator></sol:header><sol:body><sol:response><sol:type>SUCCESS</sol:type><sol:code>SLR-0001</sol:code><sol:message>Successfully completed</sol:message></sol:response><sol:result>OK</sol:result><sol:startDate>2018-11-19T10:36:33.281</sol:startDate><sol:finishDate>2018-11-19T11:36:33.281</sol:finishDate><sol:steps><sol:step><sol:id>1</sol:id><sol:ordinal>10</sol:ordinal><sol:startDate>2018-11-19T11:36:33.285</sol:startDate><sol:finishDate>2018-11-19T11:37:33.285</sol:finishDate><sol:template><sol:id>1</sol:id></sol:template><sol:validations/></sol:step><sol:step><sol:id>2</sol:id><sol:ordinal>20</sol:ordinal><sol:startDate>2018-11-19T11:37:34.285</sol:startDate><sol:finishDate>2018-11-19T11:38:34.285</sol:finishDate><sol:channel><sol:id>5</sol:id><sol:code>Channel code</sol:code><sol:name>Channel name</sol:name><sol:dialect><sol:id>3</sol:id><sol:code>Dialect code</sol:code><sol:name>Dialect name</sol:name></sol:dialect></sol:channel><sol:validations/></sol:step><sol:step><sol:id>3</sol:id><sol:ordinal>30</sol:ordinal><sol:startDate>2018-11-19T11:38:35.285</sol:startDate><sol:finishDate>2018-11-19T11:39:35.285</sol:finishDate><sol:template><sol:id>1</sol:id></sol:template><sol:channel><sol:id>5</sol:id><sol:code>Channel code</sol:code><sol:name>Channel name</sol:name><sol:dialect><sol:id>3</sol:id><sol:code>Dialect code</sol:code><sol:name>Dialect name</sol:name></sol:dialect></sol:channel><sol:validations><sol:validation><sol:id>10</sol:id><sol:name>Validation name</sol:name><sol:expression>Validation expression</sol:expression></sol:validation></sol:validations></sol:step></sol:steps></sol:body></sol:getScenarioResultResponse></soapenv:Body></soapenv:Envelope>";

    @Test
    public void successMapping() throws Exception {
        XmlMapper responseMapper = new XmlMapper();
        GetProjectResultSoapWrapper result = responseMapper.readValue(ProjectResultResponse, GetProjectResultSoapWrapper.class);
        System.out.println(result.getBody().toString());
    }

    @Test
    public void successMappingExecuteProjectResponse() throws Exception {
        XmlMapper responseMapper = new XmlMapper();
        ExecuteProjectResponseWrapper result = responseMapper.readValue(executeProjectResponseResponse, ExecuteProjectResponseWrapper.class);
        System.out.println(result.getBody().getExecuteProjectResponse().getBody().getProjectResultRef().getId());

    }

}
