package domain.db.categoryStrategy;

import domain.model.Category;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.InputStream;

public interface CategoryReader {

    InputStream getFile();

    ObservableList<Category> read();
}
