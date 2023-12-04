package vn.edu.bkacad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.println("** Program search list of students whose name contain value input **");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter value:");
        String a = sc.nextLine();
        while (a.length() == 0 || a.equals("")) {
            System.out.println("Please enter student name");
            System.out.println("Enter value:");
            a = sc.nextLine();
        }

        String URL = "jdbc:mysql://localhost:3306/programming_code_has_error";
        String USERNAME = "root";
        String PASSWORD = "";

        try {
            String str = "SELECT * FROM student WHERE full_name LIKE '%" + a + "%'";

            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(str);

            System.out.println("** List of students **");
            while (rs.next()) {
                String fullname = rs.getString("full_name");
                String studentcode = rs.getString("student_code");
                String address = rs.getString("address");
                Date birthday = rs.getDate("birthday");

                System.out.println("Full name: " + fullname);
                System.out.println("Student code: " + studentcode);
                System.out.println("Address: " + address);
                System.out.println("Birthday: " + birthday);

                System.out.println("");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
