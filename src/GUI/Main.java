package GUI;

import FormsComponent.BackEndImplementation;
import FormsComponent.Book;
import FormsComponent.User;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    Pane root = new Pane();
    GridPane grid ;
    Button logInBtn ;
    Button signUpBtn ;
    Label userNameLabel;
    Label passwordLabel;
    TextField userNameField ;
    TextField passwordField ;

    User user;
    ArrayList<Book> searchBooks;

    Stage primary;
    UserMainStage userMainStage = new UserMainStage();
    CartStage cartStage = new CartStage();
    ConfirmOrderStage confirmOrderStage = new ConfirmOrderStage();
    CreditCardStage creditCardStage = new CreditCardStage();
    NewAuthorStage newAuthorStage = new NewAuthorStage();
    NewBookStage newBookStage = new NewBookStage();
    NewBookStage updateBookStage = new NewBookStage();
    NewPublisherStage newPublisherStage = new NewPublisherStage();
    PlaceOrderStage placeOrderStage = new PlaceOrderStage();
    SignUpStage profileStage = new SignUpStage();
    SignUpStage signUpStage = new SignUpStage();
    UsersPromotionStage usersPromotionStage = new UsersPromotionStage();

    BackEndImplementation backEnd = new BackEndImplementation();


    private void initialize(){
        logInBtn = new Button();
        logInBtn.setText("Log In");
        logInBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    user = backEnd.logIn(userNameField.getText(), passwordField.getText());
                } catch (Exception e){
                    //error massage
                }
                //userMainStage = new ManagerMainStage();
                //userMainStage.show();

                //signUpStage.show();
                //newBookStage.show();
                //newAuthorStage.show();
                //newPublisherStage.show();
                //creditCardStage.show();
                //cartStage.show();
                confirmOrderStage.show();
                //placeOrderStage.show();
                primary.hide();
                //usersPromotionStage.show();
            }
        });


        signUpBtn = new Button();
        signUpBtn.setText("Sign Up");
        signUpBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                signUpStage.show();
                primary.hide();
            }
        });



        userNameLabel = new Label("user name");
        passwordLabel = new Label("password");


        userNameField = new TextField();
        userNameField.setEditable(true);
        userNameField.setPrefWidth(200);

        // make it hiden as password
        passwordField = new TextField();
        passwordField.setEditable(true);
        passwordField.setPrefWidth(200);





        grid = new GridPane();
        grid.setLayoutX(0);
        grid.setLayoutY(0);
        grid.getChildren().addAll(logInBtn,signUpBtn,userNameField,passwordField,userNameLabel,passwordLabel);


        grid.setConstraints(userNameLabel,0,0);
        grid.setConstraints(userNameField,1,0);
        grid.setConstraints(passwordLabel,0,1);
        grid.setConstraints(passwordField,1,1);
        grid.setConstraints(logInBtn,0,2);
        grid.setConstraints(signUpBtn,1,2);

        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(10);
        root.getChildren().add(grid);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent rootPane = FXMLLoader.load(getClass().getResource("sample.fxml"));
        initialize();
        primaryStage.setTitle("Book Store");
        primaryStage.setScene(new Scene(root, 280, 110));
        primaryStage.show();
        primary = primaryStage;
    }


    public static void main(String[] args) {
        launch(args);
    }



    private void setCartStageActions(){

    }
    private void setConfirmOrderStageActions(){

    }
    private void setCreditCardStageeActions(){

    }
    private void setNewAuthorStageActions(){

    }
    private void setNewBookStageActions(){

    }
    private void setNewPublisherStageActions(){

    }

    private void setPlaceOrderStageActions(){

    }

    private void setProfileStageActions(){

    }
    private void setSignUpStageActions(){

    }
    private void setUsersPromotionStageActions(){

    }

    private void setUserMainStageActions(){

    }


}
