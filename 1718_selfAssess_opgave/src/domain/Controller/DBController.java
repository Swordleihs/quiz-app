package domain.Controller;

import domain.Exceptions.DomainException;
import domain.db.CategoryDB;
import domain.db.QuestionDB;
import domain.model.Category;
import domain.model.Question;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class DBController {
    private CategoryDB categorydb;
    private QuestionDB questiondb;

    public DBController(){
        categorydb = new CategoryDB();
        questiondb = new QuestionDB();
    }

    @Override
    public String toString(){
        String res = "";
        res += categorydb.toString() + "\n\n"+
                questiondb.toString();
        return res;
    }

    public ObservableList<Category> getCategoriesObservable(){
        return categorydb.getAllObservable();
    }
    public ObservableList<Question> getQuestionsObservable(){
        return questiondb.getAllObservable();
    }

    public void addCategory(String name, String description, String superr){
        categorydb.addCategory(name, description, superr);
    }

    public void addQuestion(String qu, String fe, String[] st, String ca, int po){
        questiondb.addQuestion(qu, fe, st, ca, po);
    }

    public ArrayList<Category> getCategories(){
        return categorydb.getAll();
    }
    public Category getCategory(String name){
        Category c = null;
        for(Category cc: categorydb.getAll()){
            if(cc.getName().equals(name)){
                c = cc;
            }
        }
        if(c == null){
            throw new DomainException("Deze categorie bestaat niet");
        }else{
            return c;
        }
    }

    public ArrayList<Question> getQuestions(){
        return questiondb.getAll();
    }
}
