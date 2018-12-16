package domain.db.categoryStrategy;

import domain.model.Category;
import javafx.collections.ObservableList;

import java.io.File;

public interface CategoryReader {

    File getFile();

    ObservableList<Category> read();
}
