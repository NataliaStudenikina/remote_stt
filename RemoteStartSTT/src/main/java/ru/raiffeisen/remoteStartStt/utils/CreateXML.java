package ru.raiffeisen.remoteStartStt.utils;

import java.util.HashMap;
import java.util.Map;

public class CreateXML {

    private Map<String,String> createMapForRequest(String key, String value) {
        Map<String, String> templateDataMAP = new HashMap<String, String>();
        templateDataMAP.put(key,value);
        return templateDataMAP;
    }

    public String createXMLForGetProjectResult(String projectResultId, String templateName) {
        String template = new CreateTemplate().fillTemplate(templateName + ".xml",
                createMapForRequest("projectResultId",projectResultId));
        return template;
    }

    public String createXMLForGetScenarioResult(String scenarioId,String templateName) {
        String template = new CreateTemplate().fillTemplate(templateName + ".xml",
                createMapForRequest("scenarioId",scenarioId));
        return template;
    }

    public String createXMLForExecuteProjectRequest(String projectCode, String environmentCode, String templateName) {
        Map<String, String> requestData = new HashMap<String, String>();
        //TODO
        requestData.put("project_code", projectCode);
        requestData.put("project_environmentCode",environmentCode);
        String template = new CreateTemplate().fillTemplate(templateName + ".xml",
                requestData);
        return template;
    }

}
