package domain.Controller;

import domain.model.Question;
import domain.model.Test;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.panels.MessagePane;
import view.panels.TestPane;

import java.util.ArrayList;

public class TestController {

    private DBController db;
    private ArrayList<Question> questions;
    private Test test;
    private Stage s;



    public TestController(DBController db){
        this.db = db;
    }

    public void startTest(Stage s){
        this.questions = this.db.getQuestions();
        this.s = s;
        this.test = new Test(this.questions);
        System.out.println("Test started");
            Question q = this.nextQuestion();
            TestPane testPane = new TestPane(q, this);

            Group root = new Group();
            Scene scene = new Scene(root, 750, 400);

            root.getChildren().add(testPane);
            this.s.setScene(scene);
            this.s.sizeToScene();
            this.s.show();
    }

    public Question nextQuestion(){
        boolean exists = this.test.nextQuestion();
        if(exists){
            System.out.println("Getting next question...");
            return this.test.getQuestion();
        }else{
            System.out.println("All questions asked");
            return null;
        }
    }

    public void answerGiven(String answer){
        System.out.println(test.checkAnswer(answer));
        if(test.checkAnswer(answer)){
            this.test.addPoints(this.test.getQuestion().getPoints());
        }
        Question question = this.nextQuestion();
        if (question == null){
            this.finishTest();
        }else{
            TestPane testPane = new TestPane(question, this);

            Group root = new Group();
            Scene scene = new Scene(root, 750, 400);

            root.getChildren().add(testPane);
            this.s.setScene(scene);
            this.s.sizeToScene();
            this.s.show();
        }
    }

    public void finishTest(){
        System.out.println(this.test.getPoints());
        MessagePane m = new MessagePane(this, this.s);

        Group root = new Group();
        Scene scene = new Scene(root, 750, 400);

        root.getChildren().add(m);
        this.s.setScene(scene);
        this.s.sizeToScene();
        this.s.show();
    }

}
