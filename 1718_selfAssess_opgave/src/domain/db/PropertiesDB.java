package domain.db;

import java.io.*;
import java.util.Properties;

public class PropertiesDB {
    public PropertiesDB(){
        Properties prop = new Properties();

        OutputStream output = null;
        InputStream input = null;

/*        try {
            output = new FileOutputStream("evaluation.properties");
            // set the properties value
            prop.setProperty("evaluation.mode", "feedback");
            // save properties to project root folder
            prop.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }*/

        try {

            input = PropertiesDB.class.getClass().getResourceAsStream("/evaluation.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("evalution.mode"));


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}