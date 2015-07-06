package com.epam.handlers;

import com.epam.ComponentBean;
import com.epam.annotations.AnnotatedObject;
import com.epam.annotations.InjectValue;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.util.Properties;

/**
 * Created by Вадим on 04.07.2015.
 */
public class InjectAnnotationHandler extends AbstractAnnotationHandler {

    @Override
    public void execute(ComponentBean componentBean, AnnotatedObject annotatedObject) {
        InjectValue injectValue = (InjectValue) annotatedObject.getAnnotation();
        String name = injectValue.name();
        String value = injectValue.value();
        if (!isValidValue(value)) {
            throw new RuntimeException();
        }
        Properties properties = componentBean.getProperties();
        properties.put(name, value);
    }

    //in this method we must check value (if it component path)
    // TODO find out the way to validate this value
    private boolean isValidValue(String value) {
        return true;
    }

    private String setPropertyName(String name, AccessibleObject accessibleObject) {
        //return name.isEmpty()?accessibleObject.
        return null;
    }

}
