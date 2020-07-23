package ru.raiffeisen.remoteStartStt.configuration;

import org.junit.jupiter.api.Test;
import ru.raiffeisen.remoteStartStt.utils.Configuration;

import java.util.Map;

public class GetValueFromProperties {

    @Test
    public void successGetValueProperties() {
        Map<String,String> valuesFromProperties = new Configuration().getPropertySheet();
        System.out.println(valuesFromProperties.get("URL"));
    }
}
