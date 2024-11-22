import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberService {

    // Add a new member
    public void addMember(String name, String email) {
        String query = "INSERT INTO members (name, email) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
            System.out.println("Member added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View all members
    public void viewMembers() {
        String query = "SELECT * FROM members";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            System.out.println("Library Members:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("member_id") + ", Name: " + rs.getString("name") +
                        ", Email: " + rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
