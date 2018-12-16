package view.panels;

import domain.Controller.DBController;
import domain.model.Category;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EditCategoryDetailPane extends GridPane {
    private Button btnOK, btnCancel;
    private TextField titleField, descriptionField;
    private ComboBox categoryField;
    private DBController dbController;

    public EditCategoryDetailPane(DBController dbController, String title, String description, String mainCat, Category cat){
        this.dbController = dbController;

        this.setPrefHeight(150);
        this.setPrefWidth(300);

        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        this.add(new Label("Title:"), 0, 0, 1, 1);
        titleField = new TextField(title);
        this.add(titleField, 1, 0, 1, 1);

        this.add(new Label("Description:"), 0, 1, 1, 1);
        descriptionField = new TextField(description);
        this.add(descriptionField, 1, 1, 1, 1);

        this.add(new Label("Main Category:"), 0, 2, 1, 1);
        categoryField = new ComboBox<>();
        if(mainCat != null && !mainCat.equals("-")){
            categoryField.getItems().add("Geen");
            for (Category category : dbController.getCategories()) {
                categoryField.getItems().add(category.getName());
            }
            categoryField.setValue(mainCat);
        }else{
            categoryField.getItems().add("Geen");
            for (Category category : dbController.getCategories()) {
                categoryField.getItems().add(category.getName());
            }
            categoryField.setValue("Geen");
        }

        for (Category category : dbController.getCategories()) {
            categoryField.getItems().add(category.getName());
        }

        this.add(categoryField, 1, 2, 1, 1);

        btnCancel = new Button("Cancel");
        btnCancel.setOnAction((e) -> {
            Stage stage = (Stage) this.getScene().getWindow();
            stage.close();
        });
        this.add(btnCancel, 0, 3, 1, 1);

        btnOK = new Button("Save Changes");
        btnOK.isDefaultButton();
        btnOK.setOnAction((e) -> {
            try {
                this.dbController.replaceCategory(cat, new Category(titleField.getText(), descriptionField.getText(), categoryField.getValue().toString()));
                titleField.setText("");
                descriptionField.setText("");
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("ERROR");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            }
            Stage stage = (Stage) this.getScene().getWindow();
            stage.close();
        });
        this.add(btnOK, 1, 3, 1, 1);
    }
}
