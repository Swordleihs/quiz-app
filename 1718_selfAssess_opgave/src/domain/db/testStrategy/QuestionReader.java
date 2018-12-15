package domain.db.testStrategy;

import domain.model.Question;
import javafx.collections.ObservableList;

import java.io.File;

public interface QuestionReader {

    File getFile();

    ObservableList<Question> read();

}
