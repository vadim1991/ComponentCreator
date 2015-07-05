package com.epam;

import java.util.Properties;

/**
 * Created by Вадим on 04.07.2015.
 */
public class ComponentBean {

    private String fileName;
    private Properties properties;
    private Class componentClass;

    public ComponentBean() {
        this.properties = new Properties();
    }

    public Class getComponentClass() {
        return componentClass;
    }

    public void setComponentClass(Class componentClass) {
        this.componentClass = componentClass;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Properties getProperties() {
        return properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComponentBean)) return false;

        ComponentBean that = (ComponentBean) o;

        if (componentClass != null ? !componentClass.equals(that.componentClass) : that.componentClass != null)
            return false;
        if (fileName != null ? !fileName.equals(that.fileName) : that.fileName != null) return false;
        if (properties != null ? !properties.equals(that.properties) : that.properties != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fileName != null ? fileName.hashCode() : 0;
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        result = 31 * result + (componentClass != null ? componentClass.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ComponentBean{" +
                "fileName='" + fileName + '\'' +
                ", properties=" + properties +
                ", componentClass=" + componentClass +
                '}';
    }
}
