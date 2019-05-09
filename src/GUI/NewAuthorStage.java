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
import javafx.stage.Modality;
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
        nameField.setPrefWidth(200);


        phoneField = new TextField();
        phoneField.setEditable(true);
        phoneField.setPrefWidth(200);


        rootPane = new Pane();

        rootPane.getChildren().addAll(nameLabel,nameField,phoneLabel,phoneField,addBtn);

        nameLabel.setLayoutY(10);
        phoneLabel.setLayoutY(40);


        nameLabel.setLayoutX(10);
        phoneLabel.setLayoutX(10);

        nameField.setLayoutY(10);
        phoneField.setLayoutY(40);

        nameField.setLayoutX(60);
        phoneField.setLayoutX(60);

        addBtn.setLayoutX(120);
        addBtn.setLayoutY(75);
        addBtn.setPrefWidth(50);


        this.setTitle("New Author");
        this.setScene(new Scene(rootPane, 280, 110));
        this.initModality(Modality.APPLICATION_MODAL);
    }
}
