package ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.base;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

@Data
@NoArgsConstructor
public class Protocol {
    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private String name;

    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private String version;
}
