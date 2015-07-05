package com.epam;

import com.epam.handlers.HandlerContainer;

import java.util.List;

/**
 * Created by Вадим on 05.07.2015.
 */
public class ComponentCreator {

    private String configPath;
    private String[] packageNames;
    private ComponentFinder componentFinder;
    private ComponentPropertyInitializer propertyInitializer;
    private ComponentSaver componentSaver;

    public ComponentCreator() {
        this.componentFinder = new ComponentFinder();
        this.componentSaver = new ComponentSaver();
        this.propertyInitializer = new ComponentPropertyInitializer(new HandlerContainer());
    }

    public String[] getPackageNames() {
        return packageNames;
    }

    public void setPackageNames(String[] packageNames) {
        this.packageNames = packageNames;
    }

    public String getConfigPath() {
        return configPath;
    }

    public void setConfigPath(String configPath) {
        this.configPath = configPath;
    }

    public void create() {
        List<Class<?>> components = componentFinder.findComponents(packageNames);
        System.out.println(components);
        List<ComponentBean> initializeComponents = propertyInitializer.getInitializeComponents(components);
        System.out.println(initializeComponents);
        componentSaver.save(initializeComponents, getConfigPath());
    }

}
