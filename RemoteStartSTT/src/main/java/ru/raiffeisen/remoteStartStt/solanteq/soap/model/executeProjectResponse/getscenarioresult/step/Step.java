package ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getscenarioresult.step;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class Step {

    @JacksonXmlProperty(namespace = "sol")
    private Long id;

    @JacksonXmlProperty(namespace = "sol")
    private String ordinal;

    @JacksonXmlProperty(namespace = "sol")
    private Date startDate; // TODO: Change to DateTime

    @JacksonXmlProperty(namespace = "sol")
    private Date finishDate;// TODO: Change to DateTime

    @JacksonXmlProperty(namespace = "sol")
    private String result;

    @JacksonXmlProperty(namespace = "sol")
    private String name;

    @JacksonXmlProperty(namespace = "sol")
    private String direction;

    @JacksonXmlProperty(namespace = "sol")
    private String description;

    @JacksonXmlProperty(namespace = "sol")
    private String resultMessage;

    @JacksonXmlProperty(namespace = "sol")
    private String messageType;

    @JacksonXmlProperty(namespace = "sol")
    private Channel channel;

    @JacksonXmlProperty(namespace = "sol")
    private Template template;

    @JacksonXmlProperty(namespace = "sol")
    private List<Validation> validations;

}
