package domain.db;

import java.io.*;
import java.util.Properties;

public class PropertiesDB {

    private Properties prop = new Properties();
    private InputStream input = null;
    private OutputStream output = null;

    public Properties getProperties(){
        return  this.prop;
    }
    public PropertiesDB(){
        read();
    }

    public void write(){
        try {
            output = new FileOutputStream("/domain/db/evaluation.properties");
            // set the properties value
            //prop.setProperty(property, value);
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
        }
    }

    public void read(){
        try {
            this.input = this.getClass().getClassLoader().getResourceAsStream("domain/db/evaluation.properties");

            // load a properties file
            this.prop.load(this.input);

            // get the property value and print it out
            System.out.println("Evaluation mode: " + this.prop.getProperty("evaluation.mode"));

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