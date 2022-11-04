package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private final int CNT_NUMBER = 3;
    private final int STRIKE = 1;
    private final int NOT_STRIKE = 0;
    private final int BALL = 1;
    private final int NOT_BALL = 0;
    private final String CORRECT_MESSAGE = "%d스트라이크\n"
            + "%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    private final String NOTHING_MESSAGE = "낫싱\n";
    private final String BALL_STRIKE_MESSAGE = "%d볼 %d스트라이크\n";
    private final String BALL_MESSAGE = "%d볼\n";
    private final String STRIKE_MESSAGE = "%d스트라이크\n";
    private final String RESTART_STATUS = "1";
    private final String END_GAME_STATUS = "2";
    private final String RESTART_END_MESSAGE = "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.\n";
    private String computer;
    private String player;
    private int strike;
    private int ball;
    private boolean exit = false;

    public Game() {
    }

    public void start() {
        Number playerNumber = new Number();
        Number computerNumber = new Number();

        computerNumber.setRandomNumber();
        computer = computerNumber.getNumber();

        while (!exit) {
            playerNumber.setNumber();
            player = playerNumber.getNumber();

            strike = countStrike();
            ball = countBall();
            printCount();

            if (strike == CNT_NUMBER) {
                exit = isEndInput(computerNumber);
            }
        }
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

    private void printCount() {
        if (strike == CNT_NUMBER) {
            System.out.printf(CORRECT_MESSAGE, strike, CNT_NUMBER);
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

    private boolean isEndInput(Number computerNumber) {
        System.out.printf(RESTART_END_MESSAGE, RESTART_STATUS, END_GAME_STATUS);
        String input = readLine();
        if (input.equals(END_GAME_STATUS)) {
            return true;
        } else if (input.equals(RESTART_STATUS)) {
            computerNumber.setRandomNumber();
            computer = computerNumber.getNumber();
            return false;
        }
        throw new IllegalArgumentException();
    }
}
