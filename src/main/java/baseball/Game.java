package baseball;

public class Game {
    private final int CNT_NUMBER = 3;
    private final int STRIKE = 1;
    private final int NOT_STRIKE = 0;
    private final int BALL = 1;
    private final int NOT_BALL = 0;
    private String computer;
    private String player;
    private int strike;
    private int ball;

    public Game() {
    }

    public void start() {
        Number playerNumber = new Number();
        Number computerNumber = new Number();

        computerNumber.setRandomNumber();
        playerNumber.setNumber();

        computer = computerNumber.getNumber();
        player = playerNumber.getNumber();

        strike = countStrike();
        ball = countBall();
    }

    private int countStrike() {
        int count = 0;
        for (int i = 0; i < CNT_NUMBER; i++) {
            count += isStrike(computer.charAt(i), player.charAt(i));
        }
        return count;
    }

    private int isStrike(Character targetChar, Character inputChar) {
        if (targetChar == inputChar) {
            return STRIKE;
        }
        return NOT_STRIKE;
    }

    private int countBall() {
        int count = 0;
        for (int i = 0; i < CNT_NUMBER; i++) {
            count += isBall(player.charAt(i));
        }
        return count - strike;
    }

    private int isBall(Character playerChar) {
        if (computer.indexOf(playerChar) == -1) {
            return NOT_BALL;
        }
        return BALL;
    }
}
