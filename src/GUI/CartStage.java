package GUI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import views.CartBookView;

import java.util.ArrayList;

/**
 * Created by first on 5/7/2019.
 */
public class CartStage extends Stage {
    Button checkOutBtn;
    Label totalPriceLabel;
    Label totalLabel;
    ArrayList<CartBookView> cartBookViews;
    Pane rootPane;
    ScrollPane scrollPane;
    Pane itemsPane;

    public CartStage () {
        initialize();
    }
    private void initialize(){
        rootPane = new Pane();

        checkOutBtn = new Button("Check out");
        totalPriceLabel = new Label("Total price: ");
        totalLabel = new Label("Total Price: ");

        rootPane.getChildren().addAll(checkOutBtn, totalPriceLabel, totalLabel);

        scrollPane= new ScrollPane();
        scrollPane.setLayoutY(40);
        scrollPane.setLayoutX(10);
        scrollPane.setPrefHeight(400);
        scrollPane.setPrefWidth(385);

        itemsPane = new Pane();
        scrollPane.setContent(itemsPane);
        rootPane.getChildren().add(scrollPane);

        totalPriceLabel.setLayoutX(70);
        totalPriceLabel.setLayoutY(10);

        totalLabel.setLayoutX(10);
        totalLabel.setLayoutY(10);

        checkOutBtn.setLayoutY(450);
        checkOutBtn.setLayoutX(320);
        this.setTitle("Cart");
        this.setScene(new Scene(rootPane, 405, 480));
        this.initModality(Modality.APPLICATION_MODAL);
    }








}
