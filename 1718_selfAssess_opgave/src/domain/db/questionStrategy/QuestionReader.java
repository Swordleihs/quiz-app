package domain.db.questionStrategy;

import domain.model.Question;
import javafx.collections.ObservableList;

import java.io.File;

public interface QuestionReader {

    File getFile();

    ObservableList<Question> read();

}
