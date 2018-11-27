package application;

import domain.Controller.TestController;
import domain.Controller.dbController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.panels.AssesMainPane;
import view.panels.CategoryOverviewPane;
import view.panels.MessagePane;
import view.panels.QuestionOverviewPane;
import view.panels.TestPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		try {
			dbController t = new dbController();
			TestController testController = new TestController(t);

			QuestionOverviewPane questionOverviewPane = new QuestionOverviewPane(t);

			CategoryOverviewPane categoryOverviewPanel = new CategoryOverviewPane(t);

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

	public static void main(String[] args) {
		launch(args);
	}
}
