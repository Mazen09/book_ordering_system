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


/**
 * Created by first on 5/7/2019.
 */
public class UserMainStage extends Stage {
    Button cartBtn;
    Button profileBtn;
    Button searchBtn;
    Button logOutBtn;
    Button nextBtn;
    Button previousBtn;
    Label attributeLabel;
    Pane rootPane = new Pane();
    Pane BtnPane;
    //ArrayList<BookView> searchResult;
    ScrollPane scrollPane;
    Pane searchPane;
    int currentSearchPage = 1;
    String searchValue = new String();
    String searchAttribute =  new String();
    boolean isSearched = false;
    boolean isIncrease = false;

    //MenuButton menuButton;
    ComboBox<String> searchAttributes;
    ComboBox<String> searchValues;
    //Spinner spinner;
    //SplitMenuButton splitMenuButton;
    public UserMainStage () {
        initialize();
    }
    private void initialize(){

        cartBtn = new Button("Cart");
        profileBtn = new Button("Profile");
        searchBtn = new Button("Search");
        logOutBtn = new Button("Log out");
        previousBtn = new Button("previous");
        nextBtn = new Button("next");

        attributeLabel = new Label("attribute");

        searchAttributes = new ComboBox<>();
        searchAttributes.getItems().add("ISBN");
        searchAttributes.getItems().add("Title");
        searchAttributes.getItems().add("Publisher");
        searchAttributes.getItems().add("Author");
        searchAttributes.getItems().add("Publishing Year");
        searchAttributes.getItems().add("Category");
        searchAttributes.getItems().add("Price");

        searchValues = new ComboBox<>();
        searchValues.setEditable(true);



        BtnPane = new Pane();
        BtnPane.getChildren().addAll(cartBtn,profileBtn,logOutBtn,searchAttributes,searchBtn,searchValues
                /*, attributeLabel*/);

        scrollPane= new ScrollPane();
        searchPane = new Pane();
        scrollPane.setContent(searchPane);

        rootPane.getChildren().add(scrollPane);
        rootPane.getChildren().add(BtnPane);
        rootPane.getChildren().add(previousBtn);
        rootPane.getChildren().add(nextBtn);


        BtnPane.setLayoutX(0);
        BtnPane.setLayoutY(0);

        cartBtn.setLayoutX(10);
        cartBtn.setLayoutY(10);

        profileBtn.setLayoutY(10);
        profileBtn.setLayoutX(272);

        logOutBtn.setLayoutY(10);
        logOutBtn.setLayoutX(332);

        searchAttributes.setLayoutX(10);
        searchAttributes.setLayoutY(40);

        searchValues.setLayoutX(150);
        searchValues.setLayoutY(40);

        searchBtn.setLayoutX(334);
        searchBtn.setLayoutY(40);

        scrollPane.setLayoutY(80);
        scrollPane.setLayoutX(10);
        scrollPane.setPrefHeight(500);
        scrollPane.setPrefWidth(380);

        previousBtn.setLayoutY(590);
        previousBtn.setLayoutX(10);

        nextBtn.setLayoutY(590);
        nextBtn.setLayoutX(350);



        this.setTitle("Book Store Main");
        this.setScene(new Scene(rootPane, 400, 620));
    }

}
