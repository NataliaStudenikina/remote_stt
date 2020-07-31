package ru.raiffeisen.remoteStartStt.clients;

import ru.raiffeisen.remoteStartStt.solanteq.soap.ProcessingOfResult;
import ru.raiffeisen.remoteStartStt.utils.ResponseXMLMapper;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.executeprojectresponse.ExecuteProjectResponse;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.executeprojectresponse.ExecuteProjectResponseWrapper;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getprojectresult.GetProjectResultResponse;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getprojectresult.GetProjectResultSoapWrapper;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getscenarioresult.GetScenarioResultResponse;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getscenarioresult.GetScenarioResultWrapper;

public class SendingRequest {

    private static final String GET_PROJECT_RESULT = "getProjectResult";
    private static final String GET_SCENARIO_RESULT = "getScenarioResult";
    private static final String EXECUTE_PROJECT = "executeProject";

    ProcessingOfResult processingOfResult = new ProcessingOfResult();
    ResponseXMLMapper responseXMLMapper = new ResponseXMLMapper();

    public GetProjectResultResponse sendProjectResultRequest(String projectResultId) {
        String xml = processingOfResult.createXMLForGetProjectResult(projectResultId,GET_PROJECT_RESULT);
        String response = THttpClient.create().sendPostRequest(xml, GET_PROJECT_RESULT);

        return responseXMLMapper.getResponse(response, GetProjectResultSoapWrapper.class).getBody();
    }

    public GetScenarioResultResponse sendScenarioResultResponse(String scenarioId) {
        String xml = processingOfResult.createXMLForGetScenarioResult(scenarioId,GET_SCENARIO_RESULT);
        String response = THttpClient.create().sendPostRequest(xml, GET_SCENARIO_RESULT);

        return responseXMLMapper.getResponse(response, GetScenarioResultWrapper.class).getBody();
    }

    public ExecuteProjectResponse sendExecuteProjectResponse(String projectCode, String environmentCode) {
        String xml = processingOfResult.createXMLForExecuteProjectRequest(projectCode,environmentCode,GET_PROJECT_RESULT);
        String response = THttpClient.create().sendPostRequest(xml, EXECUTE_PROJECT);

        return responseXMLMapper.getResponse(response, ExecuteProjectResponseWrapper.class).getBody();
    }
}
