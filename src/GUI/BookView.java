package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

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
    //Button addToCart;
    public BookView(){
        initialize();
    }
    private void initialize(){

        /*addToCart = new Button();
        addToCart.setText("Add");
        addToCart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });*/


        title = new Label("attribute");
        authors = new Label("attribute");
        publisher = new Label("attribute");
        price = new Label("attribute");
        year = new Label("attribute");
        availableQuantity = new Label("attribute");
        ISBN = new Label("attribute");
        category = new Label("category");



        this.setLayoutX(0);
        //this.setLayoutY(0);
        this.getChildren().addAll(/*addToCart,*/ title, authors, publisher, price, year, availableQuantity, ISBN, category);

       /* addToCart.setLayoutY(0);
        addToCart.setLayoutX(300);
*/
        title.setLayoutX(0);
        title.setLayoutY(0);

        ISBN.setLayoutX(250);
        ISBN.setLayoutY(0);

        authors.setLayoutX(0);
        authors.setLayoutY(20);

        price.setLayoutX(250);
        price.setLayoutY(20);

        publisher.setLayoutX(0);
        publisher.setLayoutY(40);

        year.setLayoutX(250);
        year.setLayoutY(40);

        category.setLayoutX(0);
        category.setLayoutY(60);

        availableQuantity.setLayoutX(250);
        availableQuantity.setLayoutY(60);
        /*this.setConstraints(addToCart,4,0);
        this.setConstraints(title,0,0);
        this.setConstraints(ISBN,2,0);
        this.setConstraints(authors,0,1);
        this.setConstraints(publisher,0,2);
        this.setConstraints(price,2,1);
        this.setConstraints(year,2,2);
        this.setConstraints(category,0,3);
        this.setConstraints(availableQuantity,2,3);

        this.setPadding(new Insets(10,10,10,10));
        this.setVgap(10);
        this.setHgap(10);*/
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
