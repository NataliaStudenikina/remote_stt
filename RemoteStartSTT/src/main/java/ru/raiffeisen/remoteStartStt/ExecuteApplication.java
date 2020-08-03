package ru.raiffeisen.remoteStartStt;

import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.executeprojectresponse.ExecuteProjectResponse;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getprojectresult.GetProjectResultResponse;

public class ExecuteApplication {

    CallSolanteqAPIRequest callSolanteqAPIRequest = new CallSolanteqAPIRequest();

    public static void main(String[] attrs){
        ExecuteProjectResponse executeProject = new CallSolanteqAPIRequest().executeProject("ecom acq","onlinec");
        GetProjectResultResponse projectResult = new CallSolanteqAPIRequest().getProjectResult(executeProject);
        new CallSolanteqAPIRequest().getScenarioResult(projectResult);
    }
}
