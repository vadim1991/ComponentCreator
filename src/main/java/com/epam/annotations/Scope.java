package com.epam.annotations;

import com.epam.annotations.scope.ComponentScope;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Вадим on 04.07.2015.
 */
@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Scope {
    ComponentScope value() default ComponentScope.GLOBAL;
}
