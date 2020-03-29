import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {

	static Connection con = null;
	
	public MySQLConnection() throws ClassNotFoundException, SQLException{
		createConnection();
	}

	public void createConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/proyectoUngs";
		String user = "root";
		String pass = "Technisys2019";

		con = DriverManager.getConnection(url, user, pass);

		System.out.println("conexion exitosa:");
	}
	
	public void closeConnection() throws SQLException{
		con.close();
		System.out.println("conexion cerrada");
	}

	public Person getPersonQuery(Integer key) throws SQLException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM person WHERE id=" + key);
		if (rs.next()) {
			int id = rs.getInt("id");
			int age = rs.getInt("age");
			int dni = rs.getInt("dni");
			String name = rs.getString("name");
			String lastName = rs.getString("lastname");

			rs.close();
			con.close();

			Person student = new Person(id, age, dni, name, lastName);

			return student;
		} else {
			System.out.println("Record not found");
			System.exit(1);
		}
		return null;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MySQLConnection myConnection = new MySQLConnection();
		System.out.println(myConnection.getPersonQuery(1));
		myConnection.closeConnection();
	}
}
