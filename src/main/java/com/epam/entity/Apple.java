package com.epam.entity;

import com.epam.annotations.Component;
import com.epam.annotations.InjectValue;
import com.epam.annotations.LoggingDebug;
import com.epam.annotations.Scope;
import com.epam.annotations.scope.ComponentScope;

/**
 * Created by Вадим on 05.07.2015.
 */
@Component(path = "apple/apple")
@Scope(value = ComponentScope.SESSION)
@LoggingDebug(value = false)
public class Apple {

    @InjectValue(name = "apple", value = "red apple")
    private String nameApple;

    public String getNameApple() {
        return nameApple;
    }

    public void setNameApple(String nameApple) {
        this.nameApple = nameApple;
    }
}
