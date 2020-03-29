import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentMapper {

	public static Person getPerson(int key) throws Exception, ClassNotFoundException, SQLException {

		Person person = IdentityMap.get(key);
		if (person != null) {
			System.out.println("Encontro al estudiante en el Map: " + person.toString());
			return person;
		} else {
			Person personBD = findByIdBD(key);
			IdentityMap.add(personBD);
			System.out.println("Encontro al estudiante en BD: " + personBD.toString());
			return personBD;
		}

	}

	public static void removeStudentById(int key) {
		IdentityMap.remove(key);
	}

	public static void clearPersons() {
		IdentityMap.clear();
	}

	private static Person findByIdBD(int key) throws Exception {
		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/proyectoUngs";
		String user = "root";
		String pass = "Technisys2019";
		con = DriverManager.getConnection(url, user, pass);
		System.out.println("conexion exitosa:");
		Statement stmt = con.createStatement();

		// SELECT * FROM PERSON BY ID
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

	public static List<Person> findAll() throws Exception {
		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/proyectoUngs";
		String user = "root";
		String pass = "Technisys2019";
		con = DriverManager.getConnection(url, user, pass);
		System.out.println("conexion exitosa:");
		Statement stmt = con.createStatement();

		// SELECT * FROM PERSON
		ResultSet rs = stmt.executeQuery("SELECT * FROM person");

		List<Person> students = new ArrayList<>();
		while (rs.next()) {
			int id = rs.getInt("id");
			int age = rs.getInt("age");
			int dni = rs.getInt("dni");
			String name = rs.getString("name");
			String lastName = rs.getString("lastname");

			Person student = new Person(id, age, dni, name, lastName);
			students.add(student);
		}
		rs.close();
		con.close();
		return students;
	}
}
