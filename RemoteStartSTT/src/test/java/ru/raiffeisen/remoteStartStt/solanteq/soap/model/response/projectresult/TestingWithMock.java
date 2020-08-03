package ru.raiffeisen.remoteStartStt.solanteq.soap.model.response.projectresult;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.raiffeisen.remoteStartStt.CallSolanteqAPIRequest;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.executeprojectresponse.ExecuteProjectResponse;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.executeprojectresponse.ExecuteProjectResponseWrapper;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getprojectresult.GetProjectResultResponse;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getprojectresult.GetProjectResultSoapWrapper;
import ru.raiffeisen.remoteStartStt.utils.ResponseXMLMapper;

public class TestingWithMock {
    private final String PROJECT = "ecom acq";
    private final String ENVIRONMENT = "onlinec";
    private final String executeProjectResponse = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Header/><soapenv:Body><slq:executeProjectResponse xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:slq=\"http://www.solanteq.com/solar-proof-api\"><slq:header><slq:protocol><slq:name>solar-ws</slq:name><slq:version>2.0</slq:version></slq:protocol><slq:messageId>2ca7f8f0-5c92-4619-b2f5-592ca75ad6de</slq:messageId><slq:messageDate>2015-12-24T13:53:55</slq:messageDate><slq:originator><slq:system>EXTERNAL</slq:system></slq:originator></slq:header><slq:body><slq:response><slq:type>SUCCESS</slq:type><slq:code>SLR-0001</slq:code><slq:message>Successfully completed</slq:message></slq:response><slq:projectResultRef><slq:id>102909</slq:id></slq:projectResultRef></slq:body></slq:executeProjectResponse></soapenv:Body></soapenv:Envelope>";
    private final ResponseXMLMapper responseXMLMapper = new ResponseXMLMapper();

    @Mock
    CallSolanteqAPIRequest callSolanteqAPIRequest = Mockito.mock(CallSolanteqAPIRequest.class);

    @Test
    public void successExecuteProject() {
        ExecuteProjectResponse response = responseXMLMapper.getResponse(executeProjectResponse, ExecuteProjectResponseWrapper.class).getBody();
        Mockito.when(callSolanteqAPIRequest.executeProject(PROJECT,ENVIRONMENT)).thenReturn(response);

        long id = callSolanteqAPIRequest.executeProject(PROJECT,ENVIRONMENT).getExecuteProjectResponse().getBody().getProjectResultRef().getId();

        Assert.assertEquals(id,102909L);
    }

