public interface SupportRequest {
	// Required methods
	int getId();
	String getTitle();
	int getBasePoints();
	boolean isResolved();
	int resolveFor(Technician technician);
}