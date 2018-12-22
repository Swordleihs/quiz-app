package domain.db.categoryStrategy;

import domain.Exceptions.dbException;
import domain.model.Category;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.InputStream;

public class CategoryReaderExcel implements CategoryReader {
    @Override
    public InputStream getFile() {
        /*File file = new File("Categories.xls");
        if (file.isDirectory() || !file.exists()) {
            File file2 = new File("categories.xlsx");
            if (file2.isDirectory() || !file2.exists()) {
                throw new dbException("txt file not found.");
            }
            return file2;
        }
        return file;
        */
        return null;
    }

    @Override
    public ObservableList<Category> read() {
        return null;
    }
}
