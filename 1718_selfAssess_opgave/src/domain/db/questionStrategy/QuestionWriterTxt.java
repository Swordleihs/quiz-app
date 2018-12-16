package domain.db.questionStrategy;

import domain.Exceptions.dbException;
import domain.model.Question;
import javafx.collections.ObservableList;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class QuestionWriterTxt implements QuestionWriter {

    @Override
    public void write(ObservableList<Question> questions) {
        try{
            List<String> questionsList = new ArrayList<>();
            for(Question q : questions){
                String listItem = q.getQuestion()+";";
                for(String s : q.getStatements()){
                    listItem += s + ":";
                }
                listItem = listItem.substring(0, listItem.length()-1);
                listItem += ";" + q.getCategory() + ";" + q.getFeedback() + ";" + q.getPoints();
                questionsList.add(listItem);
            }

            Path file = Paths.get("Questions.txt");
            Files.write(file, questionsList, Charset.forName("UTF-8"));
        }catch(Exception e){
            throw new dbException("An error occurred when trying to write to a file.");
        }

    }
}
