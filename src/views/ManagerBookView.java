package views;

import javafx.scene.control.Button;

/**
 * Created by first on 5/7/2019.
 */
public class ManagerBookView extends UserBookView {
    Button modifyBtn;
    public ManagerBookView(){
        Button addToCartBtn;

        modifyBtn = new Button();
        modifyBtn.setText("modify");
    /*modifyBtn.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {

        }
    });*/

        modifyBtn.setLayoutY(30);
        modifyBtn.setLayoutX(350);

        this.getChildren().add(modifyBtn);
    }

}
