package ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getprojectresult;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.base.BodyResponse;

import java.util.List;

@Data
@NoArgsConstructor
public class GetProjectResultBody {
    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private BodyResponse response;

    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private String result;

    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private Integer passed;

    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private Integer failed;

    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private Integer skipped;

    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private List<Scenario> scenarios;
}
