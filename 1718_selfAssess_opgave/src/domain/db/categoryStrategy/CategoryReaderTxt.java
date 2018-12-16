package domain.db.categoryStrategy;

import domain.Exceptions.dbException;
import domain.model.Category;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CategoryReaderTxt implements CategoryReader {

    @Override
    public File getFile() {
        File file = new File("Categories.txt");
        if (file.isDirectory() || !file.exists()) {
            throw new dbException("txt file not found.");
        }
        return file;
    }

    @Override
    public ObservableList<Category> read() {
        ObservableList<Category> categories = FXCollections.observableArrayList(new ArrayList<>());
        File file = this.getFile();

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
