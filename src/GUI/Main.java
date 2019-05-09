package GUI;

import FormsComponent.BackEndImplementation;
import FormsComponent.Book;
import FormsComponent.CartItem;
import FormsComponent.User;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import views.CartBookView;
import views.UserBookView;

import java.util.ArrayList;

public class Main extends Application {
    Pane root = new Pane();
    GridPane grid ;
    Button logInBtn ;
    Button signUpBtn ;
    Label userNameLabel;
    Label passwordLabel;
    TextField userNameField ;
    TextField passwordField ;

    User user;
    ArrayList<Book> searchBooks;

    Stage primaryStage;
    UserMainStage userMainStage = new UserMainStage();
    CartStage cartStage = new CartStage();
    ConfirmOrderStage confirmOrderStage = new ConfirmOrderStage();
    CreditCardStage creditCardStage = new CreditCardStage();
    NewAuthorStage newAuthorStage = new NewAuthorStage();
    NewBookStage newBookStage = new NewBookStage();
    NewBookStage updateBookStage = new NewBookStage();
    NewPublisherStage newPublisherStage = new NewPublisherStage();
    PlaceOrderStage placeOrderStage = new PlaceOrderStage();
    SignUpStage profileStage = new SignUpStage();
    SignUpStage signUpStage = new SignUpStage();
    UsersPromotionStage usersPromotionStage = new UsersPromotionStage();

    BackEndImplementation backEnd = new BackEndImplementation();


    private void initialize(){
        logInBtn = new Button();
        logInBtn.setText("Log In");
        logInBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    user = backEnd.logIn(userNameField.getText(), passwordField.getText());
                    primaryStage.hide();
                    if(user.role == "user"){
                        userMainStage = new UserMainStage();
                        setUserMainStageActions();
                    } else {
                        userMainStage = new ManagerMainStage();
                        setManagerMainStageActions();
                    }
                    userMainStage.show();
                } catch (Exception e){
                    //error massage

                }

                //userMainStage = new ManagerMainStage();
                //userMainStage.show();

