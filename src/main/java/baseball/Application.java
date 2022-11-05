package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Baseball.playGame();
    }
}

class Baseball {
    private static int checkRestartGame;
    private static List<Integer> computerNumber;
    private static String userNumber;
    private static HashMap<String, Integer> countBallStrike;
    private static final int START_NUM_INCLUSIVE = 1;
    private static final int END_NUM_INCLUSIVE = 9;
    private static final int NUMBER_PITCH = 3;
    private static final int NEW_GAME = 1;
    private static final int END_GAME = 2;
    private static final String BALL = "볼 ";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String INPUT_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void playGame() {
        System.out.println(START_MESSAGE);
        newGame();
    }

    private static void newGame() {
        init();
        buildComputerNumber();
        inputUserNumber();
    }

    private static void inputUserNumber() {
        getUserNumber();
        getBallStrikeNothing();
        printResult();
        isWinNumber();
    }

    private static void init() {
        computerNumber = new ArrayList<>();
        countBallStrike = new HashMap<>();
    }

    private static void buildComputerNumber() {
        while (computerNumber.size() < NUMBER_PITCH) {
            int randomNumber = Randoms.pickNumberInRange(START_NUM_INCLUSIVE, END_NUM_INCLUSIVE);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    private static void getUserNumber() {
        userNumber = Console.readLine();
        if (!isValidNumber()) {
            illegalArgumentException();
        }
        System.out.println(INPUT_NUMBER_MESSAGE + userNumber);
    }

    private static void getBallStrikeNothing() {
        int countBall = 0;
        int countStrike = 0;
        for (int i = 0; i < computerNumber.size(); i++) {
            if (!computerNumber.get(i).equals(Integer.parseInt(userNumber.substring(i, i + 1)))
                    && userNumber.contains(Integer.toString(computerNumber.get(i)))) {
                countBall++;
            }
            if (computerNumber.get(i).equals(Integer.parseInt(userNumber.substring(i, i + 1)))) {
                countStrike++;
            }
        }
        countBallStrike.put(BALL, countBall);
        countBallStrike.put(STRIKE, countStrike);
    }

    private static void printResult() {
        if (countBallStrike.get(BALL) != 0 && countBallStrike.get(STRIKE) != 0) {
            System.out.print(countBallStrike.get(BALL) + BALL);
            System.out.println(countBallStrike.get(STRIKE) + STRIKE);
        }
        if (countBallStrike.get(BALL) != 0 && countBallStrike.get(STRIKE) == 0) {
            System.out.println(countBallStrike.get(BALL) + BALL);
        }
        if (countBallStrike.get(BALL) == 0 && countBallStrike.get(STRIKE) != 0) {
            System.out.println(countBallStrike.get(STRIKE) + STRIKE);
        }
        if (countBallStrike.get(BALL) == 0 && countBallStrike.get(STRIKE) == 0) {
            System.out.println(NOTHING);
        }
    }

    private static void isWinNumber() {
        if (countBallStrike.get(STRIKE) != NUMBER_PITCH) {
            inputUserNumber();
            return;
        }
        if (countBallStrike.get(STRIKE) == NUMBER_PITCH) {
            System.out.println(WIN_MESSAGE);
            System.out.println(INPUT_RESTART_MESSAGE);
            checkRestartGame();
        }
    }

    private static void checkRestartGame() {
        checkRestartGame = Integer.parseInt(Console.readLine());
        if (!isValidRestartNumber()) {
            illegalArgumentException();
        }
        if (checkRestartGame == NEW_GAME) {
            System.out.println(NEW_GAME);
            newGame();
            return;
        }
        if (checkRestartGame == END_GAME) {
            System.out.println(END_GAME);
        }
    }

    private static boolean isValidNumber() {
        return userNumber.matches("^[1-9]{3}$");
    }

    private static boolean isValidRestartNumber() {
        return checkRestartGame == NEW_GAME || checkRestartGame == END_GAME;
    }

    private static void illegalArgumentException() {
        throw new IllegalArgumentException();
    }
}