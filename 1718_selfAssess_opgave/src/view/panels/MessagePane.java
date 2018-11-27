package view.panels;

import java.util.Observer;

import domain.Controller.TestController;
import domain.Controller.dbController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MessagePane extends GridPane {
	private Button testButton;
	private TestController testController;
	
	public MessagePane (TestController testController, Stage primaryStage){
	    this.testController = testController;

	    setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        testButton = new Button("Evaluate");
        testButton.setOnAction(e -> {
            TestPane testPane = new TestPane(this.testController);


            Group root = new Group();
            Scene scene = new Scene(root, 750, 400);

            root.getChildren().add(testPane);
            primaryStage.setScene(scene);
            primaryStage.sizeToScene();
            primaryStage.show();
        });
        add(testButton, 0,1,1,1);
        setHalignment(testButton, HPos.CENTER);
	}

}
