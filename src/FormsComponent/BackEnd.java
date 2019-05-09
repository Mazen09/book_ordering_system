package FormsComponent;

import java.util.ArrayList;

/**
 * Created by first on 5/7/2019.
 */
public interface BackEnd {

    /*
        get the books as result of search for books
        input:
            searchAttribute (Title , ISBN, Publisher, Author, Year, Category or Price)
            searchKey the input of user
        output:
            return 10 BOOK from matching books may be called many time so expect for same input will return
            another 10 BooK

            the main reason for that to minimize response time and do lazy load
            if anyOne have idea for better implementation tell mohamed ismail

            //add offset of search
            if 1 then return first ten
            if 2 the second ten and so on
     */
    public ArrayList<Book> getBooks(String searchAttribute, String searchKey, int offset);

    //public int getNumberOfResult(String SearchAttribute, String searchKey);

    /*
    insert new Book in book table all attributes need will be founded in Book Object
    Exceptions:
            error in any attribute
        should report the massage in exception of all wrong attribute
        expect well formatted massage to report it to user
    */
    public void insertBook(Book book) throws Exception;

    /*
        given the old book row and update it according to different attributes in new Book
        Exceptions:
            error in any new attribute
        should report the massage in exception of all wrong attribute
        expect well formatted massage to report it to user
    */

    public void updateBook(Book oldBook, Book newBook) throws Exception;

    /*
        insert new author
        Exceptions:
            repeated Author name
        should report the massage in exception
        expect well formatted massage to report it to user

    */

    public void insetAuthor(Author author) throws Exception;
    /*
        insert new Publisher
        Exceptions:
            repeated Publisher name
        should report the massage in exception
        expect well formatted massage to report it to user

    */
    public void insertPublisher(Publisher publisher) throws Exception;

    /*
    insert new user in user table all attributes need will be founded in User Object
    Exceptions:
            error in any attribute
        should report the massage in exception of all wrong attribute
        expect well formatted massage to report it to user
    */
    public void insertUser(User user) throws Exception;

    /*
        given the old user row and update it according to different attributes in new user
        Exceptions:
            error in any new attribute
        should report the massage in exception of all wrong attribute
        expect well formatted massage to report it to user
    */

    public void updateUser(User oldUser, User newUser) throws Exception;

    /*
        change role of user to manager
    */

    public void promoteUser(User user);

    /*
        return all users not managers have userName input as subName not the full name
    */

    public ArrayList<User> getUsers(String userName);

    /*
       insert New row in cart with userName and ISBN of BOOK and quantity 1
   */
    public void addToCart(String userName, String ISBN);
    /*
        return all Cart Items of given user
     */
    public ArrayList<CartItem> getCartContent(String userName);

    /*
    update Quantity for given user and book
     */

    public void updateCartItem(String userName, String ISBN,int newQuantity);
    /*
    remove cart item for given user and book
     */

    public void removeCartItem(String userName, String ISBN);

    /*
    do all sale operations
    insert new row in sales table
    clear the cart
    decrease book available quantities
     */
    public void addSale(String userName);

    /*
    insert order from manger
     */

    public void insertOrder(String ISBN, int quantity);
    /*
    remove the order and increase the book available quantities
     */

    public void confirmOrder(int id,String ISBN);

    /*
    check access of user
    return this user
    Exceptions:
            wrong user or wrong password
        should report the massage in exception of all wrong attribute
        expect well formatted massage to report it to user
     */

    /*
        return all orders of given book
    */
    public ArrayList<Order> getOrders(String ISBN);

    public User logIn(String UserName, String password) throws Exception;
    /*
    clear cart
     */

    public void logOut(String UserName);

    /*
    output pdf of the report details in project pdf
     */

    public void reportTotalSales();
    /*
   output pdf of the report details in project pdf
    */
    public void reportTopCustomers();

    /*
       output pdf of the report details in project pdf
     */
    public void reportTopSellingBooks();




}
