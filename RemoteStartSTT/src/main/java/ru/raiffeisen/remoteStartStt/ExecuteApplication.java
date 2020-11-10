package ru.raiffeisen.remoteStartStt;

import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.executeprojectresponse.ExecuteProjectResponse;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getprojectresult.GetProjectResultResponse;
import java.util.HashMap;
import java.util.Map;

public class ExecuteApplication {
     APIRequest apiRequest = new APIRequest();

     public static String enviroment = "onlinec";

    public static void main(String[] attrs){
        new ExecuteApplication().executeApplication();
    }

    private void executeApplication() {
        Map<String,String> requestData = new HashMap<>();
        //TODO
        requestData.put("ecom acq",enviroment);
        for(Map.Entry<String,String> entry : requestData.entrySet()){
            getRequestResult(entry.getKey(),entry.getValue());
        }
    }

    private void getRequestResult(String project, String environment ){
        ExecuteProjectResponse executeProject = apiRequest.executeProject(project,environment);
        GetProjectResultResponse projectResult = apiRequest.getProjectResult(executeProject);
        new APIRequest().getScenarioResult(projectResult);
    }
}
