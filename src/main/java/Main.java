import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		
		
		//creating a help desk
		HelpDesk helpDesk = new HelpDesk();
		
		
		//create at least 3 technicians ( 2 with the same name) 
		Technician dilia = new Technician("Dilia");
		Technician abby =  new Technician("abby");
		Technician fabby = new Technician("abby");
		//adding techs to the tech list  'fabby' should reject bcs its the same name
		HashSet<Technician> techs = new HashSet<>();
		techs.add(dilia);
		techs.add(abby);
		techs.add(fabby);
		
		
		// create at least 6 support requests, 2 of each required type ( network, password, devicesetup)
		// NetworkIssueRequest(int id, String title, int basePoints, int affectedUsers)
		SupportRequest request1 = new NetworkIssueRequest(1, "Network issue 1" , 5 , 25);
		SupportRequest request2 = new NetworkIssueRequest(2, "Network issue 2" , 5 , 30);
				
		//DeviceSetupRequest(int id, String title, int basePoints, int deviceCount)
		SupportRequest request3 = new DeviceSetupRequest(3, "Device setup request 1" , 10, 15);
		SupportRequest request4 = new DeviceSetupRequest(4, "Device setup request 2" , 10, 10);
		
		//PasswordResetRequest(int id, String title, int basePoints, boolean resolved, String accountName)
		SupportRequest request5 = new PasswordResetRequest(5, "Password reset request 1", 5, true, "fabborris");
		SupportRequest request6 = new PasswordResetRequest(6, "Password reset request 2",5 , false, "slailab");
		
		
		// add requests to help desk 
		//addRequest(SupportRequest request)
		helpDesk.addRequest(request1);
		helpDesk.addRequest(request2);
		helpDesk.addRequest(request3);
		helpDesk.addRequest(request4);
		helpDesk.addRequest(request5);
		helpDesk.addRequest(request6);
		
		
		//assign 4 requests to at least 2 technicians  ( to help desk) 
		//assignRequest(Technician technician, int requestId){
		helpDesk.assignRequest(dilia, 1);
		helpDesk.assignRequest(fabby, 2);
		helpDesk.assignRequest(dilia, 3);
		helpDesk.assignRequest(abby, 4);
		
		//resolve at least 3 requests from differnt request types 
		//resolveRequest(Technician technician, int requestId)
		helpDesk.resolveRequest(fabby,1) ;
		helpDesk.resolveRequest(dilia,1) ;
		helpDesk.resolveRequest(abby,4) ;
		
		// print all requests , using helpdeskutil
		HelpDeskUtil.printAll(helpDesk.getAllReqs());
		
		// print assignments for each technician
		System.out.print("Dilia's assignments:");
		helpDesk.printAssignmentsFor(dilia);
		System.out.print("Abby's assignments:");
		helpDesk.printAssignmentsFor(abby);
		System.out.print("Fabby's assignments:");
		helpDesk.printAssignmentsFor(fabby);
		
		//print final technician service point totals
		System.out.println(dilia.getName() + ": " + dilia.getServicePoints() + " points");
		System.out.println(abby.getName() + ": " + abby.getServicePoints() + " points");
		System.out.println(fabby.getName() + ": " + fabby.getServicePoints() + " points");
		
		
		// print the total service points across technicians (using helpDeskutil)
		//making overal points a varible so it doesnt get too smelly up in here 
		List<Technician> technicianList = new ArrayList<>(techs);
		int totalpoints = HelpDeskUtil.sumPoints(technicianList);
		System.out.println("Total service points across technicians: " + totalpoints);
		
		//failfast req, thowing an exception
		System.out.println("failfast requirement");
		//reset duplicate request IDs by throwing exception 
		try {
			helpDesk.addRequest(new NetworkIssueRequest(1, "duplicate issue 1" , 5 , 25));
		} catch (IllegalArgumentException excep) {
			System.out.println(" exception caught ");
		}
		
		
	}
}