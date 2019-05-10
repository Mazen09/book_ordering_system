package views;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Created by first on 5/7/2019.
 */
public class CartBookView extends BookView{
    public Button removeBtn;
    public Button increaseBtn;
    public Button decreaseBtn;
    Label totalPriceLabel;
    Label quantityLabel;
    Label totalPriceTextLabel;
    Label quantityTextLabel;
    public CartBookView(){
        initialize();
    }
    private void initialize(){


        removeBtn = new Button("remove");
        increaseBtn = new Button("increase");
        decreaseBtn = new Button("decrease");


        removeBtn.setPrefWidth(65);
        removeBtn.setLayoutY(5);
        removeBtn.setLayoutX(300);


        increaseBtn.setPrefWidth(65);
        increaseBtn.setLayoutY(35);
        increaseBtn.setLayoutX(300);


        decreaseBtn.setPrefWidth(65);
        decreaseBtn.setLayoutY(65);
        decreaseBtn.setLayoutX(300);



        quantityLabel = new Label("Quantity");
        totalPriceLabel = new Label("Total Price");
        quantityTextLabel = new Label("Quantity:");
        totalPriceTextLabel = new Label("Total:");

        quantityTextLabel.setLayoutX(10);
        totalPriceTextLabel.setLayoutX(200);

        quantityTextLabel.setLayoutY(85);
        totalPriceTextLabel.setLayoutY(85);

        quantityLabel.setLayoutX(70);
        totalPriceLabel.setLayoutX(230);

        quantityLabel.setLayoutY(85);
        totalPriceLabel.setLayoutY(85);

        this.setLayoutX(5);
        this.setPrefWidth(370);
        this.setPrefHeight(105);
        //this.setLayoutY(0);
        //this.getChildren().addAll(removeBtn, increaseBtn, decreaseBtn, quantityLabel, totalPriceLabel);
        this.getChildren().add(removeBtn);
        this.getChildren().add(increaseBtn);
        this.getChildren().add(decreaseBtn);
        this.getChildren().add(quantityLabel);
        this.getChildren().add(totalPriceLabel);
        this.getChildren().add(quantityTextLabel);
        this.getChildren().add(totalPriceTextLabel);




    }

    public void setTotalPriceLabel(float totalPrice){
        totalPriceLabel.setText(totalPrice+"");
    }

    public void setQuantityLabel(int quantity){
        quantityLabel.setText(quantity+"");
    }

}
