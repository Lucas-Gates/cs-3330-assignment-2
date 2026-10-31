public class DeviceSetupRequest extends AbstractSupportRequest {
    private final int deviceCount;

    public DeviceSetupRequest(int id, String title, int basePoints, int deviceCount, boolean resolved) {
        super(id, title, basePoints, resolved);

        if (deviceCount <= 0) { //can't have non positive devices (fail fast)
            throw new IllegalArgumentException("You can't have negative or zero devices.");
        }
        this.deviceCount = deviceCount;
    }

    //getter for deviceCount
    public int getDeviceCount() {
        return deviceCount;
    }

    @Override
    public int resolveFor(Technician technician) {
        if (technician == null) {
            throw new IllegalArgumentException("Technician cannot be null.");
        }
        if (isResolved()) {
            throw new IllegalStateException("This request is already done.");
        }
        //awarded service points = basePoints * deviceCount
        int pointsAwarded = getBasePoints() * this.deviceCount;
        markResolved();
        technician.addPoints(pointsAwarded);
        return pointsAwarded;
    }
}