package ru.raiffeisen.remoteStartStt.solanteq.soap.model.response.projectresult;

import io.qameta.allure.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import ru.raiffeisen.remoteStartStt.APIRequest;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.executeprojectresponse.ExecuteProjectResponse;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.executeprojectresponse.ExecuteProjectResponseWrapper;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getprojectresult.GetProjectResultResponse;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getprojectresult.GetProjectResultSoapWrapper;
import ru.raiffeisen.remoteStartStt.utils.ResponseXMLMapper;

public class MockTest {
    private final String PROJECT = "ecom acq";
    private final String ENVIRONMENT = "onlinec";
    private final String executeProjectResponse = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Header/><soapenv:Body><slq:executeProjectResponse xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:slq=\"http://www.solanteq.com/solar-proof-api\"><slq:header><slq:protocol><slq:name>solar-ws</slq:name><slq:version>2.0</slq:version></slq:protocol><slq:messageId>2ca7f8f0-5c92-4619-b2f5-592ca75ad6de</slq:messageId><slq:messageDate>2015-12-24T13:53:55</slq:messageDate><slq:originator><slq:system>EXTERNAL</slq:system></slq:originator></slq:header><slq:body><slq:response><slq:type>SUCCESS</slq:type><slq:code>SLR-0001</slq:code><slq:message>Successfully completed</slq:message></slq:response><slq:projectResultRef><slq:id>102909</slq:id></slq:projectResultRef></slq:body></slq:executeProjectResponse></soapenv:Body></soapenv:Envelope>";
    private final ResponseXMLMapper responseXMLMapper = new ResponseXMLMapper();

    //@Mock
    APIRequest APIRequest = Mockito.mock(APIRequest.class);

    //@Test
    public void successExecuteProject() {
        ExecuteProjectResponse response = responseXMLMapper.getResponse(executeProjectResponse, ExecuteProjectResponseWrapper.class).getBody();
        Mockito.when(APIRequest.executeProject(PROJECT,ENVIRONMENT)).thenReturn(response);

        long id = APIRequest.executeProject(PROJECT,ENVIRONMENT).getExecuteProjectResponse().getBody().getProjectResultRef().getId();

        Assert.assertEquals(id,102909L);
    }

    //@Test
    public void successGetProjectResult_Uncompleted(){
        String getProjectResponse = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Header/><soapenv:Body><slq:getProjectResultResponse xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:slq=\"http://www.solanteq.com/solar-proof-api\"><slq:header><slq:protocol><slq:name>solar-ws</slq:name><slq:version>2.0</slq:version></slq:protocol><slq:messageId>2ca7f8f0-5c92-4619-b2f5-592ca75ad6de</slq:messageId><slq:messageDate>2015-12-24T13:53:55</slq:messageDate><slq:originator><slq:system>EXTERNAL</slq:system></slq:originator></slq:header><slq:body><slq:response><slq:type>SUCCESS</slq:type><slq:code>SLR-0001</slq:code><slq:message>Successfully completed</slq:message></slq:response><slq:result>UNCOMPLETED</slq:result><slq:startDate>2020-07-02T22:57:32.792718</slq:startDate><slq:passed>5</slq:passed><slq:failed>1</slq:failed><slq:skipped>1</slq:skipped></slq:body></slq:getProjectResultResponse></soapenv:Body></soapenv:Envelope>";
        GetProjectResultResponse getProjectResultResponse = responseXMLMapper.getResponse(getProjectResponse,GetProjectResultSoapWrapper.class).getBody();
        ExecuteProjectResponse executeProject = responseXMLMapper.getResponse(executeProjectResponse, ExecuteProjectResponseWrapper.class).getBody();
        Mockito.when(APIRequest.getProjectResult(executeProject)).thenReturn(getProjectResultResponse);

        String result = APIRequest.getProjectResult(executeProject).getGetProjectResultResponse().getBody().getResult();

        Assert.assertEquals(result, "UNCOMPLETED");
    }