                //signUpStage.show();
                //newBookStage.show();
                //newAuthorStage.show();
                //newPublisherStage.show();
                //creditCardStage.show();
                //cartStage.show();
                //confirmOrderStage.show();
                //placeOrderStage.show();
                //primaryStage.hide();
                //usersPromotionStage.show();
            }
        });


        signUpBtn = new Button();
        signUpBtn.setText("Sign Up");
        signUpBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                signUpStage.setEnterBtn("sign up");
                signUpStage.setStageTitle("sign up");
                setSignUpStageActions();
                signUpStage.showAndWait();
            }
        });



        userNameLabel = new Label("user name");
        passwordLabel = new Label("password");


        userNameField = new TextField();
        userNameField.setEditable(true);
        userNameField.setPrefWidth(200);

        // make it hiden as password
        passwordField = new TextField();
        passwordField.setEditable(true);
        passwordField.setPrefWidth(200);





        grid = new GridPane();
        grid.setLayoutX(0);
        grid.setLayoutY(0);
        grid.getChildren().addAll(logInBtn,signUpBtn,userNameField,passwordField,userNameLabel,passwordLabel);


        grid.setConstraints(userNameLabel,0,0);
        grid.setConstraints(userNameField,1,0);
        grid.setConstraints(passwordLabel,0,1);
        grid.setConstraints(passwordField,1,1);
        grid.setConstraints(logInBtn,0,2);
        grid.setConstraints(signUpBtn,1,2);

        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(10);
        root.getChildren().add(grid);

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent rootPane = FXMLLoader.load(getClass().getResource("sample.fxml"));
        initialize();
        primaryStage.setTitle("Book Store");
        primaryStage.setScene(new Scene(root, 280, 110));
        primaryStage.show();
        this.primaryStage = primaryStage;
    }


    public static void main(String[] args) {
        launch(args);
    }



    private void setCartStageActions(){
        cartStage.checkOutBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setCreditCardStageActions();
                creditCardStage.show();
            }
        });
    }
    private void setConfirmOrderStageActions(){

    }
    private void setCreditCardStageActions(){
        //check for valid card
        creditCardStage.okBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                backEnd.addSale(user.userName);
                cartStage.hide();
                creditCardStage.hide();
            }
        });

    }
    private void setNewAuthorStageActions(){

    }
    private void setNewBookStageActions(){

    }
    private void setNewPublisherStageActions(){

    }

    private void setPlaceOrderStageActions(){

    }

    private void setProfileStageActions(){
        profileStage.enterBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                User newUser = new User();
                newUser.address = signUpStage.addressField.getText();
                newUser.email = signUpStage.emailField.getText();
                newUser.firstName = signUpStage.firstNameField.getText();
                newUser.lastName = signUpStage.lastNameField.getText();
                newUser.userName = signUpStage.userNameField.getText();
                newUser.phone = signUpStage.phoneField.getText();
                newUser.password = signUpStage.passwordField.getText();
                //check repeatedPassword
                newUser.role = "user";
                try {
                    backEnd.updateUser(user,newUser);
                    user = newUser;
                    profileStage.hide();
                } catch (Exception e) {
                    //error  message
                }
            }
        });
    }
    private void setSignUpStageActions(){
        signUpStage.enterBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 user = new User();
                 user.address = signUpStage.addressField.getText();
                 user.email = signUpStage.emailField.getText();
                 user.firstName = signUpStage.firstNameField.getText();
                 user.lastName = signUpStage.lastNameField.getText();
                 user.userName = signUpStage.userNameField.getText();
                 user.phone = signUpStage.phoneField.getText();
                 user.password = signUpStage.passwordField.getText();
                //check repeatedPassword
                 user.role = "user";
                 try {
                     backEnd.insertUser(user);
                     userMainStage = new UserMainStage();
                     setUserMainStageActions();
                     userMainStage.show();
                     signUpStage.hide();
                     primaryStage.hide();
                 } catch (Exception e) {
                     //error  message
                 }
            }
        });
    }
    private void setUsersPromotionStageActions(){

    }

    private void setUserMainStageActions(){
        userMainStage.cartBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setCartStageActions();

                ArrayList<CartItem> cartItems = backEnd.getCartContent(user.userName);
                //add all items view and set their actions (inc dec remove ...)
                float totalPrice = 0;
                for(int i = 0; i < cartItems.size(); i++){
                    CartItem cartItem = cartItems.get(i);
                    Book book = cartItem.book;
                    CartBookView itemView = new CartBookView();
                    itemView.setQuantityLabel(cartItem.quantity);
                    itemView.setTotalPriceLabel(book.price * cartItem.quantity);
                    itemView.setTitle(book.title);
                    itemView.setPublisher(book.publisher);
                    String authors= new String();
                    for (int j = 0; j <book.authors.size()-1; j++){
                        authors += book.authors.get(j) + ",";
                    }
                    authors += book.authors.get(book.authors.size()-1);
                    itemView.setAuthors(authors);
                    itemView.setPrice(book.price+"");
                    itemView.setYear(book.publishingYear);
                    itemView.setCategory(book.category);
                    itemView.setAvailableQuantity(book.currentAmount+"");

                    cartStage.itemsPane.getChildren().add(itemView);
                    itemView.setLayoutY(i*100);
                    itemView.setLayoutX(10);

                    itemView.removeBtn.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            backEnd.removeCartItem(user.userName, book.ISBN);
                            cartStage.itemsPane.getChildren().remove(itemView);
                            float price = Float.parseFloat(cartStage.totalPriceLabel .getText());
                            price -= book.price * cartItem.quantity;
                            cartStage.totalPriceLabel.setText(price+ "");
                        }
                    });

                    itemView.increaseBtn.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            if(book.currentAmount >= cartItem.quantity + 1){
                                cartItem.quantity++;
                                backEnd.updateCartItem(user.userName, book.ISBN, cartItem.quantity);
                                itemView.setQuantityLabel(cartItem.quantity);
                                itemView.setTotalPriceLabel(book.price * cartItem.quantity);
                                float price = Float.parseFloat(cartStage.totalPriceLabel .getText());
                                price += book.price;
                                cartStage.totalPriceLabel.setText(price+ "");
                            }
                        }
                    });

                    itemView.decreaseBtn.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            if(cartItem.quantity - 1 > 0){
                                cartItem.quantity--;
                                backEnd.updateCartItem(user.userName, book.ISBN, cartItem.quantity);
                                itemView.setQuantityLabel(cartItem.quantity);
                                itemView.setTotalPriceLabel(book.price * cartItem.quantity);
                                float price = Float.parseFloat(cartStage.totalPriceLabel .getText());
                                price -= book.price;
                                cartStage.totalPriceLabel.setText(price+ "");
                            }
                        }
                    });

                    totalPrice += book.price * cartItem.quantity;
                }
                cartStage.totalPriceLabel.setText(totalPrice+"");
                cartStage.showAndWait();
            }
        });
        userMainStage.logOutBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                backEnd.logOut(user.userName);
                primaryStage.show();
                userMainStage.hide();
            }
        });
        userMainStage.profileBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                profileStage.setEnterBtn("update");
                profileStage.setStageTitle("profile");
                setProfileStageActions();
                profileStage.addressField.setText(user.address);
                profileStage.emailField.setText(user.email);
                profileStage.firstNameField.setText(user.firstName);
                profileStage.lastNameField.setText(user.lastName);
                profileStage.userNameField.setText(user.userName);
                profileStage.phoneField.setText(user.phone);
                profileStage.passwordField.setText(user.password);

                profileStage.showAndWait();
            }
        });
        userMainStage.searchBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(userMainStage.searchValues.getValue() != null) {
                    if (userMainStage.searchValues.getValue().compareTo("") != 0) {
                        userMainStage.currentSearchPage = 1;
                        userMainStage.searchValue = userMainStage.searchValues.getValue();
                        userMainStage.searchAttribute = userMainStage.searchAttributes.getValue();
                        setBookSearchResult();
                    }
                }
            }
        });
        userMainStage.searchAttributes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String attribute = userMainStage.searchAttributes.getValue();
                if(attribute.compareTo("Category") == 0){
                    userMainStage.searchValues.setEditable(false);
                    userMainStage.searchValues.getItems().add("Science");
                    userMainStage.searchValues.getItems().add("Art");
                    userMainStage.searchValues.getItems().add("Religion");
                    userMainStage.searchValues.getItems().add("History");
                    userMainStage.searchValues.getItems().add("Geography");
                }else {
                    userMainStage.searchValues.setEditable(true);
                    userMainStage.searchValues.getItems().clear();
                }
            }
        });
        userMainStage.nextBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(userMainStage.searchValues.getValue() != null) {
                    if (userMainStage.searchValue.compareTo("") != 0) {
                        userMainStage.currentSearchPage++;
                        setBookSearchResult();
                    }
                }
            }
        });
        userMainStage.previousBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(userMainStage.searchValues.getValue() != null) {
                    if (userMainStage.currentSearchPage > 1 &&
                            userMainStage.searchValue.compareTo("") != 0) {
                        userMainStage.currentSearchPage--;
                        setBookSearchResult();
                    }
                }
            }
        });
    }
    private void setBookSearchResult(){
        ArrayList<Book> books = backEnd.getBooks(
                userMainStage.searchAttribute,
                userMainStage.searchValue, userMainStage.currentSearchPage
        );
        userMainStage.searchPane.getChildren().removeAll();
        for(int i = 0; i < books.size(); i++){
            Book book = books.get(i);
            UserBookView bookView = new UserBookView();
            bookView.setTitle(book.title);
            bookView.setPublisher(book.publisher);
            String authors= new String();
            for (int j = 0; j <book.authors.size()-1; j++){
                authors += book.authors.get(j) + ",";
            }
            authors += book.authors.get(book.authors.size()-1);
            bookView.setAuthors(authors);
            bookView.setPrice(book.price+"");
            bookView.setYear(book.publishingYear);
            bookView.setCategory(book.category);
            bookView.setAvailableQuantity(book.currentAmount+"");

            userMainStage.searchPane.getChildren().add(bookView);
            bookView.setLayoutY(i*100);
            bookView.setLayoutX(10);

            bookView.addToCartBtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    backEnd.addToCart(user.userName, book.ISBN);
                }
            });
        }
    }

    private void setManagerMainStageActions() {
        setUserMainStageActions();
        ManagerMainStage mangerStage = (ManagerMainStage)userMainStage;
        mangerStage.topSellReportBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                backEnd.reportTopSellingBooks();
            }
        });
        mangerStage.topCustomerReportBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                backEnd.reportTopCustomers();
            }
        });
        mangerStage.sellsReportBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                backEnd.reportTotalSales();
            }
        });

    }


}
