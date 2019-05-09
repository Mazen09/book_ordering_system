package views;

import FormsComponent.Book;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * Created by first on 5/7/2019.
 */
public class BookView extends Pane {
    Label title;
    Label authors;
    Label publisher;
    Label price;
    Label year;
    Label availableQuantity;
    Label ISBN;
    Label category;

    public BookView(){
        initialize();
    }
    private void initialize(){

        title = new Label("ISBNLabel");
        authors = new Label("IDLabel");
        publisher = new Label("quantityLabel");
        price = new Label("dateLabel");
        year = new Label("year");
        availableQuantity = new Label("availableQuantity");
        ISBN = new Label("ISBN");
        category = new Label("category");



        this.setLayoutX(0);
        //this.setLayoutY(0);
        this.getChildren().addAll(title, authors, publisher, price, year, availableQuantity, ISBN, category);
        this.setBackground(new Background(new BackgroundFill(new Color(
                1,1,0.9,1), CornerRadii.EMPTY, Insets.EMPTY)));

        title.setLayoutX(0);
        title.setLayoutY(0);

        ISBN.setLayoutX(200);
        ISBN.setLayoutY(0);

        authors.setLayoutX(0);
        authors.setLayoutY(20);

        price.setLayoutX(200);
        price.setLayoutY(20);

        publisher.setLayoutX(0);
        publisher.setLayoutY(40);

        year.setLayoutX(200);
        year.setLayoutY(40);

        category.setLayoutX(0);
        category.setLayoutY(60);

        availableQuantity.setLayoutX(200);
        availableQuantity.setLayoutY(60);
    }
    public void setTitle(String titleStr){
        title.setText(titleStr);
    }

    public void setAuthors(String authorsStr) {
        authors.setText(authorsStr);
    }

    public void setPrice(String priceStr) {
        price.setText(priceStr);
    }

    public void setPublisher(String publisherStr) {
        publisher.setText(publisherStr);
    }

    public void setYear(String yearStr) {
        year.setText(yearStr);
    }
    public void setISBN(String ISBNStr) {
        ISBN.setText(ISBNStr);
    }

    public void setCategory(String categoryStr) {
        category.setText(categoryStr);
    }
    public void setAvailableQuantity(String availableQuantityStr) {
        availableQuantity.setText(availableQuantityStr);
    }

}
