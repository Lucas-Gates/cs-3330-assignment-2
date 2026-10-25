abstract class AbstractSupportRequest implements SupportRequest {
	private int id;
	private String title;
	private int basePoints;
	private boolean resolved;

	public AbstractSupportRequest(int id, String title, int basePoints, boolean resolved) {
		if (id <= 0) {
			throw new IllegalArgumentException("ID cannot be less than 1");
		}
		if (title == null || title.isBlank()) {
			throw new IllegalArgumentException("Title cannot be blank or null");
		}
		if (basePoints <= 0) {
			throw new IllegalArgumentException("Base Poitns cannot be less than 1");
		}
		
		this.id = id;
		this.title = title;
		this.basePoints = basePoints;
		this.resolved = resolved;
	}
	
	@Override
	public String toString() {
		return "Request ID: " + id
				+ ", Title: " + title
				+ ", Base Points:" + basePoints
				+ ", Resolved:" + resolved;
	}

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