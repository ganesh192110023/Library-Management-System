import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookService {

    // Add a new book

    public void addBook(String title, String author, String genre) {
        String query = "INSERT INTO books (title, author, genre, is_available) VALUES (?, ?, ?, true)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setString(3, genre);
            pstmt.executeUpdate();
            System.out.println("Book added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View all books
    public void viewBooks() {
        String query = "SELECT * FROM books";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            System.out.println("Books Available in Library:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("book_id") + ", Title: " + rs.getString("title") +
                        ", Author: " + rs.getString("author") + ", Genre: " + rs.getString("genre") +
                        ", Available: " + rs.getBoolean("is_available"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
