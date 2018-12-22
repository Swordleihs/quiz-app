package domain.db.questionStrategy;

import domain.Exceptions.DomainException;
import domain.Exceptions.dbException;
import domain.model.Question;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionReaderTxt implements QuestionReader{


    @Override
    public InputStream getFile() {
        InputStream file = getClass().getClassLoader().getResourceAsStream(
                "domain/db/questionStrategy/Questions.txt");
        if (file == null){
            throw new DomainException("foutje bij het lezen van file");
        }
        return file;
    }

    @Override
    public ObservableList<Question> read() {
        ObservableList<Question> questions = FXCollections.observableArrayList(new ArrayList<>());
        InputStream file = this.getFile();

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
