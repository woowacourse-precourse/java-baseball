package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;

public class Game {
    private final int MAX_STRIKE = 3;
    private final int STRIKE = 1;
    private final int NOT_STRIKE = 0;
    private final int BALL = 1;
    private final int NOT_BALL = 0;
    private final String CORRECT_MESSAGE = "%d스트라이크\n%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    private final String NOTHING_MESSAGE = "낫싱\n";
    private final String BALL_STRIKE_MESSAGE = "%d볼 %d스트라이크\n";
    private final String BALL_MESSAGE = "%d볼\n";
    private final String STRIKE_MESSAGE = "%d스트라이크\n";
    private final String RESTART_STATUS = "1";
    private final String END_GAME_STATUS = "2";
    private final String RESTART_END_MESSAGE = "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.\n";

    private String[] computer;
    private String[] player;
    private int strike;
    private int ball;
    private boolean exit = false;

    public void start() {
        Player playerNumber = new Player();
        Computer computerNumber = new Computer();

        computerNumber.setRandomNumber();
        computer = computerNumber.getNumber();

        while (!exit) {
            playerNumber.setNumber();
            player = playerNumber.getNumber();

            strike = countStrike();
            ball = countBall();
            printCount();

            if (strike == MAX_STRIKE) {
                exit = isEndInput(computerNumber);
            }
        }
    }

    private int countStrike() {
        int count = 0;
        for (int i = 0; i < MAX_STRIKE; i++) {
            count += isStrike(computer[i], player[i]);
        }
        return count;
    }

    private int isStrike(String targetString, String inputString) {
        if (targetString.equals(inputString)) {
            return STRIKE;
        }
        return NOT_STRIKE;
    }

    private int countBall() {
        int count = 0;
        for (int i = 0; i < MAX_STRIKE; i++) {
            count += isBall(player[i]);
        }
        return count - strike;
    }

    private int isBall(String playerNumber) {
        if (Arrays.asList(computer).contains(playerNumber)) {
            return BALL;
        }
        return NOT_BALL;
    }

    private void printCount() {
        if (strike == MAX_STRIKE) {
            System.out.printf(CORRECT_MESSAGE, strike, MAX_STRIKE);
        } else if (strike == 0 && ball == 0) {
            System.out.print(NOTHING_MESSAGE);
        } else if (strike != 0 && ball != 0) {
            System.out.printf(BALL_STRIKE_MESSAGE, ball, strike);
        } else if (strike != 0) {
            System.out.printf(STRIKE_MESSAGE, strike);
        } else if (ball != 0) {
            System.out.printf(BALL_MESSAGE, ball);
        }
    }

    private boolean isEndInput(Computer computerNumber) {
        System.out.printf(RESTART_END_MESSAGE, RESTART_STATUS, END_GAME_STATUS);
        String input = readLine();
        isValidInput(input);

        if (RESTART_STATUS.equals(input)) {
            resetGame(computerNumber);
            return false;
        }
        return true; // input == END_GAME_STATUS
    }

    private void isValidInput(String input) {
        if (!END_GAME_STATUS.equals(input) && !RESTART_STATUS.equals(input)) {
            throw new IllegalArgumentException();
        }
    }

    private void resetGame(Computer computerNumber) {
        computerNumber.setRandomNumber();
        computer = computerNumber.getNumber();
    }
}
