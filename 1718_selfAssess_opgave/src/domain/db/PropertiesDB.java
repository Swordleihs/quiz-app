package domain.db;

import domain.Exceptions.DomainException;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
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
            output = new FileOutputStream("evaluation.properties");
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
            this.input = this.getClass().getClassLoader().getResourceAsStream
                    ("domain/db/evaluation.properties");
            File file = new File("evaluation.properties");
            if(file.exists() && !file.isDirectory()){
                this.input = new FileInputStream(file);
            }
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