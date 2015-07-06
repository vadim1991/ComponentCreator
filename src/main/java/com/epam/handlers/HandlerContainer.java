package com.epam.handlers;

import com.epam.annotations.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Вадим on 04.07.2015.
 */
public class HandlerContainer {

    private static final String INJECT_VALUE_HANDLER = InjectValue.class.getSimpleName();
    private static final String COMPONENT_HANDLER = Component.class.getSimpleName();
    private static final String SCOPE_HANDLER = Scope.class.getSimpleName();
    private static final String LOGGING_DEBUG_HANDLER = LoggingDebug.class.getSimpleName();
    private static final String BASE_PROPERTY_HANDLER = BaseProperties.class.getSimpleName();

    private Map<String, AnnotationHandler> handlerMap;

    public HandlerContainer() {
        handlerMap = new HashMap<String, AnnotationHandler>();
        init();
    }

    public AnnotationHandler getAnnotationHandler(String annotationName) {
        AnnotationHandler annotationHandler = null;
        if (annotationName != null) {
            annotationHandler = handlerMap.get(annotationName);
        }
        return annotationHandler != null ? annotationHandler : new DefaultAnnotationHandler();
    }

    private void init() {
        handlerMap.put(INJECT_VALUE_HANDLER, new InjectAnnotationHandler());
        handlerMap.put(COMPONENT_HANDLER, new ComponentAnnotationHandler());
        handlerMap.put(SCOPE_HANDLER, new ScopeAnnotationHandler());
        handlerMap.put(LOGGING_DEBUG_HANDLER, new LoggingDebugHandler());
        handlerMap.put(BASE_PROPERTY_HANDLER, new BasePropertiesAnnotationHandler());
    }
}
