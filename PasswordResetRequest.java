public class PasswordResetRequest extends AbstractSupportRequest {
	// Required variable
	private final String accountName;
	
	// Constructor
	public PasswordResetRequest(int id, String title, int basePoints, boolean resolved, String accountName) {
		// Calls super class
		super(id, title, basePoints, resolved);

		// Required validation
		if (accountName == null || accountName.isBlank()) {
			throw new IllegalArgumentException("Account Name cannot be blank");
		}
		
		// Assigning values to variables
		this.accountName = accountName;
	}
	
	// Resolve method for this class
	@Override
	public int resolveFor(Technician technician) {
		// Required validation
		if (technician == null) {
			throw new IllegalArgumentException("A technician must be put on before it can be resolved");
		}

		// Check if already resolved and finish out if it's not
		int points = getBasePoints();
		markResolved();
		technician.addPoints(points);
		return points;
	}

	// Getter
	public String getAccountName() {
		return accountName;
	}
}
