/* 
author: Dilia Berrios
• Do not expose internal collections directly.
• Avoid long message chains and knowledge leaks.
• The help desk should not perform type checking such as if (request instanceof DeviceSetupRequest).
• Request-specific behavior belongs in the request classes, not in HelpDesk.
• Keep HelpDesk focused on coordination rather than turning it into a god class.
*/ 

public class HelpDesk { 
	
	// required fields, hash map of varible int and technician
	//  given integer, pulls up the support request 
	Map <Integer, Support Request> requestsById;
	//given the technician, pulls up a list of support requests in their name 
	Map <Technician, List<SupportRequests>> assignments; 
	
	
	//required class behavior
	
	// constructor to initialize the hash map
	public class HelpDesk() {
		this.requestsByID = new HashMap<>();
		this.assignments = new HashMap<>();
		
	}
	
	
	//reset id class
	public void addRequest(SupportRequest request) {
		// throw exception when null statements are entered
		if (request == null) {
			throw IllegalArgumentException;
			}
		//reset duplicate request IDs by throwing exception 
		if (request.
		}
	
	//find request returns the matching request or null if not found
	public void SupportRequest findRequest(int id) {
		//checking if exists first
		if (SupportRequest.id)
		}
	
	
	
	/*finds the request in that technician’s assignments
	alls request.resolveFor(technician) polymorphically
	returns the service points awarded
	*/
	// assignRequest links a technician to a request ID
	public void assignRequest(Technician technician, int requestId){
	}
	
	// resolves a request 
	public int resolveRequest(Technician technician, int requestId) {
		

		
	}

	//printing methods
	
	//print all requests
	public void printAllRequests() {
		
	}
	
	//printing
	public void printAssignmentsFor(Technician technician) {
		
	}

} 