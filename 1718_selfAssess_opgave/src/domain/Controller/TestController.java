package domain.Controller;

import domain.model.Question;

import java.util.ArrayList;

public class TestController {

    private dbController db;
    private ArrayList<Question> questions;

    public TestController(dbController db){
        this.db = db;
        this.questions = this.db.getQuestions();
    }

    public ArrayList<Question> getQuestions(){
        return this.questions;
    }

}
