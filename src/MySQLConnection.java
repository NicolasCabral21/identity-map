import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {

	private static MySQLConnection mySQLconnection;
	private static Connection con = null;

	MySQLConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/proyectoUngs";
		String user = "root";
		String pass = "Technisys2019";

		con = DriverManager.getConnection(url, user, pass);

		System.out.println("conexion exitosa:");
	}

	public static MySQLConnection createConnection() throws ClassNotFoundException, SQLException {
		if (mySQLconnection == null) {
			mySQLconnection = new MySQLConnection();
		} else {
			System.out.println("no se puede crear una conexion a BD porque ya existe una conexion");
		}
		return mySQLconnection;
	}

	public static void closeConnection() throws SQLException{
		if (mySQLconnection != null) {
			mySQLconnection = null;
			System.out.println("conexion cerrada");
		}
	}

	public static Person getPersonQuery(Integer key) throws SQLException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM person WHERE id=" + key);
		if (rs.next()) {
			int id = rs.getInt("id");
			int age = rs.getInt("age");
			int dni = rs.getInt("dni");
			String name = rs.getString("name");
			String lastName = rs.getString("lastname");

			rs.close();

			Person student = new Person(id, age, dni, name, lastName);

			return student;
		} else {
			System.out.println("Record not found");
			System.exit(1);
		}
		return null;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Creo una conexion, hago las consultas y si quiero crear otra conexion, no me deja xq ya existe una
//		MySQLConnection connection = MySQLConnection.createConnection();
//		System.out.println(connection.getPersonQuery(1));
//		System.out.println(connection.getPersonQuery(2));
//		connection.createConnection();
		
		// Creo una conexion, hago una consulta y la cierro. Despues si puedo volver a crear una conexion nueva
		// xq la anterior ya la borré
		MySQLConnection connection = MySQLConnection.createConnection();
		System.out.println(connection.getPersonQuery(1));
		connection.closeConnection();
		connection.createConnection();
		System.out.println(connection.getPersonQuery(2));
	}
}
