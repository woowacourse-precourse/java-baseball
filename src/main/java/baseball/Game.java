package baseball;

import java.util.List;
import java.util.Objects;

public class Game {

    private final Computer computer = new Computer();
    private final User user;
    private List<Integer> computerNumberList;
    private List<Integer> userNumberList;
    private int strike;
    private int ball;
    boolean keepGame;

    Game() {
        user = new User();
    }

    void inputGameData() {
        user.inputGameNumber();
        user.numberToList(user.userNumber);
        this.computerNumberList = computer.computerNumberList;
        this.userNumberList = user.userNumberList;
    }

    private void checkStrike() {
        strike = 0;
        for (int index = 0; index < 3; index++) {
            if (Objects.equals(computerNumberList.get(index), userNumberList.get(index))) {
                strike++;
            }
        }
    }

    int getStrike() {
        return strike;
    }

    private void checkBall() {
        ball = 0;
        for (int index = 0; index < 3; index++) {
            if (computerNumberList.contains(userNumberList.get(index))) {
                ball++;
            }
        }
        ball -= strike;
    }

    int getBall() {
        return ball;
    }

    void checkStrikeAndBall() {
        checkStrike();
        checkBall();
    }

    boolean gameOngoing() {
        return strike != 3;
    }

    void inputEndProgramData() {
        user.inputEndNumber();
        this.keepGame = user.keepGame;
    }
}