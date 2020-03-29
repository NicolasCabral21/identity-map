public class Main {
	public static void main(String[] args) throws Exception {

		StudentMapper pmap = new StudentMapper();

		// Jugando a buscar objeto de la BD o el MAP
		Student nicolas = pmap.getStudent(1);
		Student nicolasMap = pmap.getStudent(1);

		// elimina un objeto del mapa, y va a la base a buscarlo de vuelta
//		Student nicolas = pmap.getStudent(1);
//		Student nicolasMap = pmap.getStudent(1);
//		pmap.removeStudentById(1);
//		Student nicolasBD = pmap.getStudent(1);
		
		// me traigo a todas las personas
//		System.out.println(pmap.findAll());
		
		
	}
}