package baseball.domain;

public class Game {

    private int strike;
    private int ball;
    private boolean status;

    User user;
    Computer computer;

    public Game() {
        this.user = new User();
        this.computer = new Computer();
        this.status = true;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }


}
