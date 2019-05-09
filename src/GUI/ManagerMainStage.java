package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * Created by first on 5/8/2019.
 */
public class ManagerMainStage extends UserMainStage {
    Button newBookBtn;
    Button newAuthorBtn;
    Button newPublisherBtn;
    Button promoteBtn;
    Button placeOrderBtn;
    Button confirmOrderBtn;
    Button topCustomerReportBtn;
    Button topSellReportBtn;
    Button sellsReportBtn;

    Pane managerPane;
    public ManagerMainStage(){
        initialize();
    }
    private void initialize(){

        newBookBtn = new Button("New Book");
        newAuthorBtn = new Button("New Author");
        newPublisherBtn = new Button("New Publisher");
        promoteBtn = new Button("Promote");
        placeOrderBtn = new Button("Place Order");
        confirmOrderBtn = new Button("Confirm Order");
        topCustomerReportBtn = new Button("top customer");
        topSellReportBtn = new Button("top sells");
        sellsReportBtn = new Button("sells");



        managerPane = new Pane();
        managerPane.setLayoutX(0);
        managerPane.setLayoutY(520);
        managerPane.getChildren().addAll(newAuthorBtn,newBookBtn, newPublisherBtn,confirmOrderBtn,placeOrderBtn,
                promoteBtn,topCustomerReportBtn,topSellReportBtn,sellsReportBtn);


        newBookBtn.setPrefWidth(120);
        newAuthorBtn.setPrefWidth(120);
        newPublisherBtn.setPrefWidth(120);
        confirmOrderBtn.setPrefWidth(120);
        placeOrderBtn.setPrefWidth(120);
        promoteBtn.setPrefWidth(120);
        topCustomerReportBtn.setPrefWidth(120);
        topSellReportBtn.setPrefWidth(120);
        sellsReportBtn.setPrefWidth(120);

        newBookBtn.setLayoutX(10);
        newBookBtn.setLayoutY(10);

        newAuthorBtn.setLayoutX(140);
        newAuthorBtn.setLayoutY(10);

        newPublisherBtn.setLayoutX(270);
        newPublisherBtn.setLayoutY(10);


        confirmOrderBtn.setLayoutX(10);
        confirmOrderBtn.setLayoutY(40);

        placeOrderBtn.setLayoutX(140);
        placeOrderBtn.setLayoutY(40);

        promoteBtn.setLayoutX(270);
        promoteBtn.setLayoutY(40);

        topCustomerReportBtn.setLayoutX(10);
        topCustomerReportBtn.setLayoutY(70);

        topSellReportBtn.setLayoutX(140);
        topSellReportBtn.setLayoutY(70);

        sellsReportBtn.setLayoutX(270);
        sellsReportBtn.setLayoutY(70);

        scrollPane.setPrefHeight(400);

        previousBtn.setLayoutY(490);

        nextBtn.setLayoutY(490);
        rootPane.getChildren().add(managerPane);
    }

}
