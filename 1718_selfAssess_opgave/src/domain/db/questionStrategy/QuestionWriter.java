package domain.db.questionStrategy;

import domain.model.Question;
import javafx.collections.ObservableList;

public interface QuestionWriter {

    void write(ObservableList<Question> questions);
}
