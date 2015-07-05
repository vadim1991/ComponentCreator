package com.epam.handlers;

import com.epam.ComponentBean;

import java.lang.annotation.Annotation;

/**
 * Created by Вадим on 04.07.2015.
 */
public class DefaultAnnotationHandler extends AbstractAnnotationHandler {
    @Override
    public void execute(ComponentBean componentBean, Annotation annotation) {
        System.out.println("You entered bad annotation");
    }
}
