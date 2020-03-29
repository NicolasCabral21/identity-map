public class Student {
	private int id;
	private String name;
	private String lastName;
	private String email;
	private int age;

	public Student(int id, String name, String lastName, String email, int age) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
	}

	public String toString() {
		return "name: " + this.name + " - "+ "last name: "+this.lastName+" - "+"email: "+email+" - "+"age: "+this.age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}