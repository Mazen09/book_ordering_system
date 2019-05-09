package GUI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

/**
 * Created by first on 5/8/2019.
 */
public class ManagerMainStage extends UserMainStage {
    Button newBookBtn;
    Button newAuthorBtn;
    Button newPublisher;
    Button promoteBtn;
    Button placeOrderBtn;
    Button confirmOrderBtn;
    Button topCustomerReportBtn;
    Button topSellReportBtn;
    Button sellsReportBtn;

    GridPane managerGrid;
    public ManagerMainStage(){
        initialize();
    }
    private void initialize(){

        newBookBtn = new Button();
        newBookBtn.setText("New Book");

        newAuthorBtn = new Button();
        newAuthorBtn.setText("New Author");

        newPublisher = new Button();
        newPublisher.setText("New Publisher");

        promoteBtn = new Button();
        promoteBtn.setText("Promote");

        placeOrderBtn = new Button();
        placeOrderBtn.setText("Place Order");

        confirmOrderBtn = new Button();
        confirmOrderBtn.setText("Confirm Order");

        topCustomerReportBtn = new Button();
        topCustomerReportBtn.setText("top customer");

        topSellReportBtn = new Button();
        topSellReportBtn.setText("top sells");

        sellsReportBtn = new Button();
        sellsReportBtn.setText("sells");



        managerGrid = new GridPane();
        managerGrid.setLayoutX(0);
        managerGrid.setLayoutY(450);
        managerGrid.getChildren().addAll(newAuthorBtn,newBookBtn,newPublisher,confirmOrderBtn,placeOrderBtn,
                promoteBtn,topCustomerReportBtn,topSellReportBtn,sellsReportBtn);


        managerGrid.setConstraints(newBookBtn,0,0);
        managerGrid.setConstraints(newAuthorBtn,1,0);
        managerGrid.setConstraints(newPublisher,2,0);
        managerGrid.setConstraints(placeOrderBtn,0,1);
        managerGrid.setConstraints(confirmOrderBtn,1,1);
        managerGrid.setConstraints(promoteBtn,2,1);
        managerGrid.setConstraints(topCustomerReportBtn,0,2);
        managerGrid.setConstraints(topSellReportBtn,1,2);
        managerGrid.setConstraints(sellsReportBtn,2,2);



        managerGrid.setPadding(new Insets(10,10,10,10));
        managerGrid.setVgap(10);
        managerGrid.setHgap(10);
        rootPane.getChildren().add(managerGrid);




        //this.setTitle("Book Store Main");
        //this.setScene(new Scene(rootPane, 400, 710));
    }

}
