package ru.raiffeisen.remoteStartStt.solanteq.soap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.executeprojectresponse.ExecuteProjectResponseWrapper;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.executeprojectresponse.GetExecuteProjectBody;

public class ProcessingOfResults {

    private GetExecuteProjectBody getValueOfProjectResult(String projectResultXML) {
        XmlMapper responseMapper = new XmlMapper();
        try {
            ExecuteProjectResponseWrapper result = responseMapper.readValue(projectResultXML, ExecuteProjectResponseWrapper.class);
            return result.getBody().getExecuteProjectResponse().getBody();
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Что-то пошло не так при попытке десериализовать XML объект" + e);
        }
    }

    protected String getCodeFomResponse(String projectResultXML) {
        return getValueOfProjectResult(projectResultXML).getResponse().getCode();
    }

    protected Long getIdResponse(String projectResultXML) {
        return getValueOfProjectResult(projectResultXML).getProjectResultRef().getId();
    }


}
