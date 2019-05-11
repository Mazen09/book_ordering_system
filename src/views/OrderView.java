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
        this.setPrefWidth(440);
        this.setPrefHeight(40);
        //this.setLayoutY(0);
        this.getChildren().addAll(ISBNLabel, IDLabel, quantityLabel, dateLabel,confirmBtn);
        this.setBackground(new Background(new BackgroundFill(new Color(
                1,1,0.9,1), CornerRadii.EMPTY, Insets.EMPTY)));

        ISBNLabel.setLayoutX(45);
        ISBNLabel.setLayoutY(8);


        IDLabel.setLayoutX(10);
        IDLabel.setLayoutY(8);

        dateLabel.setLayoutX(170);
        dateLabel.setLayoutY(8);

        quantityLabel.setLayoutX(290);
        quantityLabel.setLayoutY(8);

        confirmBtn.setLayoutX(370);
        confirmBtn.setLayoutY(5);


    }
    public void setISBNLabel(String ISBNStr){
        ISBNLabel.setText("ISBN: "+ISBNStr);
    }

    public void setIDLabel(String idStr) {
        IDLabel.setText("ID: "+ idStr);
    }

    public void setDateLabel(String dateStr) {
        dateLabel.setText("Date: "+dateStr);
    }

    public void setQuantityLabel(String quantityStr) {
        quantityLabel.setText("Quantity: "+quantityStr);
    }

}
