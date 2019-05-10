package GUI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
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
        nameField.setPrefWidth(200);


        phoneField = new TextField();
        phoneField.setEditable(true);
        phoneField.setPrefWidth(200);

        addressField = new TextField();
        addressField.setEditable(true);
        addressField.setPrefWidth(200);

        rootPane = new Pane();

        rootPane.getChildren().addAll(nameLabel,nameField,phoneLabel,phoneField,addBtn,addressField,addressLabel);

        nameLabel.setLayoutY(10);
        phoneLabel.setLayoutY(40);
        addressLabel.setLayoutY(70);

        nameLabel.setLayoutX(10);
        phoneLabel.setLayoutX(10);
        addressLabel.setLayoutX(10);

        nameField.setLayoutY(10);
        phoneField.setLayoutY(40);
        addressField.setLayoutY(70);

        nameField.setLayoutX(80);
        phoneField.setLayoutX(80);
        addressField.setLayoutX(80);

        addBtn.setLayoutX(120);
        addBtn.setLayoutY(105);
        addBtn.setPrefWidth(50);


        this.setTitle("New Publisher");
        this.setScene(new Scene(rootPane, 300, 140));
        this.initModality(Modality.APPLICATION_MODAL);
    }
}
