package ru.raiffeisen.remoteStartStt.solanteq.soap.model.response.projectresult;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.executeprojectresponse.ExecuteProjectResponseWrapper;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getprojectresult.GetProjectResultSoapWrapper;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getscenarioresult.GetScenarioResultWrapper;

public class GetProjectResultSoapWrapperTest {
    private final String ProjectResultResponse = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Header/><soapenv:Body><slq:getProjectResultResponse xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:slq=\"http://www.solanteq.com/solar-proof-api\"><slq:header><slq:protocol><slq:name>solar-ws</slq:name><slq:version>2.0</slq:version></slq:protocol><slq:messageId>2ca7f8f0-5c92-4619-b2f5-592ca75ad6de</slq:messageId><slq:messageDate>2015-12-24T13:53:55</slq:messageDate><slq:originator><slq:system>EXTERNAL</slq:system></slq:originator></slq:header><slq:body><slq:response><slq:type>SUCCESS</slq:type><slq:code>SLR-0001</slq:code><slq:message>Successfully completed</slq:message></slq:response><slq:result>TIMEOUT</slq:result><slq:startDate>2020-07-28T12:58:53.903797</slq:startDate><slq:finishDate>2020-07-28T13:04:56.406277</slq:finishDate><slq:passed>0</slq:passed><slq:failed>18</slq:failed><slq:skipped>1</slq:skipped><slq:scenarios><slq:scenario><slq:id>182138</slq:id><slq:code>nspk visa</slq:code><slq:name>Ecom Retail Nspk VISA</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182134</slq:id><slq:code>visa</slq:code><slq:name>Ecom Retail VISA</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182130</slq:id><slq:code>nspk mc</slq:code><slq:name>Ecom Retail Nspk MC</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182126</slq:id><slq:code>mc</slq:code><slq:name>Ecom Retail MC</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182125</slq:id><slq:code>mir</slq:code><slq:name>Ecom Retail MIR</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182124</slq:id><slq:code>visa reversal</slq:code><slq:name>Ecom Retail + Reversal  VISA</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182123</slq:id><slq:code>mc refund 0420</slq:code><slq:name>Ecom Retail +  Refund(0420) MC</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182122</slq:id><slq:code>visa refund 0420</slq:code><slq:name>Ecom Retail + Refund(0420)  VISA</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182121</slq:id><slq:code>nspk visa refund 0420</slq:code><slq:name>Ecom Retail + Refund(0420)  NSPK VISA</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182120</slq:id><slq:code>nspk mc refund 0420</slq:code><slq:name>Ecom Retail +  Refund(0420) NSPK MC</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182119</slq:id><slq:code>refund 0420 mir</slq:code><slq:name>Ecom Retail MIR + Refund(0420) MIR</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182118</slq:id><slq:code>mc compilition</slq:code><slq:name>Ecom Retail + Compilition MC</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182117</slq:id><slq:code>nspk mc compilition</slq:code><slq:name>Ecom Retail + Compilition Nspk MC</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182116</slq:id><slq:code>visa compilition</slq:code><slq:name>Ecom Retail + Compilition VISA</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182115</slq:id><slq:code>nspk visa compilition</slq:code><slq:name>Ecom Retail + Compilition Nspk VISA</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182114</slq:id><slq:code>mir compilition</slq:code><slq:name>Ecom Retail + Compilition MIR</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182113</slq:id><slq:code>nspk visa reversal</slq:code><slq:name>Ecom Retail + Reversal  NSPK VISA</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario><slq:scenario><slq:id>182112</slq:id><slq:code>mc (1)</slq:code><slq:name>Ecom Retail MC (MasterPass)</slq:name><slq:result>SKIPPED</slq:result></slq:scenario><slq:scenario><slq:id>182111</slq:id><slq:code>mc (2)</slq:code><slq:name>Ecom Retail MC (test)</slq:name><slq:result>TIMEOUT</slq:result></slq:scenario></slq:scenarios></slq:body></slq:getProjectResultResponse></soapenv:Body></soapenv:Envelope>";

