package view.panels;

import domain.Controller.TesterController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class QuestionOverviewPane extends GridPane {
	private TableView table;
	private Button btnNew;
	private TesterController t;
	
	public QuestionOverviewPane(TesterController t) {
		this.t = t;
		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
        
		this.add(new Label("Questions:"), 0, 0, 1, 1);
		
		table = new TableView<>();
		table.setPrefWidth(REMAINING);
        TableColumn nameCol = new TableColumn<>("Question");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("question"));
        table.getColumns().add(nameCol);
        TableColumn descriptionCol = new TableColumn<>("Category");
        descriptionCol.setCellValueFactory(new PropertyValueFactory("category"));
        table.getColumns().add(descriptionCol);
		this.add(table, 0, 1, 2, 6);
		table.setItems(t.getQuestionsObservable());

		btnNew = new Button("New");
		btnNew.setOnAction(e -> {
			QuestionDetailPane addQuestionPane = new QuestionDetailPane(t);
			Stage addCatStage = new Stage();

			Group root = new Group();
			Scene scene = new Scene(root, 350, 325);

			root.getChildren().add(addQuestionPane);
			addCatStage.setScene(scene);
			addCatStage.sizeToScene();
			addCatStage.show();
		});
		this.add(btnNew, 0, 12, 1, 1);
	}
	
	public void setNewAction(EventHandler<ActionEvent> newAction) {
		btnNew.setOnAction(newAction);
	}
	
	public void setEditAction(EventHandler<MouseEvent> editAction) {
		table.setOnMouseClicked(editAction);
	}

}
