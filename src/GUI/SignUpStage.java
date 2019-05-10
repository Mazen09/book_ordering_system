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
        firstNameField.setPrefWidth(200);


        lastNameField = new TextField();
        lastNameField.setEditable(true);
        lastNameField.setPrefWidth(200);

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

        firstNameLabel.setLayoutY(10);
        lastNameLabel.setLayoutY(40);
        emailLabel.setLayoutY(70);
        phoneLabel.setLayoutY(100);
        addressLabel.setLayoutY(130);
        userNameLabel.setLayoutY(160);
        passwordLabel.setLayoutY(190);
        repeatPasswordLabel.setLayoutY(220);

        firstNameLabel.setLayoutX(10);
        lastNameLabel.setLayoutX(10);
        emailLabel.setLayoutX(10);
        phoneLabel.setLayoutX(10);
        addressLabel.setLayoutX(10);
        userNameLabel.setLayoutX(10);
        passwordLabel.setLayoutX(10);
        repeatPasswordLabel.setLayoutX(10);

        firstNameField.setLayoutY(10);
        lastNameField.setLayoutY(40);
        emailField.setLayoutY(70);
        phoneField.setLayoutY(100);
        addressField.setLayoutY(130);
        userNameField.setLayoutY(160);
        passwordField.setLayoutY(190);
        repeatPasswordField.setLayoutY(220);

        firstNameField.setLayoutX(100);
        lastNameField.setLayoutX(100);
        emailField.setLayoutX(100);
        phoneField.setLayoutX(100);
        addressField.setLayoutX(100);
        userNameField.setLayoutX(100);
        passwordField.setLayoutX(100);
        repeatPasswordField.setLayoutX(100);

        enterBtn.setLayoutX(130);
        enterBtn.setLayoutY(260);


        //this.setISBNLabel("Sign Up");
        this.setScene(new Scene(rootPane, 320, 300));
        this.initModality(Modality.APPLICATION_MODAL);

    }
    public void setEnterBtn(String text){
        enterBtn.setText(text);
    }

    public void setStageTitle(String text){
        this.setTitle(text);
    }

}
