package view.panels;

import domain.Controller.TestController;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MessagePane extends GridPane {
    private Button testButton;
    private TestController testController;
    private Stage primaryStage;

    public MessagePane(TestController testController, Stage primaryStage) {
        this.testController = testController;
        this.primaryStage = primaryStage;

        setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        testButton = new Button("Evaluate");
        testButton.setOnAction((e) -> {
            this.testController.startTest(this.primaryStage);
        });
        add(testButton, 0, 1, 1, 1);
        setHalignment(testButton, HPos.CENTER);
    }

}
