package com.epam.handlers;

import com.epam.ComponentBean;
import com.epam.annotatedobject.AbstractAnnotatedObject;
import com.epam.annotations.BaseProperties;

import java.util.Arrays;
import java.util.Properties;

/**
 * 7/6/2015
 *
 * @author Serhii_Laposhko
 */
public class BasePropertiesAnnotationHandler extends AbstractAnnotationHandler {

    @Override
    public void execute(ComponentBean componentBean, AbstractAnnotatedObject annotatedObject) {
        BaseProperties baseProperties = (BaseProperties) annotatedObject.getAnnotation();
        String[] basePropertiesValues = baseProperties.baseProperties();

        for (String basePropertiesValue : basePropertiesValues) {
            String[] splitProperty = basePropertiesValue.split("=");

            if (!validate(splitProperty)) {
                throw new RuntimeException("Error while validating property " + Arrays.toString(splitProperty));
            }

            Properties componentBeanProperties = componentBean.getProperties();
            componentBeanProperties.put(splitProperty[0].trim(), splitProperty[1].trim());
        }
    }

    private boolean validate(String[] property) {
        if (property == null || property.length != 2) {
            return false;
        }
        return true;//todo make more logic
    }

}
