package domain.db.categoryStrategy;

import domain.Exceptions.dbException;
import domain.model.Category;
import javafx.collections.ObservableList;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CategoryWriterTxt implements CategoryWriter{

    @Override
    public void write(ObservableList<Category> categories) {
        try{
            List<String> categoriesList = new ArrayList<>();
            for(Category c : categories){
                String listItem = c.getName() + ";" + c.getDescription();
                if(c.getSupercategory() != null && !c.getSupercategory().trim().isEmpty()){
                    listItem += ";" + c.getSupercategory();
                }
                categoriesList.add(listItem);
            }

            Path file = Paths.get("domain/db/categoryStrategy/Categories.txt");
            Files.write(file, categoriesList, Charset.forName("UTF-8"));
        }catch(Exception e){
            throw new dbException("An error occurred when trying to write to a file.");
        }

    }
}
