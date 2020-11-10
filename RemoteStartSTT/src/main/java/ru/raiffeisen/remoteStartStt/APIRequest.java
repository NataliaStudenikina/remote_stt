package ru.raiffeisen.remoteStartStt;

import org.apache.log4j.Logger;
import ru.raiffeisen.remoteStartStt.solanteq.soap.SolanteqAPI;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.executeprojectresponse.ExecuteProjectResponse;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getprojectresult.GetProjectResultResponse;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getprojectresult.Scenario;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getscenarioresult.GetScenarioResultResponse;

import java.util.Map;
import java.util.stream.Collectors;

public class APIRequest {
    final static Logger log = Logger.getLogger(APIRequest.class);

    private final String CODE_SUCCESS = "SLR-0001";
    private final String RESULT_WAIT = "WAITING";
    private final String RESULT_NOT_READY = "UNCOMPLETED";

    SolanteqAPI solanteqAPI = new SolanteqAPI();

    public ExecuteProjectResponse executeProject(String project, String environment){
        ExecuteProjectResponse exResponse = solanteqAPI.executeProject(project,environment);
        log.info("Get response from ExecuteProjectResponse "+ exResponse);
        String responseCode = exResponse.getExecuteProjectResponse().getBody().getResponse().getCode();

        log.info("Check responseCode" + responseCode);
        if(!responseCode.equals(CODE_SUCCESS))
            throw new RuntimeException("Code execute request ExecuteProject not equals SLR-0001");

        return exResponse;
    }

    public GetProjectResultResponse getProjectResult(ExecuteProjectResponse response) {
        String responseCode = response.getExecuteProjectResponse().getBody().getProjectResultRef().getId().toString();
        log.info("Get responseCode from ExecuteProjectResponse " + responseCode);
        return waitVerificationResultStatus(responseCode);
    }

    public Iterable<GetScenarioResultResponse> getScenarioResult(GetProjectResultResponse response) {
        log.info("Get response from GetScenarioResultResponse");
        return getScenarios(response)
                .keySet()
                .stream()
                .map(scenarioId -> solanteqAPI.getScenarioResult(scenarioId))
                .collect(Collectors.toList());
    }

    // =================================================================================================================
    // Implementation
    // =================================================================================================================

    private Map<Long, String> getScenarios(GetProjectResultResponse response) {
        log.info("Create MAP with Id Scenario and Name from GetProjectResultResponse");
        return response
                .getGetProjectResultResponse()
                .getBody()
                .getScenarios()
                .stream()
                .collect(Collectors.toMap(Scenario::getId, Scenario::getName));
    }

    private GetProjectResultResponse waitVerificationResultStatus (String responseCode) {
        GetProjectResultResponse response = solanteqAPI.getProjectResult(responseCode);
        log.info("Get response from GetProjectResultResponse: " + response);
        String result = response.getGetProjectResultResponse().getBody().getResult();
        log.info("Get result status from GetProjectResultResponse: " + response);
        long start_time = System.currentTimeMillis();
        long wait_time = 20000000;
        long end_time = start_time + wait_time;

        log.info("Check result code from GetProjectResultResponse: ");
        while ((result.equals(RESULT_WAIT) || result.equals(RESULT_NOT_READY))) {
            if (System.currentTimeMillis() > end_time) throw new RuntimeException("Timeout exceeded");

            try {
                Thread.sleep(2000);
            } catch(InterruptedException e) {
                throw new RuntimeException("Something went wrong while sleeping " + e);
            }
            response = solanteqAPI.getProjectResult(responseCode);
            result = response.getGetProjectResultResponse().getBody().getResult();
        }

        return response;
    }

}
