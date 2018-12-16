package domain.db.questionStrategy;

import domain.Exceptions.dbException;
import domain.model.Question;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionReaderTxt implements QuestionReader{


    @Override
    public File getFile() {
        File file = new File("Questions.txt");
        if (file.isDirectory() || !file.exists()) {
            throw new dbException("txt file not found.");
        }
        return file;
    }

    @Override
    public ObservableList<Question> read() {
        ObservableList<Question> questions = FXCollections.observableArrayList(new ArrayList<>());
        File file = this.getFile();

        try {
            Scanner scan = new Scanner(file, "UTF-8");
            while (scan.hasNextLine()) {
                Scanner line = new Scanner(scan.nextLine());
                line.useDelimiter(";");
                String question = line.next();
                String statementsString = line.next();
                String category = line.next();
                String feedback = line.next();
                String pointsString = line.next();
                String[] statements = statementsString.split(":");
                int points = Integer.valueOf(pointsString);
                Question q = new Question(question, feedback, statements, category, points);
                questions.add(q);
            }
        } catch (Exception e) {
            throw new dbException("An error occurred when trying to read the file.");
        }

        return questions;
    }
}
