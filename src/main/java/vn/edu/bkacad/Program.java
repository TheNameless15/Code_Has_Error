import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Scanner;

public class Program {
    private static final String URL = "jdbc:mysql://localhost:3306/programming_code_has_error";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        System.out.println("** Program search list of students whose name contains the input value **");

        Scanner sc = new Scanner(System.in);
        String inputValue;

        do {
            System.out.println("Enter value:");
            inputValue = sc.nextLine().trim();
        } while (inputValue.isEmpty());

        String query = "SELECT * FROM student WHERE full_name LIKE ?";

        try (
                Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement st = con.prepareStatement(query);
        ) {
            st.setString(1, "%" + inputValue + "%");

            try (ResultSet rs = st.executeQuery()) {
                System.out.println("** List of students **");

                StringBuilder output = new StringBuilder();
                while (rs.next()) {
                    String fullname = rs.getString("full_name");
                    String studentcode = rs.getString("student_code");
                    String address = rs.getString("address");
                    Date birthday = rs.getDate("birthday");

                    output.append("Full name: ").append(fullname).append("\n");
                    output.append("Student code: ").append(studentcode).append("\n");
                    output.append("Address: ").append(address).append("\n");
                    output.append("Birthday: ").append(birthday).append("\n\n");
                }

                System.out.println(output.toString().trim());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
