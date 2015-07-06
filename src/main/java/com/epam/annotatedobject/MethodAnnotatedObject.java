package com.epam.annotatedobject;

import java.lang.reflect.Method;

/**
 * Created by Vadym_Vlasenko on 06.07.2015.
 */
public class MethodAnnotatedObject extends AbstractAnnotatedObject {

    private Method method;

    public MethodAnnotatedObject(Method method) {
        this.method = method;
    }

    @Override
    public String getName() {
        String name = method.getName().substring(3);
        char firstLetter = Character.toLowerCase(name.charAt(0));
        String nameWithoutFirstLetter = name.substring(1);
        return firstLetter + nameWithoutFirstLetter;
    }
}
