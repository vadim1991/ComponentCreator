package com.epam.test;

import com.epam.ComponentCreator;

import java.io.IOException;

/**
 * Created by Вадим on 04.07.2015.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String[] packageNames = {"com.epam"};
        ComponentCreator componentCreator = new ComponentCreator();
        componentCreator.setConfigPath("c:");
        componentCreator.setPackageNames(packageNames);
        componentCreator.create();
    }

}
