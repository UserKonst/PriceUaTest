/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package price.registrationtest.customclasess;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 *
 * @author Konst
 */
public class UserVariables {

    private static UserVariables instance;

    public static synchronized UserVariables getInstance() {
        if (instance == null) {
            instance = new UserVariables();
        }
        return instance;
    }

    private final String config = "src/main/resources/userdata/config.properties";
    private static Properties properties;
    private final String userPassword;
    private final String userEmail;
    private final String baseURL;
    public final String userName;

    public UserVariables() {
        properties = getProperties();
        userEmail = properties.getProperty("email");
        userPassword = properties.getProperty("password");
        baseURL = properties.getProperty("baseURL");
        userName = properties.getProperty("username");
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public String getUserName() {
        return userName;
    }

    public Properties getProperties() {
        Properties props = new Properties();
        InputStreamReader input;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(config);
            input = new InputStreamReader(fileInputStream, "UTF8");

            props.load(input);

            return props;
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Ошибка. Файл config.properties не был найден.");
            return null;
        } catch (java.io.IOException e) {
            System.out.println("IO ошибка в пользовательском методе.");
            return null;
        }
    }

}
