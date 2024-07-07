import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAO {
    private Connection connection;
    private PreparedStatement query;
    private ResultSet resultSet;

    AdminDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","arbab123");
        } catch (Exception e) {
            System.out.println("Exception Occured in database " + e);
        }
    }


    public boolean searchForAdmin(String username,String password){
        try{
            query = connection.prepareStatement("SELECT * FROM HR WHERE username = ? AND password= ?");
            query.setString(1, username);
            query.setString(2, password);
            resultSet= query.executeQuery();
            return resultSet.next();
//            if(resultSet.next()) {
//                System.out.println();
//                return true;
//            }
        }   catch (Exception e){
            System.out.println(e);
        }

        return false;
    }

    public void registerAdmin(Admin admin){
            try{
                query = connection.prepareStatement("INSERT INTO HR VALUES (?,?,?,?);");
                query.setString(1, admin.getUsername());
                query.setString(2, admin.getPassword());
                query.setString(3, admin.getDepartment());
                query.setString(4, admin.getDesignation());
                query.executeUpdate();
                System.out.println("ADMIN HAS BEEN REGISTERED ");
            }   catch (Exception e){
                System.out.println(e);
            }
    }
}
