package Utils;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static String readProperty(String key)  {
        //File class assign given file to the java object
        File file=new File("configuration.properties");
        Properties properties=new Properties();
        try {
            properties.load((new FileInputStream(file)));
            //load method will load every value from file object to the
            //properties object
        } catch (IOException e) {
            e.printStackTrace();
        }
        //more actions surrond bu try and catch
        return properties.getProperty(key);
        // i can read the value from properties object using the key .
    }}
