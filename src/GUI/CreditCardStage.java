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
        cardNumField.setPrefWidth(200);


        expiryDateField = new TextField();
        expiryDateField.setEditable(true);
        expiryDateField.setPrefWidth(200);


        rootPane = new Pane();

        rootPane.getChildren().addAll(cardNumLabel,cardNumField,expiryDateLabel,expiryDateField,okBtn);

        cardNumLabel.setLayoutY(10);
        expiryDateLabel.setLayoutY(40);


        cardNumLabel.setLayoutX(10);
        expiryDateLabel.setLayoutX(10);

        cardNumField.setLayoutY(10);
        expiryDateField.setLayoutY(40);

        cardNumField.setLayoutX(85);
        expiryDateField.setLayoutX(85);

        okBtn.setLayoutX(120);
        okBtn.setLayoutY(75);
        okBtn.setPrefWidth(50);


        this.setTitle("check out");
        this.setScene(new Scene(rootPane, 300, 110));
        this.initModality(Modality.APPLICATION_MODAL);
    }

}
