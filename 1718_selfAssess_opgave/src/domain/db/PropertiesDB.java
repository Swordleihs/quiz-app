package domain.db;

import java.io.*;
import java.util.Properties;

public class PropertiesDB {

    private Properties prop = new Properties();
    private InputStream input = null;
    private OutputStream output = null;


    public PropertiesDB(){
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
            this.input = new FileInputStream("evaluation.properties");
            System.out.println(this.input);

            // load a properties file
            this.prop.load(this.input);

            // get the property value and print it out
            System.out.println(this.prop.getProperty("evaluation.mode"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (this.input != null) {
                try {
                    this.input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}