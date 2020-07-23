package ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.executeprojectresponse;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.base.ResponsePayload;

@Data
@NoArgsConstructor
public class GetExecuteProjectResponse {
    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private ResponsePayload<GetExecuteProjectBody> getExecuteProjectResponse;
}
