package domain.db;

import domain.Exceptions.dbException;
import sun.misc.IOUtils;

import java.io.*;

public class LastTestDB {
    private File f;

    public LastTestDB(){
        f = new File("LastTest.txt");
        if (f.isDirectory() || !f.exists()) {
            throw new dbException("File niet gevonden");
        }
    }
    public String read(){
        String result = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader("LastTest.txt"));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            result = sb.toString();

            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public void write(String s){
        try {
            PrintWriter out = new PrintWriter("LastTest.txt");
            out.println(s);
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
