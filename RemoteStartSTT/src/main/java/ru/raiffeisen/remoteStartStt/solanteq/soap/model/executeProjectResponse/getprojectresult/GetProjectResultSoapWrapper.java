package ru.raiffeisen.remoteStartStt.solanteq.soap.model.executeProjectResponse.getprojectresult;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.raiffeisen.remoteStartStt.soap.Envelope;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class GetProjectResultSoapWrapper extends Envelope<Object, GetProjectResultResponse> {
}
