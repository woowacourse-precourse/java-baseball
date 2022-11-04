package baseball.domain;

import baseball.domain.wrapper.BallNumber;
import baseball.domain.wrapper.Location;

public class Ball {

    private BallNumber ballNumber;
    private Location location;

    private Ball(int givenBallNumber, int givenLocation) {
        ballNumber = BallNumber.from(givenBallNumber);
        location = Location.from(givenLocation);
    }

    public static Ball of(int givenBallNumber, int givenLocation) {
        return new Ball(givenBallNumber, givenLocation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ball)) {
            return false;
        }

        Ball ball = (Ball) o;

        if (ballNumber != null ? !ballNumber.equals(ball.ballNumber) : ball.ballNumber != null) {
            return false;
        }
        return location != null ? location.equals(ball.location) : ball.location == null;
    }

    @Override
    public int hashCode() {
        int result = ballNumber != null ? ballNumber.hashCode() : 0;
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }
}
