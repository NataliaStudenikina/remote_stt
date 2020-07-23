package ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.base;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class Header {
    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private Protocol protocol;

    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private String messageDate; // TODO: Change to DateTime

    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private Originator originator;

    @JacksonXmlProperty(namespace = "sol")
    private String messageId;
}
