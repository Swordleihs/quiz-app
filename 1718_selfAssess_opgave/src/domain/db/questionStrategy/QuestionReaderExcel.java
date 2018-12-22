package domain.db.questionStrategy;

import domain.Exceptions.dbException;
import domain.model.Question;
import javafx.collections.ObservableList;
import java.io.File;
import java.io.InputStream;

public class QuestionReaderExcel implements QuestionReader {

    @Override
    public InputStream getFile() {
        /*File file = new File("Questions.xlsx");
        if (file.isDirectory() || !file.exists()) {
            File file2 = new File("Questions.xls");
            if (file2.isDirectory() || !file2.exists()){
                throw new dbException("txt file not found");
            }
            return file2;
        }
        else{
            return file;
        }
        */
        return null;

    }

    @Override
    public ObservableList<Question> read() {
        /* missing implementation: bro wie weet er nu hoe ge fokking excel file leest, sowieso windows excel lezer dlc nodig voor €39,99 */
        return null;
    }
}
