package view.panels;

import domain.Controller.TestController;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MessagePane extends GridPane {
    private Button testButton;
    private TestController testController;

    public MessagePane(TestController testController, Stage stagePrimary, boolean welcomeMessage) {
        this.testController = testController;

        setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        if(this.testController.getDB().getProperty("test.completed").equals("true")) {
            Label testAlreadyDone = new Label("You have already finished this test");
            this.add(testAlreadyDone, 0, 1, 1, 1);
        }

        testButton = new Button("Evaluate");
        testButton.setOnAction((e) -> {
            this.testController.startTest(stagePrimary);
        });
        add(testButton, 0, 2, 1, 1);
        setHalignment(testButton, HPos.CENTER);
    }
}
