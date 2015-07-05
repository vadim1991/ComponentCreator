package com.epam.entity;

import com.epam.annotations.Component;
import com.epam.annotations.InjectValue;
import com.epam.annotations.Scope;

/**
 * Created by Вадим on 04.07.2015.
 */
@Component(path = "atg/bean/commerce")
@Scope
public class People {

    @InjectValue(name = "name",value = "Vadim")
    private String name;

    @InjectValue(name = "id",value = "5")
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

