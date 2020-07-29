package ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getscenarioresult.step;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class Step {

    @JacksonXmlProperty(namespace = "sol")
    private Long id;

    @JacksonXmlProperty(namespace = "sol")
    private String ordinal;

    @JacksonXmlProperty(namespace = "sol")
    private String startDate; // TODO: Change to DateTime

    @JacksonXmlProperty(namespace = "sol")
    private String finishDate;// TODO: Change to DateTime

    @JacksonXmlProperty(namespace = "sol")
    private String result;

    @JacksonXmlProperty(namespace = "sol")
    private String name;

    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private String direction;

    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private String description;

    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private String resultMessage;

    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private String messageType;

    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private Channel channel;

    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private Template template;

    @JacksonXmlProperty(namespace = "sol")
    private Validation validations;

}
