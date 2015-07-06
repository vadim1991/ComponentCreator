package com.epam.annotatedobject;

import java.lang.annotation.Annotation;

/**
 * Created by Vadym_Vlasenko on 06.07.2015.
 */
public abstract class AbstractAnnotatedObject {

    private Annotation annotation;

    public Annotation getAnnotation() {
        return annotation;
    }

    public void setAnnotation(Annotation annotation) {
        this.annotation = annotation;
    }

    public abstract String getName();

}
