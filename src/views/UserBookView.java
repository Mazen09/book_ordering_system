package views;

import javafx.scene.control.Button;

/**
 * Created by first on 5/7/2019.
 */
public class UserBookView extends BookView {
    public Button addToCartBtn;
    public UserBookView(){
        addToCartBtn = new Button();
        addToCartBtn.setText("Add");
        addToCartBtn.setPrefWidth(60);
        addToCartBtn.setLayoutY(0);
        addToCartBtn.setLayoutX(300);

        this.getChildren().add(addToCartBtn);
    }
}