    @Test
    public void successGetProjectResult(){
        String getProjectResponse = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Header/><soapenv:Body><slq:getProjectResultResponse xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:slq=\"http://www.solanteq.com/solar-proof-api\"><slq:header><slq:protocol><slq:name>solar-ws</slq:name><slq:version>2.0</slq:version></slq:protocol><slq:messageId>2ca7f8f0-5c92-4619-b2f5-592ca75ad6de</slq:messageId><slq:messageDate>2015-12-24T13:53:55</slq:messageDate><slq:originator><slq:system>EXTERNAL</slq:system></slq:originator></slq:header><slq:body><slq:response><slq:type>SUCCESS</slq:type><slq:code>SLR-0001</slq:code><slq:message>Successfully completed</slq:message></slq:response><slq:result>UNCOMPLETED</slq:result><slq:startDate>2020-07-02T22:57:32.792718</slq:startDate><slq:passed>5</slq:passed><slq:failed>1</slq:failed><slq:skipped>1</slq:skipped></slq:body></slq:getProjectResultResponse></soapenv:Body></soapenv:Envelope>";
        GetProjectResultResponse getProjectResultResponse = responseXMLMapper.getResponse(getProjectResponse,GetProjectResultSoapWrapper.class).getBody();
        ExecuteProjectResponse executeProject = responseXMLMapper.getResponse(executeProjectResponse, ExecuteProjectResponseWrapper.class).getBody();
        Mockito.when(callSolanteqAPIRequest.getProjectResult(executeProject)).thenReturn(getProjectResultResponse);

        String result = callSolanteqAPIRequest.getProjectResult(executeProject).getGetProjectResultResponse().getBody().getResult();

        Assert.assertEquals(result, "UNCOMPLETED");
    }

/*    @Test
    public void successGetScenarioResult(){
        String getProjectResponse = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Header/><soapenv:Body><slq:getProjectResultResponse xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:slq=\"http://www.solanteq.com/solar-proof-api\"><slq:header><slq:protocol><slq:name>solar-ws</slq:name><slq:version>2.0</slq:version></slq:protocol><slq:messageId>2ca7f8f0-5c92-4619-b2f5-592ca75ad6de</slq:messageId><slq:messageDate>2015-12-24T13:53:55</slq:messageDate><slq:originator><slq:system>EXTERNAL</slq:system></slq:originator></slq:header><slq:body><slq:response><slq:type>SUCCESS</slq:type><slq:code>SLR-0001</slq:code><slq:message>Successfully completed</slq:message></slq:response><slq:result>UNCOMPLETED</slq:result><slq:startDate>2020-07-02T22:57:32.792718</slq:startDate><slq:passed>5</slq:passed><slq:failed>1</slq:failed><slq:skipped>1</slq:skipped></slq:body></slq:getProjectResultResponse></soapenv:Body></soapenv:Envelope>";
        GetProjectResultResponse getProjectResultResponse = responseXMLMapper.getResponse(getProjectResponse,GetProjectResultSoapWrapper.class).getBody();
        String scenarioResult = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Header/><soapenv:Body><slq:getProjectResultResponse xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:slq=\"http://www.solanteq.com/solar-proof-api\"><slq:header><slq:protocol><slq:name>solar-ws</slq:name><slq:version>2.0</slq:version></slq:protocol><slq:messageId>2ca7f8f0-5c92-4619-b2f5-592ca75ad6de</slq:messageId><slq:messageDate>2015-12-24T13:53:55</slq:messageDate><slq:originator><slq:system>EXTERNAL</slq:system></slq:originator></slq:header><slq:body><slq:response><slq:type>SUCCESS</slq:type><slq:code>SLR-0001</slq:code><slq:message>Successfully completed</slq:message></slq:response><slq:result>TIMEOUT</slq:result><slq:startDate>2020-07-28T12:58:53.903797</slq:startDate><slq:finishDate>2020-07-28T13:04:56.406277</slq:finishDate><slq:passed>0</slq:passed><slq:failed>18</slq:failed><slq:skipped>1</slq:skipped><slq:scenarios><slq:scenario><slq:id>182138</slq:id><slq:code>nspk visa</slq:code><slq:name>Ecom Retail Nspk VISA</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182134</slq:id><slq:code>visa</slq:code><slq:name>Ecom Retail VISA</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182130</slq:id><slq:code>nspk mc</slq:code><slq:name>Ecom Retail Nspk MC</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182126</slq:id><slq:code>mc</slq:code><slq:name>Ecom Retail MC</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182125</slq:id><slq:code>mir</slq:code><slq:name>Ecom Retail MIR</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182124</slq:id><slq:code>visa reversal</slq:code><slq:name>Ecom Retail + Reversal  VISA</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182123</slq:id><slq:code>mc refund 0420</slq:code><slq:name>Ecom Retail +  Refund(0420) MC</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182122</slq:id><slq:code>visa refund 0420</slq:code><slq:name>Ecom Retail + Refund(0420)  VISA</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182121</slq:id><slq:code>nspk visa refund 0420</slq:code><slq:name>Ecom Retail + Refund(0420)  NSPK VISA</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182120</slq:id><slq:code>nspk mc refund 0420</slq:code><slq:name>Ecom Retail +  Refund(0420) NSPK MC</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182119</slq:id><slq:code>refund 0420 mir</slq:code><slq:name>Ecom Retail MIR + Refund(0420) MIR</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182118</slq:id><slq:code>mc compilition</slq:code><slq:name>Ecom Retail + Compilition MC</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182117</slq:id><slq:code>nspk mc compilition</slq:code><slq:name>Ecom Retail + Compilition Nspk MC</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182116</slq:id><slq:code>visa compilition</slq:code><slq:name>Ecom Retail + Compilition VISA</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182115</slq:id><slq:code>nspk visa compilition</slq:code><slq:name>Ecom Retail + Compilition Nspk VISA</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182114</slq:id><slq:code>mir compilition</slq:code><slq:name>Ecom Retail + Compilition MIR</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182113</slq:id><slq:code>nspk visa reversal</slq:code><slq:name>Ecom Retail + Reversal  NSPK VISA</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182112</slq:id><slq:code>mc (1)</slq:code><slq:name>Ecom Retail MC (MasterPass)</slq:name><slq:result>SKIPPED</slq:result></slq:scenario><slq:scenario><slq:id>182111</slq:id><slq:code>mc (2)</slq:code><slq:name>Ecom Retail MC (test)</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario></slq:scenarios></slq:body></slq:getProjectResultResponse></soapenv:Body></soapenv:Envelope>";
        GetScenarioResultResponse getScenarioResultResponse = responseXMLMapper.getResponse(scenarioResult, GetScenarioResultWrapper.class).getBody();
        Mockito.when(callSolanteqAPIRequest.getScenarioResult(getProjectResultResponse)).thenReturn(getScenarioResultResponse);
    }*/

}
