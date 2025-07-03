import java.sql.*;
import java.util.Scanner;

public class EmployeeDBApp {
    static final String URL = "jdbc:mysql://localhost:3306/Employee_db";
    static final String USER = "root";          // your MySQL username
    static final String PASSWORD = "Bhanu@2003";  // your MySQL password

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("✅ Connected to database.");

            int choice;
            do {
                System.out.println("\n📋 Employee DB Menu");
                System.out.println("1. Add Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine(); // flush newline

                switch (choice) {
                    case 1 -> addEmployee(conn);
                    case 2 -> viewEmployees(conn);
                    case 3 -> updateEmployee(conn);
                    case 4 -> deleteEmployee(conn);
                    case 5 -> System.out.println("👋 Exiting...");
                    default -> System.out.println("❌ Invalid option.");
                }
            } while (choice != 5);

        } catch (SQLException e) {
            System.out.println("❌ DB Error: " + e.getMessage());
        }
    }

    private static void addEmployee(Connection conn) throws SQLException {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter designation: ");
        String des = sc.nextLine();
        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        String sql = "INSERT INTO employees (name, designation, salary) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, des);
            ps.setDouble(3, salary);
            ps.executeUpdate();
            System.out.println("✅ Employee added.");
        }
    }

    private static void viewEmployees(Connection conn) throws SQLException {
        String sql = "SELECT * FROM employees";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("📄 Employee Records:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Designation: " + rs.getString("designation") +
                        ", Salary: ₹" + rs.getDouble("salary"));
            }
        }
    }

    private static void updateEmployee(Connection conn) throws SQLException {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new name: ");
        String name = sc.nextLine();
        System.out.print("Enter new designation: ");
        String des = sc.nextLine();
        System.out.print("Enter new salary: ");
        double salary = sc.nextDouble();

        String sql = "UPDATE employees SET name=?, designation=?, salary=? WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, des);
            ps.setDouble(3, salary);
            ps.setInt(4, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "✅ Employee updated." : "❌ ID not found.");
        }
    }

    private static void deleteEmployee(Connection conn) throws SQLException {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM employees WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "✅ Employee deleted." : "❌ ID not found.");
        }
    }
}

