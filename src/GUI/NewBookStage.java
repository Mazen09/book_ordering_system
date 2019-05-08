package GUI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by first on 5/7/2019.
 */
public class NewBookStage extends Stage{
    Label titleLabel, authorsLabel, publisherLabel, priceLabel, ISBNLabel, thresholdLabel, categoryLabel, yearLabel;
    TextField titleField, authorsField, publisherField, priceField, ISBNField, thresholdField, yearField;
    ComboBox<String> categoryBox;
    Button enterBtn;
    Pane rootPane;

    public NewBookStage(){
        initialize();
    }
    public void initialize(){

        titleLabel = new Label("title");
        authorsLabel = new Label("Authors");
        publisherLabel = new Label("publisher");
        priceLabel = new Label("price");
        ISBNLabel = new Label("ISBN");
        thresholdLabel = new Label("threshold");
        categoryLabel = new Label("category");
        yearLabel = new Label("year");


        titleField = new TextField();
        titleField.setEditable(true);
        titleField.setPrefWidth(100);


        authorsField = new TextField();
        authorsField.setEditable(true);
        authorsField.setPrefWidth(200);

        publisherField = new TextField();
        publisherField.setEditable(true);
        publisherField.setPrefWidth(200);

        priceField = new TextField();
        priceField.setEditable(true);
        priceField.setPrefWidth(200);

        ISBNField = new TextField();
        ISBNField.setEditable(true);
        ISBNField.setPrefWidth(200);

        thresholdField = new TextField();
        thresholdField.setEditable(true);
        thresholdField.setPrefWidth(200);

        yearField = new TextField();
        yearField.setEditable(true);
        yearField.setPrefWidth(200);


        enterBtn = new Button("enter");

        categoryBox = new ComboBox<>();
        categoryBox.getItems().add("Science");
        categoryBox.getItems().add("Art");
        categoryBox.getItems().add("History");
        categoryBox.getItems().add("Religion");
        categoryBox.getItems().add("Geography");

        rootPane = new Pane();

        rootPane.getChildren().addAll(titleLabel, authorsLabel, publisherLabel, priceLabel, ISBNLabel, thresholdLabel,
                categoryLabel, yearLabel, titleField, authorsField, publisherField, priceField, ISBNField,
                thresholdField, yearField, categoryBox, enterBtn);

        titleLabel.setLayoutY(0);
        authorsLabel.setLayoutY(30);
        publisherLabel.setLayoutY(60);
        priceLabel.setLayoutY(90);
        ISBNLabel.setLayoutY(120);
        thresholdLabel.setLayoutY(150);
        categoryLabel.setLayoutY(180);
        yearLabel.setLayoutY(210);

        titleLabel.setLayoutX(0);
        authorsLabel.setLayoutX(0);
        publisherLabel.setLayoutX(0);
        priceLabel.setLayoutX(0);
        ISBNLabel.setLayoutX(0);
        thresholdLabel.setLayoutX(0);
        categoryLabel.setLayoutX(0);
        yearLabel.setLayoutX(0);

        titleField.setLayoutY(0);
        authorsField.setLayoutY(30);
        publisherField.setLayoutY(60);
        priceField.setLayoutY(90);
        ISBNField.setLayoutY(120);
        thresholdField.setLayoutY(150);
        categoryBox.setLayoutY(180);
        yearField.setLayoutY(210);

        titleField.setLayoutX(70);
        authorsField.setLayoutX(70);
        publisherField.setLayoutX(70);
        priceField.setLayoutX(70);
        ISBNField.setLayoutX(70);
        thresholdField.setLayoutX(70);
        categoryBox.setLayoutX(70);
        yearField.setLayoutX(70);

        enterBtn.setLayoutX(100);
        enterBtn.setLayoutY(240);


        //this.setTitle("Sign Up");
        this.setScene(new Scene(rootPane, 400, 610));




    }


    public void setEnterBtn(String text){
        enterBtn.setText(text);
    }

    public void setStageTitle(String text){
        this.setTitle(text);
    }
}
