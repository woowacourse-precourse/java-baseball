package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Baseball.playGame();
    }
}

class Baseball {
    public static String userNumber;
    public static HashMap<String, Integer> countBallStrike;
    public static int restartGame;
    private static List<Integer> computerNumber;

    public static final String BLANK = " ";
    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String NOTHING = "낫싱";
    public static final int NEW_GAME = 1;
    public static final int END_GAME = 2;
    private static final int START_NUM_INCLUSIVE = 1;
    private static final int END_NUM_INCLUSIVE = 9;
    private static final int NUMBER_PITCH = 3;
    private static final int EMPTY = 0;

    public static void playGame() {
        Message.printStartMessage();
        newGame();
    }

    private static void newGame() {
        init();
        buildComputerNumber();
        getUserNumber();
    }

    private static void getUserNumber() {
        inputUserNumber();
        countBallStrike();
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

    private static void inputUserNumber() {
        userNumber = Console.readLine();
        if (!isValidNumber() || !isOverlapNumber()) {
            illegalArgumentException();
        }
        Message.printInputNumberMessage();
    }

    private static void countBallStrike() {
        countBallStrike.put(BALL, countBall());
        countBallStrike.put(STRIKE, countStrike());
    }

    private static void printResult() {
        if (isExistBall() && isExistStrike()) {
            Message.printBallStrike();
        }
        if (isExistBall() && !isExistStrike()) {
            Message.printBallOnly();
        }
        if (!isExistBall() && isExistStrike()) {
            Message.printStrikeOnly();
        }
        if (!isExistBall() && !isExistStrike()) {
            Message.printNothing();
        }
    }

    private static void isWinNumber() {
        if (!isThreeStrike()) {
            getUserNumber();
            return;
        }
        if (isThreeStrike()) {
            Message.printWinMessage();
            Message.printInputRestartMessage();
            checkRestartGame();
        }
    }

    private static void checkRestartGame() {
        restartGame = Integer.parseInt(Console.readLine());
        if (!isValidRestartNumber()) {
            illegalArgumentException();
        }
        if (restartGame == NEW_GAME) {
            Message.printNewGameValue();
            newGame();
            return;
        }
        if (restartGame == END_GAME) {
            Message.printEndGameValue();
        }
    }

    private static int countBall() {
        int countBall = 0;
        for (int i = 0; i < computerNumber.size(); i++) {
            if (!isUserNumberEqualsComputerNumber(i) && isUserNumberContainsComputerNumber(i)) {
                countBall++;
            }
        }
        return countBall;
    }

    private static int countStrike() {
        int countStrike = 0;
        for (int i = 0; i < computerNumber.size(); i++) {
            if (isUserNumberEqualsComputerNumber(i)) {
                countStrike++;
            }
        }
        return countStrike;
    }

    private static boolean isUserNumberContainsComputerNumber(int i) {
        return userNumber.contains(Integer.toString(computerNumber.get(i)));
    }

    private static boolean isUserNumberEqualsComputerNumber(int i) {
        return computerNumber.get(i).equals(Integer.parseInt(userNumber.substring(i, i + 1)));
    }

    private static boolean isValidNumber() {
        return userNumber.matches("^[1-9]{3}$");
    }

    private static boolean isValidRestartNumber() {
        return restartGame == NEW_GAME || restartGame == END_GAME;
    }

    private static boolean isOverlapNumber() {
        HashSet<String> checkOverlapUserNumber = new HashSet<>();
        for (int i = 0; i < userNumber.length(); i++) {
            checkOverlapUserNumber.add(userNumber.substring(i, i + 1));
        }
        return checkOverlapUserNumber.size() == computerNumber.size();
    }

    private static boolean isExistBall() {
        return countBallStrike.get(BALL) != EMPTY;
    }

    private static boolean isExistStrike() {
        return countBallStrike.get(STRIKE) != EMPTY;
    }

    private static boolean isThreeStrike() {
        return countBallStrike.get(STRIKE) == NUMBER_PITCH;
    }

    private static void illegalArgumentException() {
        throw new IllegalArgumentException();
    }
}

class Message {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String INPUT_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printInputNumberMessage() {
        System.out.println(INPUT_NUMBER_MESSAGE + Baseball.userNumber);
    }

    public static void printWinMessage() {
        System.out.println(WIN_MESSAGE);
    }

    public static void printInputRestartMessage() {
        System.out.println(INPUT_RESTART_MESSAGE);
    }

    public static void printNewGameValue() {
        System.out.println(Baseball.NEW_GAME);
    }

    public static void printEndGameValue() {
        System.out.println(Baseball.END_GAME);
    }

    public static void printNothing() {
        System.out.println(Baseball.NOTHING);
    }

    public static void printBallOnly() {
        System.out.println(Baseball.countBallStrike.get(Baseball.BALL) + Baseball.BALL);
    }

    public static void printStrikeOnly() {
        System.out.println(Baseball.countBallStrike.get(Baseball.STRIKE) + Baseball.STRIKE);
    }

    public static void printBallStrike() {
        System.out.println(Baseball.countBallStrike.get(Baseball.BALL) + Baseball.BALL
                + Baseball.BLANK
                + Baseball.countBallStrike.get(Baseball.STRIKE) + Baseball.STRIKE);
    }
}