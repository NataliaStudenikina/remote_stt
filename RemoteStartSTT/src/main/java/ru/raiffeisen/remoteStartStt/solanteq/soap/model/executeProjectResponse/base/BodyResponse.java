package ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.base;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

@Data
@NoArgsConstructor
public class BodyResponse {
    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private String type;

    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private String code;

    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private  String message;
}
