package domain.db.categoryStrategy;

import domain.model.Category;
import javafx.collections.ObservableList;

public interface CategoryWriter {

    void write(ObservableList<Category> categories);
}
