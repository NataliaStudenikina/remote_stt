package ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getscenarioresult;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.base.ResponsePayload;

@Data
@NoArgsConstructor
public class GetScenarioResultResponse {
    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private ResponsePayload<GetScenarioResultBody> getScenarioResultResponse;
}
