package ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.executeprojectresponse;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.base.BodyResponse;
import ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.base.ProjectResultRef;

@Data
@NoArgsConstructor
public class GetExecuteProjectBody {

    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private BodyResponse response;

    @NonNull
    @JacksonXmlProperty(namespace = "sol")
    private ProjectResultRef projectResultRef;
}
