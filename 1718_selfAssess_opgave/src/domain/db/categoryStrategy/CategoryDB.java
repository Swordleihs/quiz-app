package domain.db.categoryStrategy;

import domain.model.Category;
import javafx.collections.ObservableList;
import java.util.ArrayList;

public class CategoryDB extends CategoryContext{
    private ObservableList<Category> categories;

    public CategoryDB(String property) {
        this.setCategoryWriter(new CategoryWriterTxt());
        this.fill(property);
    }

    private void fill(String property) {
        if (property.equals("txt")){
            this.setCategoryReader(new CategoryReaderTxt());
            this.categories = this.performRead();
        }else if (property.equals("excel")){
            this.setCategoryReader(new CategoryReaderExcel());
            this.categories = this.performRead();
        }
    }

    @Override
    public String toString() {
        String res = "";
        for (Category c : categories) {
            res += c.getName() + " | " + c.getDescription() +
                    " | " + c.getSupercategory() + "\n";
        }
        return res;
    }

    public ArrayList<Category> getAll() {
        return new ArrayList<>(categories);
    }

    public ObservableList<Category> getAllObservable() {
        return this.categories;
    }

    public void addCategory(String name, String desc, String superr) {
        if (superr.equals("Geen")) {
            categories.add(new Category(name, desc));
        } else {
            categories.add(new Category(name, desc, superr));
        }
        this.updateFile();
    }

    public void replace(Category ogCategory, Category newCategory){
        int i = this.categories.indexOf(ogCategory);
        this.categories.set(i, newCategory);
    }

    public void updateFile(){
        this.performWrite(this.categories);
    }


}
