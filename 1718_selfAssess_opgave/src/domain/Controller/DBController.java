package domain.Controller;

import domain.Exceptions.DomainException;
import domain.db.categoryStrategy.CategoryDB;
import domain.db.LastTestDB;
import domain.db.PropertiesDB;
import domain.db.questionStrategy.QuestionDB;
import domain.model.Category;
import domain.model.Question;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class DBController {
    private CategoryDB categorydb;
    private QuestionDB questiondb;
    private PropertiesDB propertiesDB;
    private LastTestDB lastTestdb;

    public DBController() {
        propertiesDB = new PropertiesDB();
        categorydb = new CategoryDB(this.getProperty("test.mode"));
        questiondb = new QuestionDB(this.getProperty("test.mode"));
        lastTestdb = new LastTestDB();
    }

    @Override
    public String toString() {
        String res = "";
        res += categorydb.toString() + "\n\n" +
                questiondb.toString();
        return res;
    }
    public String getProperty(String name){
        return propertiesDB.getProperties().getProperty(name);
    }
    public void setProperty(String name, String value){
        propertiesDB.getProperties().setProperty(name, value);
        this.writeProperties();
    }
    private void writeProperties(){
        this.propertiesDB.write();
    }
    public ObservableList<Category> getCategoriesObservable() {
        return categorydb.getAllObservable();
    }

    public ObservableList<Question> getQuestionsObservable() {
        return questiondb.getAllObservable();
    }

    public void addCategory(String name, String description, String superr) {
        categorydb.addCategory(name, description, superr);
    }

    public void updateCategory(Category ogCategory, Category newCategory){
        this.categorydb.replace(ogCategory, newCategory);
        this.categorydb.updateFile();
    }

    public void addQuestion(String qu, String fe, String[] st, String ca, int po) {
        questiondb.addQuestion(qu, fe, st, ca, po);
    }

    public void updateQuestion(Question ogQuestion, Question newQuestion){
        this.questiondb.replace(ogQuestion, newQuestion);
        this.questiondb.updateFile();
    }

    public ArrayList<Category> getCategories() {
        return categorydb.getAll();
    }

    public Category getCategory(String name) {
        Category c = null;
        for (Category cc : categorydb.getAll()) {
            if (cc.getName().equals(name)) {
                c = cc;
            }
        }
        if (c == null) {
            throw new DomainException("Deze categorie bestaat niet");
        } else {
            return c;
        }
    }
    public ArrayList<Question> getQuestions() {
        return questiondb.getAll();
    }
    public void writeLastTest(String s){
        this.lastTestdb.write(s);
    }
    public String readLastTest(){
        return this.lastTestdb.read();
    }
}
