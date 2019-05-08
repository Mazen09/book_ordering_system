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
        ISBNField.setPrefWidth(100);


        quantityField = new TextField();
        quantityField.setEditable(true);
        quantityField.setPrefWidth(200);


        rootPane = new Pane();

        rootPane.getChildren().addAll(ISBNLabel,ISBNField,quantityLabel,quantityField,orderBtn);

        ISBNLabel.setLayoutY(0);
        quantityLabel.setLayoutY(30);


        ISBNLabel.setLayoutX(0);
        quantityLabel.setLayoutX(0);

        ISBNField.setLayoutY(0);
        quantityField.setLayoutY(30);

        ISBNField.setLayoutX(70);
        quantityField.setLayoutX(70);

        orderBtn.setLayoutX(100);
        orderBtn.setLayoutY(60);


        this.setTitle("place order");
        this.setScene(new Scene(rootPane, 400, 300));
    }
}
