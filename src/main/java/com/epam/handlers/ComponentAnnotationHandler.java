package com.epam.handlers;

import com.epam.ComponentBean;
import com.epam.annotatedobject.AbstractAnnotatedObject;
import com.epam.annotations.Component;

import java.util.Properties;

/**
 * Created by Вадим on 04.07.2015.
 */
public class ComponentAnnotationHandler extends AbstractAnnotationHandler {

    private static final String CLASS_NAME_PROPERTY = "$class";

    @Override
    public void execute(ComponentBean componentBean, AbstractAnnotatedObject annotatedObject) {
        Properties properties = componentBean.getProperties();
        Class<?> componentClass = componentBean.getComponentClass();
        Component componentClassAnnotation = (Component) annotatedObject.getAnnotation();
        String path = componentClassAnnotation.path();
        componentBean.setFileName(path);
        properties.put(CLASS_NAME_PROPERTY, componentClass.getName());
    }
}
