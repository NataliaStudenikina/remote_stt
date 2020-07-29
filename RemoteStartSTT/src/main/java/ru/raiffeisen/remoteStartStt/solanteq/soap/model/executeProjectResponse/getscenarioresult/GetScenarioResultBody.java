package ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getscenarioresult;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.base.BodyResponse;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getscenarioresult.step.Step;

import java.util.List;

@Data
@NoArgsConstructor
public class GetScenarioResultBody {
    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private BodyResponse response;

    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private String result;

    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private String startDate; // TODO: Change to DateTime

    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private String finishDate; // TODO: Change to DateTime

    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private List<Step> steps;
}
