package ru.raiffeisen.remoteStartStt.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Configuration {

     public Map<String,String> getPropertySheet(){
        Map <String,String> propertySheet = new HashMap<>();
        Properties prop = new Properties();
        try {
            prop.load(Configuration.class.getClassLoader().getResourceAsStream("executionData.properties"));
            for (String name: prop.stringPropertyNames())
                propertySheet.put(name, prop.getProperty(name));
        } catch (IOException e) {
            throw new RuntimeException("Что-то пошло не так при попытке получить данные из properties файла");
        }
        return propertySheet;
     }


}
