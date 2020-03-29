import java.util.Map;
import java.util.HashMap;

public class IdentityMap {
	
	private static Map<Integer, Student> hash = new HashMap<Integer, Student>();

	public static Student get(int key) throws Exception {
		Student student = hash.get(key);
		return student;
	}

	public static void add(Student student) {
		hash.put(new Integer(student.getId()), student);
	}
	
	public static void remove(int key) {
		hash.remove(key);
		System.out.println("objeto con ID:"+key+" borrado del map");
	}
	
	public static void clear() {
		hash.clear();
		System.out.println("objetos del map borrados");
	}
}