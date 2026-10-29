/* 
author: Dilia Berrios
• Do not expose internal collections directly.
• Avoid long message chains and knowledge leaks.
• The help desk should not perform type checking such as if (request instanceof DeviceSetupRequest).
• Request-specific behavior belongs in the request classes, not in HelpDesk.
• Keep HelpDesk focused on coordination rather than turning it into a god class.
*/ 
import java.util.Map;
import java.util.HashMap;
import java.util.List;


public class HelpDesk { 
	
	// required fields, hash map of variable int and technician, made private
	//  given integer, pulls up the support request 
	private Map<Integer, SupportRequest> requestsById;
	//given the technician, pulls up a list of support requests in their name 
	private Map<Technician, List<SupportRequest>> assignments; 
	
	
	//required class behaviors
	
	// constructor to initialize the hash map
	public HelpDesk() {
		this.requestsById = new HashMap<>();
		this.assignments = new HashMap<>();
		
	}
	
	//reset id class
	public void addRequest(SupportRequest request) {
		// throw exception when null statements are entered
		if (request == null) {
			throw new IllegalArgumentException("field cannot be left blank");
			}
		//reset duplicate request IDs by throwing exception 
		if (requestsById.containsKey(request.getId())){
			throw new IllegalArgumentException("duplicate ID");
			}
		}
	
	//find request returns the matching request or null if not found
	public void SupportRequest findRequest(int id) {
		//return the request id using the requestsbyid map
		return requestsById.get(id);
		}
	
	// assignRequest links a technician to a request ID
	public void assignRequest(Technician technician, int requestId){
		//checks for technician first 
		if (technician == null) {
			return;
		}
		SupportRequest request = findRequest(requestId);
			if (request == null) {
				throw new IllegalArgumentException("Id" + requestId + " does not exist");
			}
		//technician cannot be assigned the same request number
			if (technicianRequest.contains(request)) {
				return;
			}
			
	}
	
	// resolves a request 
	public int resolveRequest(Technician technician, int requestId) {
		//first checking params, if no technician input or assignment not found 
		if ( technician == null || !assignments.containsKey(technician)){
			return 0;
		}
		//finds the request in the techs assignments
		
		//calls request
		
		
		//returns points awarded
		

		
	}

	//printing methods
	
	//print all requests
	public void printAllRequests() {
		//check to see if empty first 
		if (requestById.isEmpty()) {
			System.out.print("no requests");
		}
		// for each supportrequest request in the values of requestId
		for (SupportRequest req : requestsById.values()) {
            System.out.println(req);
            }
	}
	
	//printing
	public void printAssignmentsFor(Technician technician) {
		
	}

} 