package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by first on 5/7/2019.
 */
public class NewAuthorStage extends Stage{
    Label nameLabel, phoneLabel;
    TextField nameField, phoneField;
    Button addBtn;
    Pane rootPane;
    public NewAuthorStage(){
        initialize();
    }
    private void initialize(){
        addBtn = new Button("add");
        nameLabel = new Label("name");
        phoneLabel = new Label("phone");


        nameField = new TextField();
        nameField.setEditable(true);
        nameField.setPrefWidth(100);


        phoneField = new TextField();
        phoneField.setEditable(true);
        phoneField.setPrefWidth(200);


        rootPane = new Pane();

        rootPane.getChildren().addAll(nameLabel,nameField,phoneLabel,phoneField,addBtn);

        nameLabel.setLayoutY(0);
        phoneLabel.setLayoutY(30);


        nameLabel.setLayoutX(0);
        phoneLabel.setLayoutX(0);

        nameField.setLayoutY(0);
        phoneField.setLayoutY(30);

        nameField.setLayoutX(70);
        phoneField.setLayoutX(70);

        addBtn.setLayoutX(100);
        addBtn.setLayoutY(60);


        this.setTitle("New Author");
        this.setScene(new Scene(rootPane, 400, 300));
    }
}
