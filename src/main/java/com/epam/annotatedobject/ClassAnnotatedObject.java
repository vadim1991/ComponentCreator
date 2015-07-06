package com.epam.annotatedobject;

/**
 * Created by Vadym_Vlasenko on 06.07.2015.
 */
public class ClassAnnotatedObject extends AbstractAnnotatedObject {
    @Override
    public String getName() {
        return getAnnotation().toString();
    }
}
