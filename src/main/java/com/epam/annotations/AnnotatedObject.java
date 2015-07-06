package com.epam.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;

/**
 * Created by Vadym_Vlasenko on 06.07.2015.
 */
public class AnnotatedObject {

    @InjectValue(value = "")
    private Annotation annotation;
    private AccessibleObject object;

    public Annotation getAnnotation() {
        return annotation;
    }

    public void setAnnotation(Annotation annotation) {
        this.annotation = annotation;
    }

    public AccessibleObject getObject() {
        return object;
    }

    public void setObject(AccessibleObject object) {
        this.object = object;
    }
}
