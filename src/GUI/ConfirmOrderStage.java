package GUI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import views.CartBookView;
import views.OrderView;

import java.util.ArrayList;

/**
 * Created by first on 5/7/2019.
 */
public class ConfirmOrderStage extends Stage {
    TextField ISBNField;
    ArrayList<OrderView> ordersView;
    Button findBtn;
    Label ISBNLabel;
    Pane rootPane;
    ScrollPane scrollPane;
    Pane ordersPane;

    public ConfirmOrderStage () {
        initialize();
    }
    private void initialize(){
        rootPane = new Pane();

        findBtn = new Button();
        findBtn.setText("find");

        ISBNLabel = new Label("ISBN");


        ISBNField = new TextField();
        ISBNField.setEditable(true);
        ISBNField.setPrefWidth(350);

        rootPane.getChildren().addAll(findBtn, ISBNLabel, ISBNField);


        scrollPane= new ScrollPane();
        scrollPane.setLayoutY(40);
        scrollPane.setLayoutX(10);
        scrollPane.setPrefHeight(500);
        scrollPane.setPrefWidth(450);

        ordersPane = new Pane();
        scrollPane.setContent(ordersPane);
        rootPane.getChildren().add(scrollPane);

        ISBNLabel.setLayoutX(10);
        ISBNLabel.setLayoutY(15);

        ISBNField.setLayoutX(50);
        ISBNField.setLayoutY(10);

        findBtn.setLayoutX(420);
        findBtn.setLayoutY(10);

        this.setTitle("confirm");
        this.setScene(new Scene(rootPane, 470, 550));
        this.initModality(Modality.APPLICATION_MODAL);
    }



    public void addItem(String text){

    }
}
