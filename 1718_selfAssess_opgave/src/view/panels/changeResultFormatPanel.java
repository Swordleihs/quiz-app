package view.panels;

import domain.Controller.DBController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class changeResultFormatPanel extends GridPane {

    public changeResultFormatPanel(DBController dbcontroller){

        setBorder(new Border(new BorderStroke(Color.BLACK,
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        ToggleGroup toggle = new ToggleGroup();
        RadioButton radio1 = new RadioButton("feedback");
        RadioButton radio2 = new RadioButton("score");
        radio1.setUserData("feedback");
        radio1.setToggleGroup(toggle);
        add(radio1, 0, 0, 1, 1);
        radio2.setUserData("score");
        radio2.setToggleGroup(toggle);
        add(radio2, 0, 1, 1, 1);

        if(dbcontroller.getProperty("evaluation.mode").equals("feedback")){
            toggle.selectToggle(radio1);
        }else if(dbcontroller.getProperty("evaluation.mode").equals("score")){
            toggle.selectToggle(radio2);
        }

        Button submit = new Button("Submit");
        submit.setOnAction(e -> {
            if(toggle.getSelectedToggle() != null){
                dbcontroller.setProperty("evaluation.mode",
                        toggle.getSelectedToggle().getUserData().toString());
            }
        });
        add(submit,0 , 2, 1, 1);
    }
}
