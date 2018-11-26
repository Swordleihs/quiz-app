package domain.db;

import domain.Exceptions.*;
import domain.model.Question;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionDB {
    private ObservableList<Question> questions;
    private File f;

    public QuestionDB(){
        questions = FXCollections.observableArrayList(new ArrayList<Question>());
        f = new File("Questions.txt");
        if (f.isDirectory() || !f.exists()) {
            throw new dbException("File niet gevonden");
        }
        fill();
    }

    private void fill() {
        try {
            Scanner scan = new Scanner(f, "UTF-8");
            while (scan.hasNextLine()) {
                Scanner line = new Scanner(scan.nextLine());
                line.useDelimiter(";");
                String question = line.next();
                String statementsString = line.next();
                String category = line.next();
                String feedback = line.next();
                String pointsString = line.next();
                String[] statements =
                        statementsString.split(":");
                int points = Integer.valueOf(pointsString);
                Question q =new Question(question, feedback,
                        statements, category, points);
                questions.add(q);
            }
        } catch (Exception e) {
            throw new dbException("Fout bij inlezen bestand");
        }
    }

    @Override
    public String toString(){
        String res = "";
        for(Question q: questions){
            res += "\n=======================" +
                    "\nQuestion: " + q.getQuestion() +
                    "\nPoints: " + q.getPoints() +
                    "\nFeedBack: " + q.getFeedback() +
                    "\nStatements: " + q.printStatements() +
                    "\nCategory: " + q.getCategory();
        }
        return res;
    }

    public ArrayList<Question> getAll(){
        ArrayList<Question> res = new ArrayList<>();
        res.addAll(questions);
        return res;
    }

    public void addQuestion(String qu, String fe, String[] st, String ca, int po){
        questions.add(new Question(qu, fe, st, ca, po));
    }
}
