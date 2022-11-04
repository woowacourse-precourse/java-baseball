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
        return location < 0 || location > 3;
    }

    public static Location from(int location) {
        return new Location(location);
    }
}

