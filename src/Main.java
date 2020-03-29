public class Main {
	public static void main(String[] args) throws Exception {

		StudentMapper pmap = new StudentMapper();

		// Jugando a buscar objeto de la BD o el MAP
		Person nicolas = pmap.getPerson(1);
		Person nicolasMap = pmap.getPerson(1);

		// elimina un objeto del mapa, y va a la base a buscarlo de vuelta
//		Person nicolas = pmap.getPerson(1);
//		Person nicolasMap = pmap.getPerson(1);
//		pmap.removeStudentById(1);
//		Person nicolasBD = pmap.getPerson(1);
		
		// me traigo a todas las personas
//		System.out.println(pmap.findAll());
		
		
	}
}