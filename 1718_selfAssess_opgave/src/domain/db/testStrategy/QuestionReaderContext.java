package domain.db.testStrategy;

import domain.model.Question;
import javafx.collections.ObservableList;

public abstract class QuestionReaderContext {

    QuestionReader questionReader;

    public void setQuestionReader(QuestionReader questionReader){
        this.questionReader = questionReader;
    }

    public ObservableList<Question> performRead(){
        return this.questionReader.read();
    }
}
