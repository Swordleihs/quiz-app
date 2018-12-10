package domain.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Test {

    private ArrayList<Question> questions;
    private Question currentQuestion;
    private ArrayList<Question> asked;
    private String feedback;
    private int points, totalPoints;

    public Test(ArrayList<Question> q) {
        this.questions = q;
        this.asked = new ArrayList<>();
        this.points = 0;
        this.totalPoints = 0;
        this.feedback = "";
    }

    public boolean checkAnswer(String answer) {
        if (!this.currentQuestion.checkAnswer(answer)) {
            System.out.println(this.currentQuestion.getFeedback());
            this.feedback += this.currentQuestion.getFeedback() + "\n";
        } else {
            this.points += this.currentQuestion.getPoints();
        }
        this.totalPoints += this.currentQuestion.getPoints();
        return this.currentQuestion.checkAnswer(answer);
    }

    public boolean nextQuestion() {
        if (this.questions.isEmpty()) {
            return false;
        } else {
            int size = this.questions.size();

            Random rand = new Random();
            int n = rand.nextInt(size) + 1;

            this.currentQuestion = this.questions.get(n - 1);
            asked.add(this.currentQuestion);
            this.questions.remove(n - 1);

            String[] statements = this.currentQuestion.getStatements();
            String[] randomizedStatements = new String[statements.length];
            ArrayList<String> statementsArrayList = new ArrayList<>(Arrays.asList(statements));

            int i = 0;
            while (statementsArrayList.size() > 0) {
                int size2 = statementsArrayList.size();
                Random rand2 = new Random();
                int m = rand2.nextInt(size2) + 1;
                randomizedStatements[i] = statementsArrayList.get(m - 1);
                statementsArrayList.remove(m - 1);
                i++;
            }

            this.currentQuestion.setStatements(randomizedStatements);
            return true;
        }
    }

    public Question getQuestion() {
        return this.currentQuestion;
    }

    public int getPoints() {
        return this.points;
    }

    public int getTotalPoints() {
        return this.totalPoints;
    }

    public String getFeedback() {
        if (this.feedback == null || this.feedback.isEmpty()) {
            return "Proficiat alles juist!!!!";
        } else {
            return this.feedback;
        }
    }
}
