package view.panels;

import java.util.ArrayList;
import java.util.List;

import domain.Controller.TestController;
import domain.model.Question;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TestPane extends GridPane {
	private Label questionField;
	private Button submitButton;
	private ToggleGroup statementGroup;

	private Question question;
	private TestController testController;


	public TestPane (Question q, TestController t){
	    this.question = q;
	    this.testController = t;

		this.setPrefHeight(300);
		this.setPrefWidth(750);

		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

		questionField = new Label(this.question.getQuestion());
		add(questionField, 0, 0, 1, 1);

        statementGroup = new ToggleGroup();

        int row = 1;
		for (String s : this.question.getStatements()){
			RadioButton radioButton = radioButton = new RadioButton(s);
		    radioButton.setUserData(s);
		    radioButton.setToggleGroup(statementGroup);
            add(radioButton, 0, row, 1, 1);
            row++;
        }
        submitButton = new Button("Submit");


        submitButton.setOnAction((e) -> {
				this.testController.answerGiven(getSelectedStatement());
		});
        add(submitButton, 0, row,  1, 1);
	}

	public String getSelectedStatement() {
		String selected = null;
		if(statementGroup.getSelectedToggle()!=null){
			selected = statementGroup.getSelectedToggle().getUserData().toString();
		}
		return selected;
	}
}
