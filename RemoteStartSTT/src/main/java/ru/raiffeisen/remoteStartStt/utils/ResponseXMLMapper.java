package ru.raiffeisen.remoteStartStt.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class ResponseXMLMapper {

    public <T> T getResponse(String response, Class<T> valueType) {
        XmlMapper responseMapper = new XmlMapper();
        try {
            return responseMapper.readValue(response,valueType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Что-то пошло не так при попытке получить Response");
        }
    }

}
