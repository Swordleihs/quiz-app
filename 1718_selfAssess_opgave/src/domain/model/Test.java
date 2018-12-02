package domain.model;

import java.util.ArrayList;
import java.util.Random;

public class Test {

    private ArrayList<Question> questions;
    private Question currentQuestion;

    public Test(ArrayList<Question> q){
        this.questions = q;
    }

    public boolean nextQuestion(){
        if (this.questions.isEmpty()){
            return false;
        }else{
            int size = this.questions.size();

            Random rand = new Random();
            int n = rand.nextInt(size) + 1;

            this.currentQuestion = this.questions.get(n-1);
            this.questions.remove(n-1);

            String[] statements= this.currentQuestion.getStatements();
            String[] randomizedStatements = new String[statements.length];
            ArrayList<String> statementsArrayList = new ArrayList<>();
            for (String s : statements){
                statementsArrayList.add(s);
            }

            int i = 0;
            while (statementsArrayList.size() > 0){
                int size2 = statementsArrayList.size();

                Random rand2 = new Random();
                int m = rand2.nextInt(size2) + 1;

                randomizedStatements[i] = statementsArrayList.get(m-1);
                statementsArrayList.remove(m-1);

                i++;
            }

            this.currentQuestion.setStatements(randomizedStatements);
            return true;
        }
    }

    public Question getQuestion(){
        return this.currentQuestion;
    }
}
