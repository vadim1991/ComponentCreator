package com.epam;

import java.io.*;
import java.util.List;
import java.util.Properties;

/**
 * Created by Вадим on 05.07.2015.
 */
public class ComponentSaver {

    public void save(List<ComponentBean> componentBeans, String configPath) {
        if (componentBeans != null) {
            for (ComponentBean componentBean : componentBeans) {
                try {
                    saveComponent(componentBean, configPath);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    //we must check full file name on valid
    private void saveComponent(ComponentBean componentBean, String configPath) throws IOException {
        Properties properties = componentBean.getProperties();
        String fileName = componentBean.getFileName() + ".properties";
        String fullFileName = configPath + File.separator + fileName;
        File file = new File(fullFileName);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        } else {
            Properties propertiesFromFile = loadPropertiesFromFile(file);
            properties = copyPropertiesFromFile(properties, propertiesFromFile);
        }
        FileOutputStream outputStream = new FileOutputStream(file);
        properties.store(outputStream, "create by custom library");
        outputStream.close();
    }

    private Properties loadPropertiesFromFile(File file) throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(file);
        properties.load(fileInputStream);
        return properties;
    }

    private Properties copyPropertiesFromFile(Properties properties, Properties propertiesFromFile) {
        if (properties != null & propertiesFromFile != null) {
            propertiesFromFile.putAll(properties);
        }
        return propertiesFromFile;
    }

}
