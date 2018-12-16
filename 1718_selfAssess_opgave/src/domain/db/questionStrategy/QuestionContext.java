package domain.db.questionStrategy;

import domain.model.Question;
import javafx.collections.ObservableList;

public abstract class QuestionContext {

    QuestionReader questionReader;
    QuestionWriter questionWriter;

    public void setQuestionReader(QuestionReader questionReader){
        this.questionReader = questionReader;
    }

    public ObservableList<Question> performRead(){
        return this.questionReader.read();
    }

    public void setQuestionWriter(QuestionWriter questionWriter){
        this.questionWriter = questionWriter;
    }

    public void performWrite(ObservableList<Question> questions){
        this.questionWriter.write(questions);
    }
}
