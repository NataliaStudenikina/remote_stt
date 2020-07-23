package ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.base;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

@Data
@NoArgsConstructor
public class Originator {
    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private String system;
}
