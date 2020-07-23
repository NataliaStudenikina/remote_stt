package ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.base;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

@Data
@NoArgsConstructor
public class ResponsePayload<T> {
    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    protected Header header;

    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    protected T body;
}
