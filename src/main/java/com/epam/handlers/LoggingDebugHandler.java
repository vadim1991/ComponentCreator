package com.epam.handlers;

import com.epam.ComponentBean;
import com.epam.annotatedobject.AbstractAnnotatedObject;
import com.epam.annotations.LoggingDebug;

import java.util.Properties;

/**
 * Created by Вадим on 05.07.2015.
 */
public class LoggingDebugHandler extends AbstractAnnotationHandler {

    private static final String LOGGING_DEBUG_PROPERTY = "loggingDebug";

    @Override
    public void execute(ComponentBean componentBean, AbstractAnnotatedObject annotatedObject) {
        Properties properties = componentBean.getProperties();
        LoggingDebug loggingDebug = (LoggingDebug) annotatedObject.getAnnotation();
        boolean value = loggingDebug.value();
        properties.put(LOGGING_DEBUG_PROPERTY, String.valueOf(value));
    }
}
