package com.epam.handlers;

import com.epam.ComponentBean;
import com.epam.annotatedobject.AbstractAnnotatedObject;
import com.epam.annotations.Scope;
import com.epam.annotations.scope.ComponentScope;

import java.util.Properties;

/**
 * Created by Вадим on 04.07.2015.
 */
public class ScopeAnnotationHandler extends AbstractAnnotationHandler {

    private static final String SCOPE_NAME_PROPERTY = "$scope";

    @Override
    public void execute(ComponentBean componentBean, AbstractAnnotatedObject annotatedObject) {
        Properties properties = componentBean.getProperties();
        Scope scope = (Scope) annotatedObject.getAnnotation();
        ComponentScope value = scope.value();
        properties.put(SCOPE_NAME_PROPERTY, value.toString().toLowerCase());
    }
}
