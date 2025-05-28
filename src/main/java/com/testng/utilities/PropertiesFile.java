package com.testng.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

    FileInputStream fileinput=null;

    public String getProperty(String key) {
        //1. path
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        String filepath = projectPath+"//properties//application.properties";

        //2. converted the path intoObject

        try {
            fileinput = new FileInputStream(filepath);
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        //3. convert the file Object into Properties Object
        Properties prop = new Properties();
        try {
            prop.load(fileinput);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //4. prop have a key value pair data its like a hashmap.

        String value = prop.getProperty(key);
        return value;

    }
}
