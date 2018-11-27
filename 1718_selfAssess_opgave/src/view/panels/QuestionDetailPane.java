package view.panels;

import domain.Controller.dbController;
import domain.model.Category;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.ArrayList;

public class QuestionDetailPane extends GridPane {
	private Button btnOK, btnCancel;
	private TextArea statementsArea;
	private TextField questionField, statementField, feedbackField, pointsField;
	private Button btnAdd, btnRemove;
	private ComboBox categoryField;
	private dbController t;

	public QuestionDetailPane(dbController t) {
		this.t = t;
		this.setPrefHeight(300);
		this.setPrefWidth(320);
		
		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
        
		add(new Label("Question: "), 0, 0, 1, 1);
		questionField = new TextField();
		add(questionField, 1, 0, 2, 1);
		
		add(new Label("Statement: "), 0, 1, 1, 1);
		statementField = new TextField();
		add(statementField, 1, 1, 2, 1);

		add(new Label("Statements: "), 0, 2, 1, 1);
		statementsArea = new TextArea();
		statementsArea.setPrefRowCount(5);
		statementsArea.setEditable(false);
		add(statementsArea, 1, 2, 2, 5);

		Pane addRemove = new HBox();
		btnAdd = new Button("add");
		addRemove.getChildren().add(btnAdd);
		btnAdd.setOnAction((e) -> {
			if(this.statementField.getText().trim().isEmpty()){
				statementField.setText("wel iets ingeve he");
			}else if(this.statementsArea.getText().equals("")){
				this.statementsArea.setText(this.statementField.getText());
				this.statementField.setText("");
			}else{
				this.statementsArea.setText(
						this.statementsArea.getText() + "\n" + this.statementField.getText());
				this.statementField.setText("");
			}

		});

		btnRemove = new Button("Clear");
		btnRemove.setOnAction((e) -> {
			statementsArea.setText("");
		});
		addRemove.getChildren().add(btnRemove);
		add(addRemove, 1, 8, 2, 1);
		add(new Label("Category: "), 0, 9, 1, 1);
		categoryField = new ComboBox();
		add(categoryField, 1, 9, 2, 1);
		for(Category c: t.getCategories()){
			categoryField.getItems().add(c.getName());
		}
		categoryField.setValue("UML");

		add(new Label("Feedback: "), 0, 10, 1, 1);
		feedbackField = new TextField();
		add(feedbackField, 1, 10, 2, 1);

		add(new Label("Points: "), 0, 11, 1, 1);
		pointsField = new TextField();
		add(pointsField, 1, 11, 2, 1);

		btnCancel = new Button("Cancel");
		btnCancel.setText("Cancel");
		btnCancel.setOnAction((e) -> {
			Stage stage = (Stage) this.getScene().getWindow();
			stage.close();
		});
		add(btnCancel, 0, 12, 1, 1);

		btnOK = new Button("Save");
		btnOK.isDefaultButton();
		btnOK.setText("Save");
		btnOK.setOnAction((e) -> {
			try {
				String qu = this.questionField.getText();
				String fe = this.feedbackField.getText();
				String ca = this.categoryField.getValue().toString();
				int po = 0;
				try {
					po = Integer.valueOf(this.pointsField.getText());
				}catch (Exception exx){
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setHeaderText("ERROR");
					alert.setContentText("Gelieve een getal in te geven.");
					alert.showAndWait();
				}
				ArrayList<String> temp = new ArrayList<>();
				for(String s: this.statementsArea.getText().split("\n")){
					temp.add(s);
				}
				String[] st = new String[temp.size()];
				for(int i = 0; i<temp.size(); i++){
					st[i] = temp.get(i);
				}
				this.t.addQuestion(qu,fe,st,ca,po);
				feedbackField.setText("");
				questionField.setText("");
				statementField.setText("");
				statementsArea.setText("");
				pointsField.setText("");
				System.out.println(this.t.toString());
			}catch(Exception ex){
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText("ERROR");
				alert.setContentText(ex.getMessage());
				alert.showAndWait();
			}
		});
		add(btnOK, 1, 12, 2, 1);
		
	}

}
