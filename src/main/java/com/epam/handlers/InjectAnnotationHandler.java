package com.epam.handlers;

import com.epam.ComponentBean;
import com.epam.annotations.InjectValue;

import java.lang.annotation.Annotation;
import java.util.Properties;

/**
 * Created by Вадим on 04.07.2015.
 */
public class InjectAnnotationHandler extends AbstractAnnotationHandler {

    @Override
    public void execute(ComponentBean componentBean, Annotation annotation) {
        InjectValue injectValue = (InjectValue) annotation;
        String name = injectValue.name();
        String value = injectValue.value();
        if (!isValidValue(value)) {
            throw new RuntimeException();
        }
        Properties properties = componentBean.getProperties();
        properties.put(name, value);
    }

    //in this method we must check value (if it component path)
    private boolean isValidValue(String value) {
        return true;
    }

}
