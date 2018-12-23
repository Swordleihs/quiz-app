package domain.db;

import domain.Exceptions.DomainException;
import domain.Exceptions.dbException;
import sun.misc.IOUtils;

import java.io.*;

public class LastTestDB {
    private InputStream f;

    public LastTestDB(){
        f = getClass().getClassLoader().getResourceAsStream(
                "domain/db/LastTest.txt");
        if (f == null){
            throw new DomainException("foutje bij het lezen van file");
        }
        File file = new File("LastTest.txt");
        try {
            if (file.exists() && !file.isDirectory()) {
                f = new FileInputStream(file);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public String read(){
        String result = "";
        try{
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(f));
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
