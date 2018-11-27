package view.panels;

import domain.Controller.dbController;
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


public class CategoryOverviewPane extends GridPane {
	private TableView table;
	private Button btnNew;
	private dbController t;

	public CategoryOverviewPane(dbController t) {
		this.t = t;
		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
        
		this.add(new Label("Categories:"), 0, 1, 1, 1);
		
		table = new TableView<>();
		table.setPrefWidth(REMAINING);
        TableColumn nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));
        table.getColumns().add(nameCol);
        TableColumn descriptionCol = new TableColumn<>("Description");
        descriptionCol.setCellValueFactory(new PropertyValueFactory("description"));
        table.getColumns().add(descriptionCol);
		TableColumn superCol = new TableColumn<>("Supercategory");
		superCol.setCellValueFactory(new PropertyValueFactory("supercategory"));
		table.getColumns().add(superCol);
		this.add(table, 0, 2, 2, 6);
		table.setItems(t.getCategoriesObservable());

		btnNew = new Button("New");
		btnNew.setOnAction(e -> {
			CategoryDetailPane addCatPane = new CategoryDetailPane(t);
            Stage addCatStage = new Stage();

            Group root = new Group();
            Scene scene = new Scene(root, 300, 200);

            root.getChildren().add(addCatPane);
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
