package ru.raiffeisen.remoteStartStt.solanteq.soap;

import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.executeprojectresponse.ExecuteProjectResponse;

import java.util.HashMap;
import java.util.Map;

public class ProcessingOfResult {

    private Map<String, String> generateGetProjectResultMAP(String projectResultId) {
        Map<String, String> requestData = new HashMap<String, String>();
        requestData.put("projectResultId", projectResultId);
        return requestData;
    }

    public Map<String,String> createGetProjectResultIdMAP (ExecuteProjectResponse response){
        String projectResultId = response.getExecuteProjectResponse().getBody().getProjectResultRef().getId().toString();
        return generateGetProjectResultMAP(projectResultId);
    }

}
