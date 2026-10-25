import java.util.Objects;

public class Technician {
    private final String name; //name isn't mutable
    private int servicePoints;

    //technician constructor; won't allow a null or blank name
    public Technician(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("You can't have a null or blank Technician name");
        }
        this.name = name.trim();
        this.servicePoints = 0;
    }

    //adds ServicePoints to the technician; it won't let you add negative points (subtract)
    public void addPoints(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("You can't subtract points");
        }
        this.servicePoints += amount;
    }

    //returns the technician's name field
    public String getName() {
        return name;
    }

    //getter for the technician's ServicePoints
    public int getServicePoints() {
        return servicePoints;
    }

    @Override //checks if the two technicians are from the same memory, then compares names
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Technician)) {
            return false;
        }
        Technician other = (Technician) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override //returns the hashcode of the technician's name
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override //returns the string representation of a technician
    public String toString() {
        return "Technician's Name: " + name + "\nTechnician's Service Points= " + servicePoints;
    }
}