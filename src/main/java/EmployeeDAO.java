import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

public class EmployeeDAO {
   private Connection connection;
   private PreparedStatement query;
   private ResultSet resultSet;


   EmployeeDAO() {
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","arbab123");
       } catch (Exception e) {
           System.out.println("Exception Occured in database " + e);
       }
   }

   public ArrayList<Employee> getAllEmployees(){
       ArrayList<Employee> employeeArrayList =  new ArrayList<>();
       try{
           query = connection.prepareStatement("SELECT * FROM Employee");
           resultSet = query.executeQuery();
           while(resultSet.next()){

            employeeArrayList.add( new Employee(resultSet.getString(2),resultSet.getString(3),resultSet.getString(5),resultSet.getString(4), resultSet.getInt(6),resultSet.getInt(1)));
               System.out.println(employeeArrayList.get(0));


           }

       }catch(Exception e){
           System.out.println("Error occurred in getting the employee from database "+e);
       }

       return employeeArrayList;
   }


public void addEmployeeToDB(Employee employee){
       try{

           query = connection.prepareStatement("INSERT INTO employee (firstName , email , JobTitle , Department,Salary) VALUES (?,?,?,?,?)");
           query.setString(1,employee.getName());
           query.setString(2,employee.getEmail());
           query.setString(3,employee.getJobTitle());
           query.setString(4,employee.getDepartment());
           query.setInt(5,employee.getSalary());
           query.executeUpdate();
           System.out.println("Employee has been added to the database");
       }catch (Exception e){
           System.out.println("Error Occurred in inserting employee into the database !! + "+e);
       }

}


public void deleteEmployee(int id){
       try{

        query = connection.prepareStatement("DELETE FROM employee WHERE employeeID = ?");
        query.setInt(1,id);
        query.executeUpdate();
        System.out.println("Employee has been deleted");
       }catch(Exception e){
           System.out.println("Error Occurred while deleting the employee : "+e);
       }
}


public void updateEmployee(int id ,Employee employee){
    try{

        query = connection.prepareStatement("UPDATE employee SET firstName = ? , email = ? , JobTitle = ? , Department = ? , Salary = ? WHERE employeeID = ?");
        query.setString(1,employee.getName());
        query.setString(2,employee.getEmail());
        query.setString(3,employee.getJobTitle());
        query.setString(4,employee.getDepartment());
        query.setInt(5,employee.getSalary());
        query.setInt(6,id);
        query.executeUpdate();
        System.out.println("Employee record has been updated");
    }catch (Exception e){
        System.out.println("Error Occurred in inserting employee into the database !! + "+e);
    }
}


public Employee getEmployeeById(int id){
    Employee employee = null;
       try{
        query = connection.prepareStatement("SELECT * FROM employee WHERE employeeID = ?");
        query.setInt(1,id);
        resultSet = query.executeQuery();
        resultSet.next();

           employee = new Employee(resultSet.getString(2),resultSet.getString(3),resultSet.getString(5),resultSet.getString(4), resultSet.getInt(6),resultSet.getInt(1));

    }catch(Exception e){
        System.out.println("Error occurred in getting the employee from database "+e);
    }

    return employee;
}



}
