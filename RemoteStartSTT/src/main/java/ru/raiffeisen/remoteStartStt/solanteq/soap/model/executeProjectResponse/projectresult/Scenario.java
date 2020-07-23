package ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.projectresult;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

@Data
@NoArgsConstructor
public class Scenario {
    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private Long id;

    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private String result;

    @JacksonXmlProperty(namespace = "sol")
    private String code;

    @JacksonXmlProperty(namespace = "sol")
    private String name;
}
