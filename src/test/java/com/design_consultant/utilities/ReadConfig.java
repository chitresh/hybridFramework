package com.design_consultant.utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    Properties pro;
    public ReadConfig()
    {
        File src = new File("./configurations/config.properties");
        FileInputStream fs;

        {
            try {
                fs = new FileInputStream(src);
                pro = new Properties();
                pro.load(fs);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public String getApplicationURL()
    {
        return pro.getProperty("baseURL");

    }

    public String getUsername()
    {
        return pro.getProperty("username");

    }

    public String getPassword()
    {
        return pro.getProperty("password");

    }

    public String getChromepath(){
        return pro.getProperty("chromepath");
    }

}
