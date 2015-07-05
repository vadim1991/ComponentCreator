package com.epam;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
        String fileName = componentBean.getFileName() + ".properties";
        String fullFileName = configPath + File.separator + fileName;
        File file = new File(fullFileName);
        file.getParentFile().mkdirs();
        file.createNewFile();
        Properties properties = componentBean.getProperties();
        FileOutputStream outputStream = new FileOutputStream(file);
        properties.store(outputStream, "create by custom library");
        outputStream.close();
    }

}
