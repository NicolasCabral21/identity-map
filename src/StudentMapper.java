import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentMapper {

	public static Student getStudent(int key) throws Exception, ClassNotFoundException, SQLException {

		Student student = IdentityMap.get(key);
		if (student != null) {
			System.out.println("Encontro al estudiante en el Map: "+student.toString());
			return student;
		} else {
			Student studentBD = findByIdBD(key);
			IdentityMap.add(studentBD);
			System.out.println("Encontro al estudiante en BD: "+studentBD.toString());
			return studentBD;
		}

	}
	
	public static void removeStudentById(int key) {
		IdentityMap.remove(key);
	}
	
	public static void clearStudents() {
		IdentityMap.clear();
	}

	private static Student findByIdBD(int key) throws Exception {
		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/proyectoUngs";
		String user = "root";
		String pass = "Technisys2019";
		con = DriverManager.getConnection(url, user, pass);
		System.out.println("conexion exitosa");
		Statement stmt = con.createStatement();

		// SELECT * FROM STUDENT BY ID
		ResultSet rs = stmt.executeQuery("SELECT * FROM student WHERE id="+key);
		if (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String lastName = rs.getString("lastname");
			String email = rs.getString("email");
			int age = rs.getInt("age");
//			System.out.format("%s, %s, %s, %s\n", id, name, lastName, age);

			rs.close();
			con.close();

			Student student = new Student(id, name, lastName, email, age);

			return student;
		} else {
			System.out.println("Record not found");
			System.exit(1);
		}
		return null;
	}
	
	public static List<Student> findAll() throws Exception {
		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/proyectoungs";
		String user = "root";
		con = DriverManager.getConnection(url, user, user);
		System.out.println("conexion exitosa");
		Statement stmt = con.createStatement();

		// SELECT * FROM STUDENT
		ResultSet rs = stmt.executeQuery("SELECT * FROM student");
		
		List<Student> students = new ArrayList<>();
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String lastName = rs.getString("lastname");
			String email = rs.getString("email");
			int age = rs.getInt("age");

			Student student = new Student(id, name, lastName, email, age);
			students.add(student);
		}
		rs.close();
		con.close();
		return students;
	}
}
