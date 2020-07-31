package ru.raiffeisen.remoteStartStt;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import java.io.StringWriter;
import java.util.Map;

public class CreateTemplate {

    public String fillTemplate (String templateName, Map<String,String> templateDataMap){
        VelocityEngine engine = new VelocityEngine();
        engine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        engine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        engine.init();
        Template template  = engine.getTemplate("template/" + templateName);
        VelocityContext context = new VelocityContext();
        StringWriter writer = new StringWriter();
        templateDataMap.forEach(context::put);
        template.merge(context, writer);
        return writer.toString();
    }
}
