package views;

import javafx.scene.control.Button;

/**
 * Created by first on 5/7/2019.
 */
public class UserBookView extends BookView {
    Button addToCartBtn;
    public UserBookView(){
        addToCartBtn = new Button();
        addToCartBtn.setText("Add");
        /*addToCartBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });*/

        addToCartBtn.setLayoutY(0);
        addToCartBtn.setLayoutX(350);

        this.getChildren().add(addToCartBtn);
    }
}
