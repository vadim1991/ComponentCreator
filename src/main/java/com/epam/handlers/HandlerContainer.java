package com.epam.handlers;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Вадим on 04.07.2015.
 */
public class HandlerContainer {

    private static String INJECT_VALUE_HANDLER = "InjectValue";
    private static String COMPONENT_HANDLER = "Component";
    private static String SCOPE_HANDLER = "Scope";
    private static String LOGGING_DEBUG_HANDLER = "LoggingDebug";

    private Map<String, AnnotationHandler> handlerMap;

    public HandlerContainer() {
        this.handlerMap = new HashMap<String, AnnotationHandler>();
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
    }
}
