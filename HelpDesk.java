/* 
author: Dilia Berrios
keep fields private.
• Do not expose internal collections directly.
• Avoid long message chains and knowledge leaks.
• The help desk should not perform type checking such as if (request instanceof DeviceSetupRequest).
• Request-specific behavior belongs in the request classes, not in HelpDesk.
• Keep HelpDesk focused on coordination rather than turning it into a god class.
*/ 

Map <Integer, Support Request> requestsByID;
Map <Technician, List<SupportRequests>> assignments; 

addRequest(SupportRequest request){
	//reset duplicate request IDs by:
	throw IllegalArgumentException;
}
SupportRequest findRequest(int id) {
	//returns the mactching request / null if not found
}
assignRequest(Technician technician, int requestId){
	/*finds the request in that technician’s assignments
	alls request.resolveFor(technician) polymorphically
	returns the service points awarded
	*/
}

void printAllRequests() {}
void printAssignmentsFor(Technician technician)