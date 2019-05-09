package GUI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
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
        userNameField.setPrefWidth(200);

        rootPane.getChildren().addAll(findBtn, userNameField);


        scrollPane= new ScrollPane();
        scrollPane.setLayoutY(40);
        scrollPane.setLayoutX(0);
        scrollPane.setPrefHeight(200);
        scrollPane.setPrefWidth(300);

        usersPane = new Pane();
        scrollPane.setContent(usersPane);
        rootPane.getChildren().add(scrollPane);



        userNameField.setLayoutX(0);
        userNameField.setLayoutY(0);

        findBtn.setLayoutX(220);
        findBtn.setLayoutY(0);

        this.setTitle("user promotion");
        this.setScene(new Scene(rootPane, 400, 610));
    }



    public void addItem(String text){

    }
}
