package views;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * Created by first on 5/8/2019.
 */
public class OrderView extends Pane{


    Label ISBNLabel;
    Label IDLabel;
    Label quantityLabel;
    Label dateLabel;
    public Button confirmBtn;

    public OrderView(){
        initialize();
    }
    private void initialize(){

        ISBNLabel = new Label("ISBN");
        IDLabel = new Label("ID");
        quantityLabel = new Label("quantity");
        dateLabel = new Label("date");
        confirmBtn = new Button("Confirm");



        this.setLayoutX(0);
        //this.setLayoutY(0);
        this.getChildren().addAll(ISBNLabel, IDLabel, quantityLabel, dateLabel,confirmBtn);
        this.setBackground(new Background(new BackgroundFill(new Color(
                1,1,0.9,1), CornerRadii.EMPTY, Insets.EMPTY)));

        ISBNLabel.setLayoutX(0);
        ISBNLabel.setLayoutY(0);


        IDLabel.setLayoutX(0);
        IDLabel.setLayoutY(20);

        dateLabel.setLayoutX(0);
        dateLabel.setLayoutY(40);

        quantityLabel.setLayoutX(0);
        quantityLabel.setLayoutY(60);

        confirmBtn.setLayoutX(0);
        confirmBtn.setLayoutY(80);


    }
    public void setISBNLabel(String titleStr){
        ISBNLabel.setText(titleStr);
    }

    public void setIDLabel(String authorsStr) {
        IDLabel.setText(authorsStr);
    }

    public void setDateLabel(String priceStr) {
        dateLabel.setText(priceStr);
    }

    public void setQuantityLabel(String publisherStr) {
        quantityLabel.setText(publisherStr);
    }

}
