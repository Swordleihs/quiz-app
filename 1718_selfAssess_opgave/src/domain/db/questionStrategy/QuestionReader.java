package domain.db.questionStrategy;

import domain.model.Question;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.InputStream;

public interface QuestionReader {

    InputStream getFile();

    ObservableList<Question> read();

}
