package com.epam.handlers;

import com.epam.ComponentBean;
import com.epam.annotatedobject.AbstractAnnotatedObject;

/**
 * Created by Вадим on 04.07.2015.
 */
public class DefaultAnnotationHandler extends AbstractAnnotationHandler {
    @Override
    public void execute(ComponentBean componentBean, AbstractAnnotatedObject annotatedObject) {
        System.out.println("You entered bad annotation");
    }
}
