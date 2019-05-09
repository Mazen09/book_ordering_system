package views;

import FormsComponent.Backend;
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
    Backend backEnd = new Backend();
    public CartBookView(){
        initialize();
    }
    private void initialize(){


        removeBtn = new Button();
        removeBtn.setText("remove");
        /*removeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                backEnd.removeCartItem(user.userName, book.ISBN);
                //remove it from cart
            }
        });*/

        increaseBtn = new Button();
        increaseBtn.setText("increase");
        /*increaseBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                backEnd.updateBook();
            }
        });
*/
        decreaseBtn = new Button();
        decreaseBtn.setText("decrease");
        /*decreaseBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //when zero take care
            }
        });*/


        quantityLabel = new Label("Quantity");
        totalPriceLabel = new Label("Total price");




        this.setLayoutX(0);
        //this.setLayoutY(0);
        //this.getChildren().addAll(removeBtn, increaseBtn, decreaseBtn, quantityLabel, totalPriceLabel);
        this.getChildren().add(removeBtn);
        this.getChildren().add(increaseBtn);
        this.getChildren().add(decreaseBtn);
        this.getChildren().add(quantityLabel);
        this.getChildren().add(totalPriceLabel);
        removeBtn.setLayoutX(300);
        increaseBtn.setLayoutX(300);
        decreaseBtn.setLayoutX(300);
        quantityLabel.setLayoutX(300);
        totalPriceLabel.setLayoutX(300);


        removeBtn.setLayoutY(0);
        increaseBtn.setLayoutY(20);
        decreaseBtn.setLayoutY(40);
        quantityLabel.setLayoutY(60);
        totalPriceLabel.setLayoutY(100);


    }

    public void setTotalPriceLabel(float totalPrice){
        totalPriceLabel.setText(totalPrice + "");
    }

    public void setQuantityLabel(int quantity){
        quantityLabel.setText(quantity + "");
    }

}
