package baseball.domain.wrapper;

public class Location {

    private int location;

    private Location(int location) {
        if (isLocation(location)) {
            throw new IllegalArgumentException();
        }
        this.location = location;
    }

    private boolean isLocation(int location) {
        return location < 0 || location > 2;
    }

    public static Location from(int location) {
        return new Location(location);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Location)) {
            return false;
        }

        Location location1 = (Location) o;

        return location == location1.location;
    }

    @Override
    public int hashCode() {
        return location;
    }
}

