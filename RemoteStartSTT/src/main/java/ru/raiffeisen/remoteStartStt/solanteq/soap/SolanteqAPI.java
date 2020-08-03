package ru.raiffeisen.remoteStartStt.solanteq.soap;

import ru.raiffeisen.remoteStartStt.clients.SendingRequest;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.executeprojectresponse.ExecuteProjectResponse;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getprojectresult.GetProjectResultResponse;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getscenarioresult.GetScenarioResultResponse;

public class SolanteqAPI {

    SendingRequest sendingRequest = new SendingRequest();

    public ExecuteProjectResponse executeProject(String project, String environment) {
        return sendingRequest.sendExecuteProjectResponse(project,environment);
    }

    public GetProjectResultResponse getProjectResult(String projectResultId){
        return sendingRequest.sendProjectResultRequest(projectResultId);
    }

    public GetScenarioResultResponse getScenarioResult(Long scenarioId){
        return sendingRequest.sendScenarioResultResponse(scenarioId);
    }


}
