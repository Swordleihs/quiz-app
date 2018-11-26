package view.panels;

import domain.Controller.TesterController;
import domain.model.Category;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CategoryDetailPane extends GridPane {
	private Button btnOK, btnCancel;
	private TextField titleField, descriptionField;
	private ComboBox categoryField;
	private TesterController t;

	public CategoryDetailPane(TesterController t) {
		this.t = t;
		this.setPrefHeight(150);
		this.setPrefWidth(300);
		
		this.setPadding(new Insets(5, 5, 5, 5));
		this.setVgap(5);
		this.setHgap(5);

		this.add(new Label("Title:"), 0, 0, 1, 1);
		titleField = new TextField();
		this.add(titleField, 1, 0, 1, 1);

		this.add(new Label("Description:"), 0, 1, 1, 1);
		descriptionField = new TextField();
		this.add(descriptionField, 1, 1, 1, 1);

		this.add(new Label("Main Category:"), 0, 2, 1, 1);
		categoryField = new ComboBox<>();
		categoryField.getItems().add("Geen");
		for(Category c: t.getCategories()){
			categoryField.getItems().add(c.getName());
		}
		categoryField.setValue("Geen");
		this.add(categoryField, 1, 2, 1, 1);

		btnCancel = new Button("Cancel");
		btnCancel.setOnAction((e) -> {
			Stage stage = (Stage) this.getScene().getWindow();
			stage.close();
		});
		this.add(btnCancel, 0, 3, 1, 1);

		btnOK = new Button("Save");
		btnOK.isDefaultButton();
		btnOK.setOnAction((e) -> {
			try {
				this.t.addCategory(titleField.getText(), descriptionField.getText(), categoryField.getValue().toString());
				titleField.setText("");
				descriptionField.setText("");
				System.out.println(this.t.toString());
			}catch(Exception ex){
				ex.printStackTrace();
			}
		});
		this.add(btnOK, 1, 3, 1, 1);
	}

	public void setSaveAction(EventHandler<ActionEvent> saveAction) {
		btnOK.setOnAction(saveAction);
	}

	public void setCancelAction(EventHandler<ActionEvent> cancelAction) {
		btnCancel.setOnAction(cancelAction);
	}

}
