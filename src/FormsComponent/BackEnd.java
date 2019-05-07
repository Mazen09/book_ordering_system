package FormsComponent;

import java.util.ArrayList;

/**
 * Created by first on 5/7/2019.
 */
public interface BackEnd {
    public ArrayList<Book> getBooks(String SearchAttribute, String searchKey);

    public int getNumberOfResult(String SearchAttribute, String searchKey);

    public void insertBook(Book book) throws Exception;

    public void updateBook(Book book) throws Exception;

    public void insetAuthor(Author author) throws Exception;

    public void insertPublisher(Publisher publisher) throws Exception;

    public void insertUser(User user) throws Exception;

    public void updateUser(User user) throws Exception;

    public void promoteUser(User user);

    public ArrayList<User> getUsers(String userName);

    public void addToCart(String userName, String ISBN);

    public ArrayList<CartItem> getCartContent(String userName);

    public void updateCartItem(String userName, String ISBN);

    public void removeCartItem(String userName, String ISBN);

    public void addSale(String userName);

    public void insertOrder(String ISBN, int quantity);

    public void confirmOrder(int id);

    public User logIn(String UserName, String password) throws Exception;

    public void logOut(String UserName);

    public void reportTotalSales();

    public void reportTopCustomers();

    public void reportTopSellingBooks();

}