    private final String executeProjectResponseResponse = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Header/><soapenv:Body><slq:executeProjectResponse xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:slq=\"http://www.solanteq.com/solar-proof-api\"><slq:header><slq:protocol><slq:name>solar-ws</slq:name><slq:version>2.0</slq:version></slq:protocol><slq:messageId>2ca7f8f0-5c92-4619-b2f5-592ca75ad6de</slq:messageId><slq:messageDate>2015-12-24T13:53:55</slq:messageDate><slq:originator><slq:system>EXTERNAL</slq:system></slq:originator></slq:header><slq:body><slq:response><slq:type>SUCCESS</slq:type><slq:code>SLR-0001</slq:code><slq:message>Successfully completed</slq:message></slq:response><slq:projectResultRef><slq:id>102909</slq:id></slq:projectResultRef></slq:body></slq:executeProjectResponse></soapenv:Body></soapenv:Envelope>";

    private final String executeScenarioResponse = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:sol=\"http://www.solanteq.com/solar-proof-api\"><soapenv:Header/><soapenv:Body><sol:getScenarioResultResponse><sol:header><sol:protocol><sol:name>solar-ws</sol:name><sol:version>2.0</sol:version></sol:protocol><sol:messageId>2ca7f8f0-5c92-4619-b2f5-592ca75ad6de</sol:messageId><sol:messageDate>2015-12-24T13:53:55</sol:messageDate><sol:originator><sol:system>EXTERNAL</sol:system></sol:originator></sol:header><sol:body><sol:response><sol:type>SUCCESS</sol:type><sol:code>SLR-0001</sol:code><sol:message>Successfully completed</sol:message></sol:response><sol:result>OK</sol:result><sol:startDate>2018-11-19T10:36:33.281</sol:startDate><sol:finishDate>2018-11-19T11:36:33.281</sol:finishDate><sol:steps><sol:step><sol:id>1</sol:id><sol:ordinal>10</sol:ordinal><sol:startDate>2018-11-19T11:36:33.285</sol:startDate><sol:finishDate>2018-11-19T11:37:33.285</sol:finishDate><sol:template><sol:id>1</sol:id></sol:template><sol:validations/></sol:step><sol:step><sol:id>2</sol:id><sol:ordinal>20</sol:ordinal><sol:startDate>2018-11-19T11:37:34.285</sol:startDate><sol:finishDate>2018-11-19T11:38:34.285</sol:finishDate><sol:channel><sol:id>5</sol:id><sol:code>Channel code</sol:code><sol:name>Channel name</sol:name><sol:dialect><sol:id>3</sol:id><sol:code>Dialect code</sol:code><sol:name>Dialect name</sol:name></sol:dialect></sol:channel><sol:validations/></sol:step><sol:step><sol:id>3</sol:id><sol:ordinal>30</sol:ordinal><sol:startDate>2018-11-19T11:38:35.285</sol:startDate><sol:finishDate>2018-11-19T11:39:35.285</sol:finishDate><sol:template><sol:id>1</sol:id></sol:template><sol:channel><sol:id>5</sol:id><sol:code>Channel code</sol:code><sol:name>Channel name</sol:name><sol:dialect><sol:id>3</sol:id><sol:code>Dialect code</sol:code><sol:name>Dialect name</sol:name></sol:dialect></sol:channel><sol:validations><sol:validation><sol:id>10</sol:id><sol:name>Validation name</sol:name><sol:expression>Validation expression</sol:expression></sol:validation></sol:validations></sol:step></sol:steps></sol:body></sol:getScenarioResultResponse></soapenv:Body></soapenv:Envelope>";
    @Test
    public void successMappingProjectResultResponse() throws Exception {
        XmlMapper responseMapper = new XmlMapper();
        GetProjectResultSoapWrapper result = responseMapper.readValue(ProjectResultResponse, GetProjectResultSoapWrapper.class);
        System.out.println(result.getBody().getGetProjectResultResponse().getBody().getScenarios().get(0).getId());
    }

    @Test
    public void successMappingExecuteProjectResponse() throws Exception {
        XmlMapper responseMapper = new XmlMapper();
        ExecuteProjectResponseWrapper result = responseMapper.readValue(executeProjectResponseResponse, ExecuteProjectResponseWrapper.class);
        System.out.println(result.getBody().getExecuteProjectResponse().getBody().getProjectResultRef().getId());
    }

    @Test
    public void successMappingExecuteScenarioResponse() throws Exception {
        XmlMapper responseMapper = new XmlMapper();
        GetScenarioResultWrapper result = responseMapper.readValue(executeScenarioResponse, GetScenarioResultWrapper.class);
        System.out.println(result.getBody().getGetScenarioResultResponse().getBody().getSteps().get(1).getId());
    }

}
