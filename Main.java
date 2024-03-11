package org.example;
import org.example.models.Book;
import org.example.models.Order;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static final String BOOK_TABLE = "Book";
    public static final String BOOK_ID = "id";
    public static final String BOOK_NAME = "name";
    public static final String BOOK_PRICE = "price";

    public static void main(String[] args) {


        Book b1 = new Book("AGGGTM",1, 800);
        Book b2 = new Book("Evelyn Hugo",2, 1299);

        String url = "jdbc:sqlite:book.db";

        String createTableSQL = "CREATE TABLE IF NOT EXISTS " + BOOK_TABLE + "(id integer PRIMARY KEY NOT NULL," +
                "name text," +
                "price integer);";

        System.out.println(createTableSQL);

        String insertRecordSQL = "INSERT INTO " + BOOK_TABLE + "(name, price) values(?,?)";
        System.out.println(insertRecordSQL);

        String selectData = "SELECT * FROM " + BOOK_TABLE;

        System.out.println(selectData);
        try {

            Connection c = DriverManager.getConnection(url);
            System.out.println("Connected");

            Statement stm = c.createStatement();
            stm.execute(createTableSQL);


            PreparedStatement preparedStatement = c.prepareStatement(insertRecordSQL);
            preparedStatement.setString(1, b1.getName());
            preparedStatement.setInt(2, b1.getPrice());

            preparedStatement.setString(1, b2.getName());
            preparedStatement.setInt(2, b2.getPrice());



            preparedStatement.execute();
            System.out.println("Insert Created");
            List<Book> bookList = new ArrayList<>();
            ResultSet rs = stm.executeQuery(selectData);
            while (rs.next()) {
                int id = rs.getInt(BOOK_ID);
                String name = rs.getString(BOOK_NAME);
                int price = rs.getInt(BOOK_PRICE);

                bookList.add(b1);
                bookList.add(b2);

            }

            c.close();
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }


    }
}