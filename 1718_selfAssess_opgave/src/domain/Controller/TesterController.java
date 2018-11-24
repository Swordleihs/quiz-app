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
}
