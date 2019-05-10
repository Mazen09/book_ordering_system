package views;

import javafx.scene.control.Button;

/**
 * Created by first on 5/7/2019.
 */
public class ManagerBookView extends UserBookView {
    public Button modifyBtn;
    public ManagerBookView(){


        modifyBtn = new Button();
        modifyBtn.setText("modify");
        modifyBtn.setPrefWidth(60);

        modifyBtn.setLayoutY(35);
        modifyBtn.setLayoutX(300);

        this.getChildren().add(modifyBtn);
    }

}
