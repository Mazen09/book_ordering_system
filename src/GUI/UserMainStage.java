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
import views.BookView;

import java.util.ArrayList;


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
    GridPane grid ;
    //ArrayList<BookView> searchResult;
    ScrollPane scrollPane;
    Pane searchPane;
    int currentSearchPage = 1;
    String searchValue;
    String searchAttribute;

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
        /*cartBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cartStage = new CartStage(userName);
                cartStage.show();
                //block main user window
                //get from backend the books and Quantity
                //calculate price for each book and total price
            }
        });*/


        profileBtn = new Button();
        profileBtn.setText("Profile");
       /* profileBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cartBtn.setText(searchAttributes.getValue());
            }
        });*/


        searchBtn = new Button();
        searchBtn.setText("Search");
        /*searchBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //searchAttributes.getItems().remove(2);
                String x = searchAttributes.getValue();
                searchValues.getItems().add(x);
            }
        });

*/
        logOutBtn = new Button();
        logOutBtn.setText("Log out");

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





        grid = new GridPane();
        grid.setLayoutX(0);
        grid.setLayoutY(0);
        grid.getChildren().addAll(cartBtn,profileBtn,logOutBtn,searchAttributes,searchBtn,searchValues,
                attributeLabel);


        grid.setConstraints(cartBtn,0,0);
        grid.setConstraints(profileBtn,3,0);
        grid.setConstraints(logOutBtn,3,1);
        grid.setConstraints(searchAttributes,1,1);
        grid.setConstraints(attributeLabel,0,1);
        grid.setConstraints(searchValues,0,2,3,1);
        grid.setConstraints(searchBtn,3,2);



        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(10);
        rootPane.getChildren().add(grid);
        rootPane.getChildren().add(previousBtn);
        rootPane.getChildren().add(nextBtn);

        previousBtn.setLayoutY(420);
        previousBtn.setLayoutX(0);

        nextBtn.setLayoutY(420);
        nextBtn.setLayoutX(80);



        //searchResult = new ArrayList<>();
        scrollPane= new ScrollPane();
        scrollPane.setLayoutY(200);
        scrollPane.setLayoutX(0);
        scrollPane.setPrefHeight(200);
        scrollPane.setPrefWidth(300);

        searchPane = new Pane();
        /*for (int i = 0; i < 10; i++){
            BookView bookView = new BookView();
            searchResult.add(bookView);
            bookView.setLayoutY(200 * i);
            searchPane.getChildren().add(bookView);
        }

        UserBookView bookView = new UserBookView();
        searchResult.add(bookView);
        bookView.setLayoutY(200 * 10);
        searchPane.getChildren().add(bookView);


        CartBookView bookView2 = new CartBookView();
        searchResult.add(bookView2);
        bookView2.setLayoutY(200 * 11);
        searchPane.getChildren().add(bookView2);

*/
        scrollPane.setContent(searchPane);
        rootPane.getChildren().add(scrollPane);


        this.setTitle("Book Store Main");
        this.setScene(new Scene(rootPane, 400, 610));
    }

}
