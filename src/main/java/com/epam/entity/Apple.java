package com.epam.entity;

import com.epam.annotations.*;
import com.epam.annotations.scope.ComponentScope;

/**
 * Created by Вадим on 05.07.2015.
 */
@Component(path = "apple/apple")
@Scope(value = ComponentScope.SESSION)
@LoggingDebug(value = false)
@BaseProperties(baseProperties = {
        "baseProp1=value1",
        "baseProp2+=value2"
})
public class Apple {

    @InjectValue(value = "yellow apple")
    private String nameApple;

    public String getNameApple() {
        return nameApple;
    }

    public void setNameApple(String nameApple) {
        this.nameApple = nameApple;
    }
}
