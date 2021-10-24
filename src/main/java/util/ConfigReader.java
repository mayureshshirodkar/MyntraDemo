package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;
    private String configPath = "."+ File.separator +"src" + File.separator + "resources" + File.separator + "config" + File.separator + "config.properties";

    /**
     * This method is used to load the config properties
     * @return Properties object
     */
    public  Properties getConfig(){
        prop = new Properties();
        FileInputStream fis;
        try {
            fis = new FileInputStream(configPath);
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
