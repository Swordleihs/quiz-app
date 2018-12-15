package domain.model;

import java.util.*;

public class Test {

    private ArrayList<Question> questions;
    private Question currentQuestion;
    private ArrayList<Question> asked;
    private String feedback;
    private int points, totalPoints;
    private Map<String, int[]> scores;

    public Test(ArrayList<Question> q) {
        this.questions = q;
        this.asked = new ArrayList<>();
        this.points = 0;
        this.totalPoints = 0;
        this.feedback = "";
        this.scores = new HashMap<String, int[]>();
    }

    /* Strategy toevoegen voor punten berekening */

    public boolean checkAnswer(String answer) {
        if (!this.currentQuestion.checkAnswer(answer)) {
            this.feedback += this.currentQuestion.getFeedback() + "\n";
        } else {
            if(!scores.containsKey(currentQuestion.getCategory())){
                int[] temp = {currentQuestion.getPoints(),0};
                scores.put(currentQuestion.getCategory(), temp);
            }else{
                int[] temp = scores.get(currentQuestion.getCategory());
                temp[0] = temp[0] + currentQuestion.getPoints();
                scores.put(currentQuestion.getCategory(), temp);
            }
        }
        if(!scores.containsKey(currentQuestion.getCategory())){
            int[] temp = {0,currentQuestion.getPoints()};
            scores.put(currentQuestion.getCategory(), temp);
        }else{
            int[] temp = scores.get(currentQuestion.getCategory());
            temp[1] = temp[1] + currentQuestion.getPoints();
            scores.put(currentQuestion.getCategory(), temp);
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
    public Map<String, int[]> getScores(){
        return this.scores;
    }
    public int getTotalPoints() {
        return this.totalPoints;
    }

    public String getFeedback() {
        if (this.feedback == null || this.feedback.isEmpty()) {
            return "Congratulations! You answered every question correctly.";
        } else {
            return this.feedback;
        }
    }
}
