package ru.raiffeisen.remoteStartStt;

import ru.raiffeisen.remoteStartStt.solanteq.soap.SolanteqAPI;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.executeprojectresponse.ExecuteProjectResponse;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getprojectresult.GetProjectResultResponse;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getprojectresult.Scenario;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getscenarioresult.GetScenarioResultResponse;
import java.util.Map;
import java.util.stream.Collectors;

public class CallSolanteqAPIRequest {
    private final String RESULT_SUCCESS = "SLR-0001";
    SolanteqAPI solanteqAPI = new SolanteqAPI();

    public ExecuteProjectResponse executeProject(String project, String environment){
        return solanteqAPI.executeProject(project,environment);
    }

    public GetProjectResultResponse getProjectResult(ExecuteProjectResponse response) {
        String responseCode = response.getExecuteProjectResponse().getBody().getResponse().getCode();

        if(!responseCode.equals(RESULT_SUCCESS))
            throw new RuntimeException("Код выволнения запроса ExecuteProject не равен SLR-0001");

        String resultId = response.getExecuteProjectResponse().getBody().getProjectResultRef().getId().toString();
        return solanteqAPI.getProjectResult(resultId);
    }

    public Iterable<GetScenarioResultResponse> getScenarioResult(GetProjectResultResponse response) {
        return getScenarios(response)
                .keySet()
                .stream()
                .map(scenarioId -> solanteqAPI.getScenarioResult(scenarioId))
                .collect(Collectors.toList());
    }

    private Map<Long, String> getScenarios(GetProjectResultResponse response) {
        return response
                .getGetProjectResultResponse()
                .getBody()
                .getScenarios()
                .stream()
                .collect(Collectors.toMap(Scenario::getId, Scenario::getName));
    }
}
