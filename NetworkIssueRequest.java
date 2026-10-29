public class NetworkIssueRequest extends AbstractSupportRequest {
    private final int affectedUsers;

    public NetworkIssueRequest(int id, String title, int basePoints, int affectedUsers) {
        super(id, title, basePoints);
        if (affectedUsers <= 0) { //can't have negative amount of users (fail fast)
            throw new IllegalArgumentException("You can't have a negative number of affected users.");
        }
        this.affectedUsers = affectedUsers;
    }

    //getter for affectedUsers
    public int getAffectedUsers() {
        return affectedUsers;
    }

    @Override
    public int resolveFor(Technician technician) {
        if (isResolved()) {
            throw new IllegalStateException("This request is already done.");
        }

        //decided to use the weighted rule: basePoints + (affectedUsers * 2)
        int pointsAwarded = getBasePoints() + (affectedUsers * 2);
        setResolved(true);
        technician.addPoints(pointsAwarded);
        return pointsAwarded;
    }
}