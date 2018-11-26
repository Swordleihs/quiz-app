package domain.Controller;

import domain.Exceptions.DomainException;
import domain.db.CategoryDB;
import domain.db.QuestionDB;
import domain.model.Category;

public class TesterController {
    private CategoryDB categorydb;
    private QuestionDB questiondb;

    public TesterController(){
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

    public void addCategory(String name, String description, String superr){
        categorydb.addCategory(name, description, superr);
    }
    public void addCategory(String name, String description){
        categorydb.addCategory(name, description);
    }

    public void addQuestion(String qu, String fe, String[] st, String ca, int po){
        questiondb.addQuestion(qu, fe, st, ca, po);
    }
}
