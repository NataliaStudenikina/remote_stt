package ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getscenarioresult.step;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Actual {

    @JacksonXmlProperty(namespace = "sol")
    private String type;

    @JacksonXmlProperty(namespace = "sol")
    private String value;
}
