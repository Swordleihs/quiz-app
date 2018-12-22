package domain.db.categoryStrategy;

import domain.Exceptions.DomainException;
import domain.Exceptions.dbException;
import domain.model.Category;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sun.plugin2.ipc.unix.DomainSocketNamedPipe;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class CategoryReaderTxt implements CategoryReader {

    @Override
    public InputStream getFile() {
        InputStream file = getClass().getClassLoader().getResourceAsStream(
                "domain/db/categoryStrategy/Categories.txt");
        if (file == null){
            throw new DomainException("foutje bij het lezen van file");
        }
        return file;
    }

    @Override
    public ObservableList<Category> read() {
        ObservableList<Category> categories = FXCollections.observableArrayList(new ArrayList<>());
        InputStream file = this.getFile();

        try {
            Scanner scan = new Scanner(file, "UTF-8");
            while (scan.hasNextLine()) {
                Scanner line = new Scanner(scan.nextLine());
                line.useDelimiter(";");
                String cat = line.next();
                String desc = line.next();
                String sup = "";
                if (line.hasNext()) {
                    sup = line.next();
                }
                if (sup.equals("")) {
                    Category category = new Category(cat, desc);
                    categories.add(category);
                    System.out.println(cat + " added without sup");
                } else {
                    Category category = new Category(cat, desc, sup);
                    categories.add(category);
                    System.out.println(cat + " added with sup");
                }
            }
        } catch (Exception e) {
            throw new dbException("Error when trying to read txt file.");
        }

        return categories;
    }
}
