package ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getscenarioresult.step;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Template {
    @JacksonXmlProperty(namespace = "sol")
    private Long id;

    @JacksonXmlProperty(namespace = "sol")
    private String auditDate; // TODO: Change to DateTime

    @JacksonXmlProperty(namespace = "sol")
    private String code;

    @JacksonXmlProperty(namespace = "sol")
    private String name;

    @JacksonXmlProperty(namespace = "sol")
    private String description;
}
