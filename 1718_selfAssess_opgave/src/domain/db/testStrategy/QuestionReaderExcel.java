package domain.db.testStrategy;

import domain.Exceptions.dbException;
import domain.model.Question;
import javafx.collections.ObservableList;
import java.io.File;

public class QuestionReaderExcel implements QuestionReader {

    @Override
    public File getFile() {
        File file = new File("Questions.xlsx");
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
    }

    @Override
    public ObservableList<Question> read() {
        /* missing implementation: bro wie weet er nu hoe ge fokking excel file leest, sowieso windows excel lezer dlc nodig voor €39,99 */
        return null;
    }
}
