package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;


/**
 * Created by first on 5/7/2019.
 */
public class UserMainStage extends Stage {
    Button cartBtn;
    Button profileBtn;
    Button searchBtn;
    Label attributeLabel;
    Pane root = new Pane();
    GridPane grid ;
    ArrayList<BookView> searchResult;
    ScrollPane scrollPane;
    Pane searchPane;
    CartStage cartStage = new CartStage();

    //MenuButton menuButton;
    ComboBox<String> searchAttributes;
    ComboBox<String> searchValues;
    //Spinner spinner;
    //SplitMenuButton splitMenuButton;
    public UserMainStage () {
        initialize();
    }
    private void initialize(){

        cartBtn = new Button();
        cartBtn.setText("Cart");
        cartBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cartStage.show();
                //block main user window
                //get from backend the books and Quantity
                //calculate price for each book and total price
            }
        });


        profileBtn = new Button();
        profileBtn.setText("Profile");
        profileBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cartBtn.setText(searchAttributes.getValue());
            }
        });


        searchBtn = new Button();
        searchBtn.setText("Search");
        searchBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //searchAttributes.getItems().remove(2);
                String x = searchAttributes.getValue();
                searchValues.getItems().add(x);
            }
        });


        attributeLabel = new Label("attribute");

        searchAttributes = new ComboBox<>();
        searchAttributes.getItems().add("ISBN");
        searchAttributes.getItems().add("Title");
        searchAttributes.getItems().add("Publisher");
        searchAttributes.getItems().add("Author");
        searchAttributes.getItems().add("Publishing Year");
        searchAttributes.getItems().add("Category");
        searchAttributes.getItems().add("price");


        searchValues = new ComboBox<>();
        searchValues.setEditable(true);





        grid = new GridPane();
        grid.setLayoutX(0);
        grid.setLayoutY(0);
        grid.getChildren().addAll(cartBtn,profileBtn,searchAttributes,searchBtn,searchValues);


        grid.setConstraints(cartBtn,0,0);
        grid.setConstraints(profileBtn,2,0);
        grid.setConstraints(searchAttributes,0,1);
        grid.setConstraints(searchValues,1,1);
        grid.setConstraints(searchBtn,2,1);


        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(10);
        root.getChildren().add(grid);



        searchResult = new ArrayList<>();
        scrollPane= new ScrollPane();
        scrollPane.setLayoutY(200);
        scrollPane.setLayoutX(0);
        scrollPane.setPrefHeight(200);
        scrollPane.setPrefWidth(300);

        searchPane =new Pane();
        for (int i = 0; i < 10; i++){
            BookView bookView = new BookView();
            searchResult.add(bookView);
            bookView.setLayoutY(200 * i);
            searchPane.getChildren().add(bookView);
        }

        scrollPane.setContent(searchPane);
        root.getChildren().add(scrollPane);



        /*canvas.setLayoutX(0);
        canvas.setLayoutY(0);
        canvas.setPrefHeight(600);
        canvas.setPrefWidth(800);

        *//*canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(isAddNode){
                    addNode(event.getX(),event.getY());
                    isAddNode = false;
                }else if(isAddEdge){
                    addEdge(event.getX(),event.getY());
                    isAddEdge = false;
                }
            }
        });*//*

        canvas.setBackground(new Background(new BackgroundFill(new Color(
                1,1,0.9,1), CornerRadii.EMPTY, Insets.EMPTY)));

        ScrollPane scrollPane= new ScrollPane();
        scrollPane.setLayoutY(0);
        scrollPane.setLayoutX(0);
        scrollPane.setPrefHeight(600);
        scrollPane.setPrefWidth(800);

        scrollPane.setContent(canvas);
        root.getChildren().add(scrollPane);



*/

        this.setTitle("Book Store Main");
        this.setScene(new Scene(root, 400, 610));
    }

}
