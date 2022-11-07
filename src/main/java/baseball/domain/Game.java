package baseball.domain;

public class Game {
    private Computer computer;
    private User user;
    private int strike;
    private int ball;
    private int digit;
    private int startRange;
    private int endRange;

    public Game(int digit, int startRange, int endRange) {
        this.computer = null;
        this.user = null;
        this.digit = digit;
        this.startRange = startRange;
        this.endRange = endRange;
    }

    public void pickComputerNum() {
        this.computer = new Computer(this);
    }

    public void pickUserNum() throws IllegalArgumentException {
        this.user.pickUserNum(this);
    }

    public void initTurn() {
        this.user = new User();
        this.strike = 0;
        this.ball = 0;
    }

    public Computer getComputer() {
        return computer;
    }

    public User getUser() {
        return user;
    }

    public int getDigit() {
        return digit;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStartRange() {
        return startRange;
    }

    public int getEndRange() {
        return endRange;
    }

    public void plusStrike() {
        this.strike++;
    }

    public void plusBall() {
        this.ball++;
    }
}
