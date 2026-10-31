/* 
author: Dilia Berrios
*/ 
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


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
		//add request to map by putting the request ID and the request itself in the hash map
		requestsById.put(request.getId(),request);
		
		}
	
	//find request returns the matching request or null if not found
	public SupportRequest findRequest(int id) {
		//return the request id using the requestsbyid map
		return requestsById.get(id);
		}
	
	// assignRequest links a technician to a request ID
	public void assignRequest(Technician technician, int requestId){
		//checks for technician first exists or not
		if (technician == null) {
			return;
		}
		SupportRequest request = findRequest(requestId);
			if (request == null) {
				throw new IllegalArgumentException("Id: " + requestId + " does not exist");
			}
		//technician cannot be assigned the same request number
			if (!assignments.containsKey(technician)){
				assignments.put(technician,new ArrayList<>());
			}
			//update list with technician requests 
			List<SupportRequest> technicianRequests = assignments.get(technician);
			//enforcing that technician cannot be assigned to the same request 
			if (technicianRequests.contains(request)) {
				return;
			}
			// add request to techs assignments
			technicianRequests.add(request);
	}
	
	// resolves a request 
	public int resolveRequest(Technician technician, int requestId) {
		//first checking params: if no technician input or assignment not found 
		if ( technician == null || !assignments.containsKey(technician)){
			return 0;
		}
		// making the list of support tickets that a technician has 
		List<SupportRequest> technicianRequests = assignments.get(technician);
		SupportRequest targetReq = null;
		
		//finds the request in the techs assignments, loops through the technician requests 
		for (SupportRequest req : technicianRequests){
			// check for the id given matches with an ID found in the technicians request list, name it targetReq
			if (req.getId() == requestId) {
				targetReq = req;
				break;
			}
		}

		//calls request once ID has been found/not null 
		if (targetReq != null) {
			//remove the targetReq from the technicians reports, return the int of points they have
			int points = targetReq.resolveFor(technician);
			// add points to techs score
			technician.addPoints(points);
			//remove assignment
			technicianRequests.remove(targetReq);
			
			return points;
		}
		return 0;

	}

	//printing methods
	
	//print all requests
	public void printAllRequests() {
		//check to see if empty first 
		if (requestsById.isEmpty()) {
			System.out.print("no requests");
			return;
		}
		// for each supportrequest request in the values of requestId
		for (SupportRequest req : requestsById.values()) {
            System.out.println(req);
            }
	}
	
	//printing assignments for a technician
	public void printAssignmentsFor(Technician technician) {
		//param checkings 
		if (technician == null) {
			return;
		}
		//making a list of support requests and polymorphically getting the assignments from a tech
		List<SupportRequest> r = assignments.get(technician);
		if ( r == null || r.isEmpty()) {
			System.out.print(" no assignments for this technician");
			return;
		}
		for (SupportRequest req : r) {
			System.out.println(req);
		}
		
	}
	
	//getter for get all requests (will be used in main)
	public List<SupportRequest> getAllReqs() {
	    return new ArrayList<SupportRequest>(requestsById.values());
	}

} 