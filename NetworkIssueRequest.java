public class NetworkIssueRequest extends AbstractSupportRequest {
    private final int affectedUsers;

    public NetworkIssueRequest(int id, String title, int basePoints, int affectedUsers, boolean resolved) {
        super(id, title, basePoints, resolved);
        if (affectedUsers <= 0) { //can't have negative (or zero) amount of users (fail fast)
            throw new IllegalArgumentException("You can't have negative or zero affected users.");
        }
        this.affectedUsers = affectedUsers;
    }

    //getter for affectedUsers
    public int getAffectedUsers() {
        return affectedUsers;
    }

    @Override
    public int resolveFor(Technician technician) {
        if (technician == null) {
            throw new IllegalArgumentException("Technician cannot be null.");
        }
        if (isResolved()) {
            throw new IllegalStateException("This request is already done.");
        }

        //decided to use the weighted rule: basePoints + (affectedUsers * 2)
        int pointsAwarded = getBasePoints() + (affectedUsers * 2);
        markResolved(true);
        technician.addPoints(pointsAwarded);
        return pointsAwarded;
    }
}