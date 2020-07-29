package ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getscenarioresult.step;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Validation {
    @JacksonXmlProperty(namespace = "sol")
    private Long id;

    @JacksonXmlProperty(namespace = "sol")
    private String name;

    @JacksonXmlProperty(namespace = "sol")
    private String description;

    @JacksonXmlProperty(namespace = "sol")
    private String expression;

    @JacksonXmlProperty(namespace = "sol")
    private String type;

    @JacksonXmlProperty(namespace = "sol")
    private String result;

    @JacksonXmlProperty(namespace = "sol")
    private String source;

    @JacksonXmlProperty(namespace = "sol")
    private String resultMessage;

    @JacksonXmlProperty(namespace = "sol")
    private Expected expected;

    @JacksonXmlProperty(namespace = "sol")
    private Actual actual;
}
