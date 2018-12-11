package domain.Controller;

import domain.model.Question;
import domain.model.Test;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.panels.*;

import java.util.ArrayList;

public class TestController {

    private DBController db;
    private ArrayList<Question> questions;
    private Test test;
    private Stage stage, primaryStage;

    public TestController(DBController db) {
        this.db = db;
    }

    public void startTest(Stage s) {
        this.primaryStage = s;

        this.questions = this.db.getQuestions();
        this.test = new Test(this.questions);
        System.out.println("Test started");
        Question q = this.nextQuestion();

        TestPane testPane = new TestPane(q, this);
        Group root = new Group();
        Scene scene = new Scene(root, 750, 400);

        this.stage = new Stage();

        root.getChildren().add(testPane);
        this.stage.setScene(scene);
        this.stage.sizeToScene();
        this.stage.show();
    }

    public Question nextQuestion() {
        boolean exists = this.test.nextQuestion();
        if (exists) {
            System.out.println("Getting next question...");
            return this.test.getQuestion();
        } else {
            System.out.println("All questions asked");
            return null;
        }
    }

    public void answerGiven(String answer) {
        test.checkAnswer(answer);
        Question question = this.nextQuestion();
        if (question == null) {
            this.finishTest();
        } else {
            TestPane testPane = new TestPane(question, this);

            Group root = new Group();
            Scene scene = new Scene(root, 750, 400);

            root.getChildren().add(testPane);
            this.stage.setScene(scene);
            this.stage.sizeToScene();
            this.stage.show();
        }
    }

    public void finishTest() {

        Label score = new Label("Score: " + this.test.getPoints() + "/" + this.test.getTotalPoints());
        Label feedback = new Label(this.test.getFeedback());

        this.stage.close();

        QuestionOverviewPane questionOverviewPane = new QuestionOverviewPane(this.db);
        CategoryOverviewPane categoryOverviewPane = new CategoryOverviewPane(this.db);
        MessagePane m = new MessagePane(this, this.primaryStage);
        m.add(feedback, 0, 0, 1, 1);
        m.add(score, 0, 2, 1, 1);

        Group root = new Group();
        Scene scene = new Scene(root, 750, 400);

        BorderPane borderPane = new AssesMainPane(m, categoryOverviewPane, questionOverviewPane);
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());

        root.getChildren().add(borderPane);

        this.primaryStage.setScene(scene);
        this.primaryStage.sizeToScene();
        this.primaryStage.show();

    }

}