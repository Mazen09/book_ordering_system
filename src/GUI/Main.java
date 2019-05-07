package GUI;

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

public class Main extends Application {
    Pane root = new Pane();
    //Stage signUpStage =  new Stage();
    Stage userMainStage =  new UserMainStage();
    //AnchorPane canvas = new AnchorPane();
    Button logInBtn ;
    Button signUpBtn ;
    Stage primary;

    Label userNameLabel;
    Label passwordLabel;


    TextField userNameField ;
    TextField passwordField ;

    GridPane grid ;
    private void initialize(){
        logInBtn = new Button();
        logInBtn.setText("Log In");
        logInBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                userMainStage.show();
            }
        });


        signUpBtn = new Button();
        signUpBtn.setText("Sign Up");
        signUpBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });



        userNameLabel = new Label("user name");
        passwordLabel = new Label("password");


        userNameField = new TextField();
        userNameField.setEditable(true);
        userNameField.setPrefWidth(200);


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
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        initialize();
        primaryStage.setTitle("Book Store");
        primaryStage.setScene(new Scene(root, 280, 110));
        primaryStage.show();
        primary = primaryStage;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