    //@Test
    public void successGetProjectResult_Timeout(){
        String getProjectResponse = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Header/><soapenv:Body><slq:getProjectResultResponse xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:slq=\"http://www.solanteq.com/solar-proof-api\"><slq:header><slq:protocol><slq:name>solar-ws</slq:name><slq:version>2.0</slq:version></slq:protocol><slq:messageId>2ca7f8f0-5c92-4619-b2f5-592ca75ad6de</slq:messageId><slq:messageDate>2015-12-24T13:53:55</slq:messageDate><slq:originator><slq:system>EXTERNAL</slq:system></slq:originator></slq:header><slq:body><slq:response><slq:type>SUCCESS</slq:type><slq:code>SLR-0001</slq:code><slq:message>Successfully completed</slq:message></slq:response><slq:result>TIMEOUT</slq:result><slq:startDate>2019-09-18T10:23:42.581824</slq:startDate><slq:finishDate>2019-09-18T10:29:44.186426</slq:finishDate><slq:passed>0</slq:passed><slq:failed>17</slq:failed><slq:skipped>1</slq:skipped><slq:scenarios><slq:scenario><slq:id>133642</slq:id><slq:code>nspk visa</slq:code><slq:name>Ecom Retail Nspk VISA</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>133638</slq:id><slq:code>visa</slq:code><slq:name>Ecom Retail VISA</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>133637</slq:id><slq:code>nspk mc</slq:code><slq:name>Ecom Retail Nspk MC</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>133636</slq:id><slq:code>mc</slq:code><slq:name>Ecom Retail MC</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>133622</slq:id><slq:code>mc (1)</slq:code><slq:name>Ecom Retail MC (MasterPass)</slq:name><slq:result>SKIPPED</slq:result></slq:scenario></slq:scenarios></slq:body></slq:getProjectResultResponse></soapenv:Body></soapenv:Envelope>";
        GetProjectResultResponse getProjectResultResponse = responseXMLMapper.getResponse(getProjectResponse,GetProjectResultSoapWrapper.class).getBody();
        ExecuteProjectResponse executeProject = responseXMLMapper.getResponse(executeProjectResponse, ExecuteProjectResponseWrapper.class).getBody();
        Mockito.when(APIRequest.getProjectResult(executeProject)).thenReturn(getProjectResultResponse);

        String result = APIRequest.getProjectResult(executeProject).getGetProjectResultResponse().getBody().getResult();

        Assert.assertEquals(result, "TIMEOUT");
    }

    //@Test
    public void successGetProjectResult_Error(){
        String getProjectResponse = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Header/><soapenv:Body><slq:getProjectResultResponse xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:slq=\"http://www.solanteq.com/solar-proof-api\"><slq:header><slq:protocol><slq:name>solar-ws</slq:name><slq:version>2.0</slq:version></slq:protocol><slq:messageId>2ca7f8f0-5c92-4619-b2f5-592ca75ad6de</slq:messageId><slq:messageDate>2015-12-24T13:53:55</slq:messageDate><slq:originator><slq:system>EXTERNAL</slq:system></slq:originator></slq:header><slq:body><slq:response><slq:type>SUCCESS</slq:type><slq:code>SLR-0001</slq:code><slq:message>Successfully completed</slq:message></slq:response><slq:result>ERROR</slq:result><slq:startDate>2020-08-04T17:32:54.735863</slq:startDate><slq:finishDate>2020-08-04T17:35:31.269426</slq:finishDate><slq:passed>15</slq:passed><slq:failed>2</slq:failed><slq:skipped>1</slq:skipped><slq:scenarios><slq:scenario><slq:id>183141</slq:id><slq:code>mc refund 0420</slq:code><slq:name>Ecom Retail +  Refund(0420) MC</slq:name><slq:result>OK</slq:result></slq:scenario><slq:scenario><slq:id>183140</slq:id><slq:code>visa refund 0420</slq:code><slq:name>Ecom Retail + Refund(0420)  VISA</slq:name><slq:result>OK</slq:result></slq:scenario><slq:scenario><slq:id>183139</slq:id><slq:code>nspk visa refund 0420</slq:code><slq:name>Ecom Retail + Refund(0420)  NSPK VISA</slq:name><slq:result>OK</slq:result></slq:scenario><slq:scenario><slq:id>183138</slq:id><slq:code>nspk mc refund 0420</slq:code><slq:name>Ecom Retail +  Refund(0420) NSPK MC</slq:name><slq:result>OK</slq:result></slq:scenario><slq:scenario><slq:id>183137</slq:id><slq:code>refund 0420 mir</slq:code><slq:name>Ecom Retail MIR + Refund(0420) MIR</slq:name><slq:result>OK</slq:result></slq:scenario></slq:scenarios></slq:body></slq:getProjectResultResponse></soapenv:Body></soapenv:Envelope>";
         GetProjectResultResponse getProjectResultResponse = responseXMLMapper.getResponse(getProjectResponse,GetProjectResultSoapWrapper.class).getBody();
        ExecuteProjectResponse executeProject = responseXMLMapper.getResponse(executeProjectResponse, ExecuteProjectResponseWrapper.class).getBody();
        Mockito.when(APIRequest.getProjectResult(executeProject)).thenReturn(getProjectResultResponse);

        String result = APIRequest.getProjectResult(executeProject).getGetProjectResultResponse().getBody().getResult();

        Assert.assertEquals(result, "ERROR");
    }



    @Test
    @Description ("Very important testing")
    @Epic(value = "Math")
    @Feature(value = "Simple math operation")
    @Story("CPP-657")
    public void mathOperation(){
        String dogsName = "Boss";
        count();
        decuct();
        check();
    }

    @Test
    @Description ("Very important testing")
    @Epic(value = "Math")
    @Feature(value = "Simple math operation")
    @Story("CPP-657")
    public void twoMathOperation(){
        String dogsName = "Boss";
        count();
        decuct();
    }

    @Description("Step step step")
    @Step("count 2 + 2")
    public Integer count() {
        int number =2+2;
        return number;
    }

    @Step("count 5 - 1")
    public Integer decuct(){
        int number =5-3;
        check();
        return number;
    }


    @Step
    public void check() {
        String rightResult = "NotBoss";
        Assert.assertEquals("Boss",rightResult);
    }





}
