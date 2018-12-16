package domain.db.categoryStrategy;

import domain.model.Category;
import javafx.collections.ObservableList;

public abstract class CategoryContext {

    CategoryReader categoryReader;
    CategoryWriter categoryWriter;

    public void setCategoryReader(CategoryReader categoryReader) {
        this.categoryReader = categoryReader;
    }

    public void setCategoryWriter(CategoryWriter categoryWriter){
        this.categoryWriter = categoryWriter;
    }

    public ObservableList<Category> performRead(){
        return this.categoryReader.read();
    }

    public void performWrite(ObservableList<Category> categories){
        this.categoryWriter.write(categories);
    }
}
