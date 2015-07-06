package com.epam.handlers;

import com.epam.ComponentBean;
import com.epam.annotatedobject.AbstractAnnotatedObject;
import com.epam.annotations.InjectValue;

import java.util.Properties;

/**
 * Created by Вадим on 04.07.2015.
 */
public class InjectAnnotationHandler extends AbstractAnnotationHandler {

    @Override
    public void execute(ComponentBean componentBean, AbstractAnnotatedObject annotatedObject) {
        InjectValue injectValue = (InjectValue) annotatedObject.getAnnotation();
        String name = injectValue.name();
        String value = injectValue.value();
        if (!isValidValue(value)) {
            throw new RuntimeException();
        }
        name = getPropertyName(name, annotatedObject);
        Properties properties = componentBean.getProperties();
        properties.put(name, value);
    }

    //in this method we must check value (if it component path)
    // TODO find out the way to validate this value
    private boolean isValidValue(String value) {
        return true;
    }

    private String getPropertyName(String name, AbstractAnnotatedObject annotatedObject) {
        return name.isEmpty() ? annotatedObject.getName() : name;
    }

}
