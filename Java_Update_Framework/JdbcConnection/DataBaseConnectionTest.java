package JdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataBaseConnectionTest {

   private static Connection connection;
   private static Statement statement;
   private static ResultSet rs;

    @BeforeClass
    public static void setUp() {
            String databaseURL = "jdbc:mysql://localhost:3306/employee";
            String user = "root";
            String password = "password";
            connection = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Connecting to Database...");
                connection = DriverManager.getConnection(databaseURL, user, password);
                if (connection != null) {
                    System.out.println("Connected to the Database...");
                }
                else {
                	System.out.println("NOT Connected to the Database...");
                }
            } catch (SQLException ex) {
            	   
               ex.printStackTrace();
            }
            catch (ClassNotFoundException ex) {
               ex.printStackTrace();
            }
    }

    @Test
    public void getEmployeesFromDataBase() {
        try {
            
        	String query = "select * from employee";
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while(rs.next()){
                int EmpId = rs.getInt("id");
                String EmpfName = rs.getString("first_name");
                String EmplName = rs.getString("last_name");
                int EmpSal = rs.getInt(5);

//                String EmpAddress=rs.getString(3);
//                String EmpDept=rs.getString("EmpDept");
               // System.out.println(EmpId+"\t"+EmpName+"\t"+EmpAddress+"\t"+EmpSal+"\t"+EmpDept);
                System.out.println(EmpId+"\t"+EmpfName+" "+EmplName+"\t"+EmpSal+"\t");
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }

    @Test
    public void getEmployeeIdFromDataBase() {
        try {
            String query = "select employee.id from employee";
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while(rs.next()){
                int EmpId= rs.getInt("id");
                
                System.out.println("EmpId: " + EmpId);
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }

    
    @Test
    public void getEmployeeNameFromDataBase() {
        try {
            String query = "select employee.name from employee";
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while(rs.next()){
                String EmpfName= rs.getString("first_name");
                String EmplName= rs.getString("last_name");
                System.out.println("Emp Name: " + EmpfName+" "+EmplName);
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }

    @Test
    public void getEmployeeSalaryFromDataBase() {
        try {
            String query = "select employee.salary from employee";
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while(rs.next()){
                int EmpSal= rs.getInt(5);
                System.out.println("Emp Salary: " +EmpSal);
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDown() {
      if (connection != null) {
                try {
                    System.out.println("Closing Database Connection...");
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
      }
}
