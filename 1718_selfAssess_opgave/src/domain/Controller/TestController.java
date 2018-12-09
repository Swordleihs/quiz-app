package domain.Controller;

import domain.model.Question;
import domain.model.Test;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import view.panels.MessagePane;
import view.panels.TestPane;

import java.util.ArrayList;

public class TestController {

    private DBController db;
    private ArrayList<Question> questions;
    private Test test;
    private Stage stage;

    public TestController(DBController db){
        this.db = db;
    }

    public void startTest(Stage s){
        this.questions = this.db.getQuestions();
        this.stage = s;
        this.test = new Test(this.questions);
        System.out.println("Test started");
            Question q = this.nextQuestion();
            TestPane testPane = new TestPane(q, this);

            Group root = new Group();
            Scene scene = new Scene(root, 750, 400);

            root.getChildren().add(testPane);
            this.stage.setScene(scene);
            this.stage.sizeToScene();
            this.stage.show();
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
        Question question = this.nextQuestion();
        if (question == null){
            this.finishTest();
        }else{
            TestPane testPane = new TestPane(question, this);

            Group root = new Group();
            Scene scene = new Scene(root, 750, 400);

            root.getChildren().add(testPane);
            this.stage.setScene(scene);
            this.stage.sizeToScene();
            this.stage.show();
        }
    }

    public void finishTest(){

        Label score = new Label("Score: " + this.test.getPoints() + "/" + this.test.getTotalPoints());
        Label feedback = new Label(this.test.getFeedback());
        MessagePane m = new MessagePane(this, this.stage);

        m.add(feedback, 0,0, 1,1);
        m.add(score, 0,2, 1,1);
        Group root = new Group();
        Scene scene = new Scene(root, 750, 400);

        root.getChildren().add(m);
        this.stage.setScene(scene);
        this.stage.sizeToScene();
        this.stage.show();

    }

}
