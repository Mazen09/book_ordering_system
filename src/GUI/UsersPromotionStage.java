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
public class UsersPromotionStage extends Stage{
    TextField userNameField;
    ArrayList<Pane> userPanes;
    Button findBtn;
    Pane rootPane;
    ScrollPane scrollPane;
    Pane usersPane;

    public UsersPromotionStage () {
        initialize();
    }
    private void initialize(){
        rootPane = new Pane();

        findBtn = new Button();
        findBtn.setText("find");




        userNameField = new TextField();
        userNameField.setEditable(true);
        userNameField.setPrefWidth(250);

        rootPane.getChildren().addAll(findBtn, userNameField);


        scrollPane= new ScrollPane();
        scrollPane.setLayoutY(50);
        scrollPane.setLayoutX(10);
        scrollPane.setPrefHeight(240);
        scrollPane.setPrefWidth(300);

        usersPane = new Pane();
        scrollPane.setContent(usersPane);
        rootPane.getChildren().add(scrollPane);



        userNameField.setLayoutX(10);
        userNameField.setLayoutY(10);

        findBtn.setLayoutX(270);
        findBtn.setLayoutY(10);

        this.setTitle("user promotion");
        this.setScene(new Scene(rootPane, 320, 300));
        this.initModality(Modality.APPLICATION_MODAL);
    }



    public void addItem(String text){

    }
}
