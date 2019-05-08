package GUI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import views.CartBookView;

import java.util.ArrayList;

/**
 * Created by first on 5/7/2019.
 */
public class CartStage extends Stage {
    Button checkOutBtn;
    Label totalPriceLabel;
    ArrayList<CartBookView> cartBookViews;
    Pane rootPane;
    ScrollPane scrollPane;
    Pane itemsPane;

    public CartStage () {
        initialize();
    }
    private void initialize(){
        rootPane = new Pane();

        checkOutBtn = new Button();
        checkOutBtn.setText("Check out");

        totalPriceLabel = new Label("Total price: ");



        /*checkOutBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                creditCardStage.show();
                //block main user window
                //addSale in creditCardStage
            }
        });*/

        //ArrayList<CartItem> cartItems = backEnd.getCartContent(userName);

        //add list of cartView
        /*float totalPrice = 0;
        for(int i = 0; i < cartItems.size(); i++){

        }*/










        rootPane.getChildren().addAll(checkOutBtn, totalPriceLabel);




        scrollPane= new ScrollPane();
        scrollPane.setLayoutY(40);
        scrollPane.setLayoutX(0);
        scrollPane.setPrefHeight(200);
        scrollPane.setPrefWidth(300);

        itemsPane = new Pane();
        scrollPane.setContent(itemsPane);
        rootPane.getChildren().add(scrollPane);

        totalPriceLabel.setLayoutX(0);
        totalPriceLabel.setLayoutY(0);

        checkOutBtn.setLayoutY(300);
        checkOutBtn.setLayoutX(200);
        this.setTitle("Cart");
        this.setScene(new Scene(rootPane, 400, 610));
    }



    public void addItem(String text){

    }





}
