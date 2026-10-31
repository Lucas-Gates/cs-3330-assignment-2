/* author: Dilia Berrios
utility class
*/
import java.util.List; 


public class HelpDeskUtil{
	//Requirement: generic method, print each item on its own line using toString()
	public static <T> void printAll(List<T> items){
		// checking params 
		if ( items == null) {
			return;
		}
		//looping through the list of items type T
		for (T item : items) {
			System.out.println(item);
		}
		
	}
	
	
	// Requirement: wildcard method, returns total service points across all technicians 
	public static int sumPoints(List<? extends Technician> technicians) {
		//param checkings 
		if ( technicians == null) {
			return 0;
		}
		int total = 0;
		// loop through list of technicians and get their total point count by adding their service points 
		for (Technician tech : technicians) {
			total += tech.getServicePoints();
		}
		return total;
		
	}
}