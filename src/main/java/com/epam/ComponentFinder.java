package com.epam;

import com.epam.annotations.Component;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Вадим on 04.07.2015.
 */
public class ComponentFinder {

    public List<Class<?>> findComponents(String[] packageNames) {
        List<Class<?>> componentClasses = new ArrayList<Class<?>>();
        if (packageNames != null) {
            for (String packageName : packageNames) {
                Reflections reflections = new Reflections(packageName);
                componentClasses.addAll(reflections.getTypesAnnotatedWith(Component.class));
            }
        }
        return componentClasses;
    }

}
