package ru.raiffeisen.remoteStartStt.soap;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
abstract public class Envelope<T1, T2> {
    @JacksonXmlProperty(namespace = "soapenv", localName = "Header")
    protected T1 header;

    @NonNull
    @JacksonXmlProperty(namespace = "soapenv", localName = "Body")
    protected T2 body;
}
