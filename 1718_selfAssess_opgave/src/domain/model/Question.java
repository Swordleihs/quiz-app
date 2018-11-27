package domain.model;

import domain.Exceptions.DomainException;

public class Question {
    private String question, feedback;
    private String[] statements;
    private String category;
    private int points;

    public Question(String qu, String fe, String[] st, String ca, int po){
        setCategory(ca);
        setFeedback(fe);
        setQuestion(qu);
        setStatements(st);
        setPoints(po);
    }

    public String printStatements(){
        String res = "[";
        for(String q: statements){
            res += q + ";";
        }
        res += "]";
        return res;
    }




    //=========================================
    //========== GETTERS AND SETTERS ==========
    //=========================================
    public String getQuestion() {
        return question;
    }
    private void setQuestion(String question) {
        if(question == null || question.trim().isEmpty()){
            throw new DomainException("De vraag van de vraag is niet in orde!");
        }
        this.question = question;
    }

    public String getFeedback() {
        return feedback;
    }
    private void setFeedback(String feedback) {
        if(feedback == null || feedback.trim().isEmpty()){
            throw new DomainException("de feedback van de vraag is niet in orde!");
        }
        this.feedback = feedback;
    }


    public String[] getStatements() {
        return statements;
    }
    public void setStatements(String[] statements) {
        if(statements == null || statements.length < 2){
            throw new DomainException("De statements van de vraag zijn niet in orde, zorg voor minstens 2 antwoorden!");
        }
        this.statements = statements;
    }

    public String getCategory() {
        return category;
    }
    private void setCategory(String category) {
        if(category == null || category.trim().isEmpty()){
            throw new DomainException("De categorie van de vraag is niet in orde!");
        }
        this.category = category;
    }

    public int getPoints() {
        return points;
    }
    private void setPoints(int points) {
        if(points <= 0){
            throw new DomainException("De punten van de vraag zijn niet in orde, minimum 1!");
        }
        this.points = points;
    }
}
