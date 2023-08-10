//Employee Class:

public class Employee {
    private int id;
    private String name;
    private String department;
    private int skillLevel;

    public Employee(int id, String name, String department, int skillLevel) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.skillLevel = skillLevel;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", skillLevel=" + skillLevel + "]";
    }
}

//EmployeeSkillLadderApp Class:

import java.util.List;

public class EmployeeSkillLadderApp {
    public static void main(String[] args) {
        DatabaseConnector connector = new DatabaseConnector();

        List<Employee> employees = connector.getEmployees();

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

//DatabaseConnector Class:

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnector {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/deepakdb";
    private static final String JDBC_USER = "deepakuser";
    private static final String JDBC_PASSWORD = "deepakpass";

    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employees");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Employee employee = new Employee(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("department"),
                    resultSet.getInt("skillLevel")
                );
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }
}

//Employee Objects in EmployeeSkillLadderApp Class:

import java.util.ArrayList;
import java.util.List;

public class EmployeeSkillLadderApp {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John Doe", "IT", 3));
        employees.add(new Employee(2, "Jane Smith", "HR", 2));
        employees.add(new Employee(3, "Michael Johnson", "Finance", 4));
        
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
