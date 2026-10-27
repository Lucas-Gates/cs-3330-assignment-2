public abstract class AbstractSupportRequest implements SupportRequest {
	// Required variables
	private int id;
	private String title;
	private int basePoints;
	private boolean resolved;

	// Constructor
	public AbstractSupportRequest(int id, String title, int basePoints, boolean resolved) {
		// Required validation
		if (id <= 0) {
			throw new IllegalArgumentException("ID cannot be less than 1");
		}
		if (title == null || title.isBlank()) {
			throw new IllegalArgumentException("Title cannot be blank or null");
		}
		if (basePoints <= 0) {
			throw new IllegalArgumentException("Base Poitns cannot be less than 1");
		}
		
		// Assigning values to variables
		this.id = id;
		this.title = title;
		this.basePoints = basePoints;
		this.resolved = resolved;
	}
	
	// To string method
	@Override
	public String toString() {
		return "Request ID: " + id
				+ ", Title: " + title
				+ ", Base Points:" + basePoints
				+ ", Resolved:" + resolved;
	}

	// Getters
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public int getBasePoints() {
		return basePoints;
	}

	public boolean isResolved() {
		return resolved;
	}
	
	// Methods to check resolved
	protected void checkNotResolved() {
		if(resolved) {
			throw new IllegalStateException("Request is already resolved");
		}
	}
	
	protected void markResolved() {
		checkNotResolved();
		resolved = true;
	}
}