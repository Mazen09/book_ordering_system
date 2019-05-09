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
public class CreditCardStage extends Stage {
    Label cardNumLabel, expiryDateLabel;
    TextField cardNumField, expiryDateField;
    Button okBtn;
    Pane rootPane;
    public CreditCardStage(){
        initialize();
    }
    private void initialize(){
        okBtn = new Button("ok");
        cardNumLabel = new Label("card Number");
        expiryDateLabel = new Label("expiry date");


        cardNumField = new TextField();
        cardNumField.setEditable(true);
        cardNumField.setPrefWidth(100);


        expiryDateField = new TextField();
        expiryDateField.setEditable(true);
        expiryDateField.setPrefWidth(200);


        rootPane = new Pane();

        rootPane.getChildren().addAll(cardNumLabel,cardNumField,expiryDateLabel,expiryDateField,okBtn);

        cardNumLabel.setLayoutY(0);
        expiryDateLabel.setLayoutY(30);


        cardNumLabel.setLayoutX(0);
        expiryDateLabel.setLayoutX(0);

        cardNumField.setLayoutY(0);
        expiryDateField.setLayoutY(30);

        cardNumField.setLayoutX(70);
        expiryDateField.setLayoutX(70);

        okBtn.setLayoutX(100);
        okBtn.setLayoutY(60);


        this.setTitle("check out");
        this.setScene(new Scene(rootPane, 400, 300));
    }

}
