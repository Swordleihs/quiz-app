package application;

import domain.Controller.DBController;
import domain.Controller.TestController;
import domain.db.PropertiesDB;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.panels.AssesMainPane;
import view.panels.CategoryOverviewPane;
import view.panels.MessagePane;
import view.panels.QuestionOverviewPane;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        try {

            DBController dbController = new DBController();
            TestController testController = new TestController(dbController);

            QuestionOverviewPane questionOverviewPane = new QuestionOverviewPane(dbController);

            CategoryOverviewPane categoryOverviewPanel = new CategoryOverviewPane(dbController);

            MessagePane messagePane = new MessagePane(testController, primaryStage);

            Group root = new Group();
            Scene scene = new Scene(root, 750, 400);

            BorderPane borderPane = new AssesMainPane(messagePane, categoryOverviewPanel, questionOverviewPane);
            borderPane.prefHeightProperty().bind(scene.heightProperty());
            borderPane.prefWidthProperty().bind(scene.widthProperty());

            root.getChildren().add(borderPane);
            primaryStage.setScene(scene);
            primaryStage.sizeToScene();
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
