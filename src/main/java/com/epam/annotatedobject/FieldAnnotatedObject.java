package com.epam.annotatedobject;

import java.lang.reflect.Field;

/**
 * Created by Vadym_Vlasenko on 06.07.2015.
 */
public class FieldAnnotatedObject extends AbstractAnnotatedObject {

    private Field field;

    public FieldAnnotatedObject(Field field) {
        this.field = field;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    @Override
    public String getName() {
        return field.getName();
    }
}
