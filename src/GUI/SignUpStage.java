package GUI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by first on 5/6/2019.
 */
public class SignUpStage extends Stage {

    Label firstNameLabel, lastNameLabel, emailLabel, phoneLabel, addressLabel, userNameLabel, passwordLabel;
    Label repeatPasswordLabel;

    TextField firstNameField, lastNameField, emailField, phoneField, addressField, userNameField, passwordField;
    TextField repeatPasswordField;

    Button enterBtn;

    Pane rootPane;

    public SignUpStage () {
        initialize();
    }
    private void initialize(){
        firstNameLabel = new Label("first name");
        lastNameLabel = new Label("last name");
        emailLabel = new Label("email");
        phoneLabel = new Label("phone");
        addressLabel = new Label("address");
        userNameLabel = new Label("userName");
        passwordLabel = new Label("password");
        repeatPasswordLabel = new Label("repeat password");


        firstNameField = new TextField();
        firstNameField.setEditable(true);
        firstNameField.setPrefWidth(100);


        lastNameField = new TextField();
        lastNameField.setEditable(true);
        lastNameField.setPrefWidth(100);

        emailField = new TextField();
        emailField.setEditable(true);
        emailField.setPrefWidth(200);

        phoneField = new TextField();
        phoneField.setEditable(true);
        phoneField.setPrefWidth(200);

        addressField = new TextField();
        addressField.setEditable(true);
        addressField.setPrefWidth(200);

        userNameField = new TextField();
        userNameField.setEditable(true);
        userNameField.setPrefWidth(200);

        passwordField = new TextField();
        passwordField.setEditable(true);
        passwordField.setPrefWidth(200);

        repeatPasswordField = new TextField();
        repeatPasswordField.setEditable(true);
        repeatPasswordField.setPrefWidth(200);

        enterBtn = new Button("enter");

        //this.setLayoutY(0);
        rootPane = new Pane();
        rootPane.getChildren().addAll(firstNameLabel, lastNameLabel, emailLabel, phoneLabel, addressLabel,
                userNameLabel, passwordLabel, repeatPasswordLabel,firstNameField, lastNameField, emailField,
                phoneField, addressField, userNameField, passwordField, repeatPasswordField,enterBtn);

        firstNameLabel.setLayoutY(0);
        lastNameLabel.setLayoutY(30);
        emailLabel.setLayoutY(60);
        phoneLabel.setLayoutY(90);
        addressLabel.setLayoutY(120);
        userNameLabel.setLayoutY(150);
        passwordLabel.setLayoutY(180);
        repeatPasswordLabel.setLayoutY(210);

        firstNameLabel.setLayoutX(0);
        lastNameLabel.setLayoutX(0);
        emailLabel.setLayoutX(0);
        phoneLabel.setLayoutX(0);
        addressLabel.setLayoutX(0);
        userNameLabel.setLayoutX(0);
        passwordLabel.setLayoutX(0);
        repeatPasswordLabel.setLayoutX(0);

        firstNameField.setLayoutY(0);
        lastNameField.setLayoutY(30);
        emailField.setLayoutY(60);
        phoneField.setLayoutY(90);
        addressField.setLayoutY(120);
        userNameField.setLayoutY(150);
        passwordField.setLayoutY(180);
        repeatPasswordField.setLayoutY(210);

        firstNameField.setLayoutX(70);
        lastNameField.setLayoutX(70);
        emailField.setLayoutX(70);
        phoneField.setLayoutX(70);
        addressField.setLayoutX(70);
        userNameField.setLayoutX(70);
        passwordField.setLayoutX(70);
        repeatPasswordField.setLayoutX(70);

        enterBtn.setLayoutX(100);
        enterBtn.setLayoutY(240);


        //this.setISBNLabel("Sign Up");
        this.setScene(new Scene(rootPane, 400, 610));
        this.initModality(Modality.APPLICATION_MODAL);

    }
    public void setEnterBtn(String text){
        enterBtn.setText(text);
    }

    public void setStageTitle(String text){
        this.setTitle(text);
    }

}
