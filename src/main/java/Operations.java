import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Operations {
	public int insert(Employee e) throws ClassNotFoundException {
		int r=0;
		Class.forName("com.mysql.jdbc.Driver");
		try(Connection ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","bhanuteja")){
		String	stm = "insert into emp(name,salary) values (?,?)";
		PreparedStatement ps = ct.prepareStatement(stm);
		ps.setString(1, e.getName());
		ps.setString(2, e.getSalary());
		r = ps.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return r;
	}
	public int update(Employee e) throws ClassNotFoundException {
		int r=0;
		Class.forName("com.mysql.jdbc.Driver");
		try(Connection ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","bhanuteja")){
		String	stm = "update emp set salary=? where name=?";
		PreparedStatement ps = ct.prepareStatement(stm);
		ps.setString(1, e.getSalary());
		ps.setString(2, e.getName());
		r = ps.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return r;
	}
	public int delete(String n) throws ClassNotFoundException {
		int r=0;
		Class.forName("com.mysql.jdbc.Driver");
		try(Connection ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","bhanuteja")){
		String	stm = "delete from emp where name=?";
		PreparedStatement ps = ct.prepareStatement(stm);
		ps.setString(1, n);
		
		r = ps.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return r;
	}
}
