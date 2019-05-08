package GUI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by first on 5/7/2019.
 */
public class NewPublisherStage extends Stage{
    Label nameLabel, phoneLabel, addressLabel;
    TextField nameField, phoneField, addressField;
    Button addBtn;
    Pane rootPane;
    public NewPublisherStage(){
        initialize();
    }
    private void initialize(){
        addBtn = new Button("add");
        nameLabel = new Label("name");
        phoneLabel = new Label("phone");
        addressLabel = new Label("address");


        nameField = new TextField();
        nameField.setEditable(true);
        nameField.setPrefWidth(100);


        phoneField = new TextField();
        phoneField.setEditable(true);
        phoneField.setPrefWidth(200);

        addressField = new TextField();
        addressField.setEditable(true);
        addressField.setPrefWidth(200);

        rootPane = new Pane();

        rootPane.getChildren().addAll(nameLabel,nameField,phoneLabel,phoneField,addBtn,addressField,addressLabel);

        nameLabel.setLayoutY(0);
        phoneLabel.setLayoutY(30);
        addressLabel.setLayoutY(60);

        nameLabel.setLayoutX(0);
        phoneLabel.setLayoutX(0);
        addressLabel.setLayoutX(0);

        nameField.setLayoutY(0);
        phoneField.setLayoutY(30);
        addressField.setLayoutY(60);

        nameField.setLayoutX(70);
        phoneField.setLayoutX(70);
        addressField.setLayoutX(70);

        addBtn.setLayoutX(100);
        addBtn.setLayoutY(90);


        this.setTitle("New Publisher");
        this.setScene(new Scene(rootPane, 400, 300));
    }
}
