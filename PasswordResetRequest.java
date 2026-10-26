public class PasswordResetRequest extends AbstractSupportRequest {
	private final String accountName;
	
	public PasswordResetRequest(int id, String title, int basePoints, boolean resolved, String accountName) {
		super(id, title, basePoints, resolved);
		if (accountName == null || accountName.isBlank()) {
			throw new IllegalArgumentException("Account Name cannot be blank");
		}
		this.accountName = accountName;
	}
	
	@Override
	public int resolveFor(Technician technician) {
		if (technician == null) {
			throw new IllegalArgumentException("A technician must be put on before it can be resolved");
		}
		int points = getBasePoints();
		markResolved();
		technician.addPoints(points);
		return points;
	}
}
