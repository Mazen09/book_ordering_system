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
public class PlaceOrderStage extends Stage {
    Label ISBNLabel, quantityLabel;
    TextField ISBNField, quantityField;
    Button orderBtn;
    Pane rootPane;
    public PlaceOrderStage(){
        initialize();
    }
    private void initialize(){
        orderBtn = new Button("order");
        ISBNLabel = new Label("ISBN");
        quantityLabel = new Label("quantity");


        ISBNField = new TextField();
        ISBNField.setEditable(true);
        ISBNField.setPrefWidth(200);


        quantityField = new TextField();
        quantityField.setEditable(true);
        quantityField.setPrefWidth(200);


        rootPane = new Pane();

        rootPane.getChildren().addAll(ISBNLabel,ISBNField,quantityLabel,quantityField,orderBtn);

        ISBNLabel.setLayoutY(10);
        quantityLabel.setLayoutY(40);


        ISBNLabel.setLayoutX(10);
        quantityLabel.setLayoutX(10);

        ISBNField.setLayoutY(10);
        quantityField.setLayoutY(40);

        ISBNField.setLayoutX(70);
        quantityField.setLayoutX(70);

        orderBtn.setLayoutX(120);
        orderBtn.setLayoutY(75);



        this.setTitle("place order");
        this.setScene(new Scene(rootPane, 280, 110));
        this.initModality(Modality.APPLICATION_MODAL);
    }
}
