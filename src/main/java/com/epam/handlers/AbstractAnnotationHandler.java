package com.epam.handlers;

import com.epam.ComponentBean;

import java.lang.annotation.Annotation;

/**
 * Created by Вадим on 04.07.2015.
 */
public abstract class AbstractAnnotationHandler implements AnnotationHandler {

    public abstract void execute(ComponentBean componentBean, Annotation annotation);

}
