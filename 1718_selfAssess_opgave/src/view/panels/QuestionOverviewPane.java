package view.panels;

import domain.Controller.DBController;
import domain.model.Category;
import domain.model.Question;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class QuestionOverviewPane extends GridPane {
    private TableView table;
    private Button btnNew;
    private DBController dbController;

    public QuestionOverviewPane(DBController dbController) {
        this.dbController = dbController;
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
        TableColumn pointsCol = new TableColumn<>("Points");
        pointsCol.setCellValueFactory(new PropertyValueFactory("points"));
        table.getColumns().add(pointsCol);
        this.add(table, 0, 1, 2, 6);
        table.setItems(dbController.getQuestionsObservable());

        table.setRowFactory( tv -> {
            TableRow<Question> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Question question = row.getItem();

                    EditQuestionDetailPane editQuesPane = new EditQuestionDetailPane(dbController, question);
                    Stage addQuesStage = new Stage();

                    Group root = new Group();
                    Scene scene = new Scene(root, 340, 320);

                    root.getChildren().add(editQuesPane);
                    addQuesStage.setScene(scene);
                    addQuesStage.sizeToScene();
                    addQuesStage.show();
                }
            });
            return row ;
        });

        btnNew = new Button("New");
        btnNew.setOnAction(e -> {
            QuestionDetailPane addQuestionPane = new QuestionDetailPane(this.dbController);
            Stage addQuestionStage = new Stage();

            Group root = new Group();
            Scene scene = new Scene(root, 350, 325);

            root.getChildren().add(addQuestionPane);
            addQuestionStage.setScene(scene);
            addQuestionStage.sizeToScene();
            addQuestionStage.show();
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
