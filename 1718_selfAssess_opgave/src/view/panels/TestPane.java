package view.panels;

import java.util.ArrayList;
import java.util.List;

import domain.Controller.TestController;
import domain.model.Question;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class TestPane extends GridPane {
	private Label questionField;
	private Button submitButton;
	private ToggleGroup statementGroup;

	private TestController testController;

	
	public TestPane (TestController testController){
	    this.testController = testController;

	    ArrayList<Question> questions = testController.getQuestions();

		this.setPrefHeight(300);
		this.setPrefWidth(750);
		
		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

		questionField = new Label(questions.get(0).getQuestion());
		add(questionField, 0, 0, 1, 1);

        statementGroup = new ToggleGroup();

        int row = 1;
		for (String s : questions.get(0).getStatements()){
		    RadioButton radioButton = new RadioButton(s);
		    radioButton.setToggleGroup(statementGroup);
            add(radioButton, 0, row, 1, 1);
            row++;
        }

		submitButton = new Button("Submit");
        add(submitButton, 0, row,  1, 1);
	}
	
	public void setProcessAnswerAction(EventHandler<ActionEvent> processAnswerAction) {
		submitButton.setOnAction(processAnswerAction);
	}

	public List<String> getSelectedStatements() {
		 List<String> selected = new ArrayList<String>();
		if(statementGroup.getSelectedToggle()!=null){
			selected.add(statementGroup.getSelectedToggle().getUserData().toString());
		}
		return selected;
	}
}
