package GUI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
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

    Label quantityLabel;
    TextField quantityField;

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
        quantityLabel = new Label("quantity");

        quantityField = new TextField();
        quantityField.setEditable(true);
        quantityField.setPrefWidth(200);

        titleField = new TextField();
        titleField.setEditable(true);
        titleField.setPrefWidth(200);


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
        rootPane.getChildren().addAll(quantityField,quantityLabel);


        titleLabel.setLayoutY(10);
        authorsLabel.setLayoutY(40);
        publisherLabel.setLayoutY(70);
        priceLabel.setLayoutY(100);
        ISBNLabel.setLayoutY(130);
        thresholdLabel.setLayoutY(160);
        categoryLabel.setLayoutY(190);
        yearLabel.setLayoutY(220);
        quantityLabel.setLayoutY(250);

        titleLabel.setLayoutX(10);
        authorsLabel.setLayoutX(10);
        publisherLabel.setLayoutX(10);
        priceLabel.setLayoutX(10);
        ISBNLabel.setLayoutX(10);
        thresholdLabel.setLayoutX(10);
        categoryLabel.setLayoutX(10);
        yearLabel.setLayoutX(10);
        quantityLabel.setLayoutX(10);

        titleField.setLayoutY(10);
        authorsField.setLayoutY(40);
        publisherField.setLayoutY(70);
        priceField.setLayoutY(100);
        ISBNField.setLayoutY(130);
        thresholdField.setLayoutY(160);
        categoryBox.setLayoutY(190);
        yearField.setLayoutY(220);
        quantityField.setLayoutY(250);

        titleField.setLayoutX(80);
        authorsField.setLayoutX(80);
        publisherField.setLayoutX(80);
        priceField.setLayoutX(80);
        ISBNField.setLayoutX(80);
        thresholdField.setLayoutX(80);
        categoryBox.setLayoutX(80);
        yearField.setLayoutX(80);
        quantityField.setLayoutX(80);

        enterBtn.setLayoutX(110);
        enterBtn.setLayoutY(280);


        this.setScene(new Scene(rootPane, 300, 320));
        this.initModality(Modality.APPLICATION_MODAL);
    }


    public void setEnterBtn(String text){
        enterBtn.setText(text);
    }

    public void setStageTitle(String text){
        this.setTitle(text);
    }
}
