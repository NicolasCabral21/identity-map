import java.util.Map;
import java.util.HashMap;

public class IdentityMap {
	
	private static Map<Integer, Person> hash = new HashMap<Integer, Person>();

	public static Person get(int key) throws Exception {
		Person person = hash.get(key);
		return person;
	}

	public static void add(Person person) {
		hash.put(person.getId(), person);
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