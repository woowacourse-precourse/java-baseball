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
    protected static String userNumber;
    protected static HashMap<String, Integer> countBallStrike;
    protected static int restartGame;
    protected static List<Integer> computerNumber;

    protected static final String BLANK = " ";
    protected static final String BALL = "볼";
    protected static final String STRIKE = "스트라이크";
    protected static final String NOTHING = "낫싱";
    protected static final int NEW_GAME = 1;
    protected static final int END_GAME = 2;
    protected static final int NUMBER_PITCH = 3;
    protected static final int EMPTY = 0;
    private static final int START_NUM_INCLUSIVE = 1;
    private static final int END_NUM_INCLUSIVE = 9;

    protected static void playGame() {
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
        if (!Exception.isValidNumber() || !Exception.isOverlapNumber()) {
            Exception.illegalArgumentException();
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
        if (!Exception.isValidRestartNumber()) {
            Exception.illegalArgumentException();
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
        int countBall = EMPTY;
        for (int i = 0; i < NUMBER_PITCH; i++) {
            if (!isUserNumberEqualsComputerNumber(i) && isUserNumberContainsComputerNumber(i)) {
                countBall++;
            }
        }
        return countBall;
    }

    private static int countStrike() {
        int countStrike = EMPTY;
        for (int i = 0; i < NUMBER_PITCH; i++) {
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

    private static boolean isExistBall() {
        return countBallStrike.get(BALL) != EMPTY;
    }

    private static boolean isExistStrike() {
        return countBallStrike.get(STRIKE) != EMPTY;
    }

    private static boolean isThreeStrike() {
        return countBallStrike.get(STRIKE) == NUMBER_PITCH;
    }

}

class Message extends Baseball {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String INPUT_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    protected static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    protected static void printInputNumberMessage() {
        System.out.println(INPUT_NUMBER_MESSAGE + userNumber);
    }

    protected static void printWinMessage() {
        System.out.println(WIN_MESSAGE);
    }

    protected static void printInputRestartMessage() {
        System.out.println(INPUT_RESTART_MESSAGE);
    }

    protected static void printNewGameValue() {
        System.out.println(NEW_GAME);
    }

    protected static void printEndGameValue() {
        System.out.println(END_GAME);
    }

    protected static void printNothing() {
        System.out.println(NOTHING);
    }

    protected static void printBallOnly() {
        System.out.println(countBallStrike.get(BALL) + BALL);
    }

    protected static void printStrikeOnly() {
        System.out.println(countBallStrike.get(STRIKE) + STRIKE);
    }

    protected static void printBallStrike() {
        System.out.println(countBallStrike.get(BALL) + BALL
                + BLANK
                + countBallStrike.get(STRIKE) + STRIKE);
    }
}

class Exception extends Baseball {
    protected static boolean isValidNumber() {
        // [1-9]는 0을 제외한 숫자 입력, {3}은 NUMBER_PITCH 만큼 길이 설정
        return userNumber.matches("^[1-9]{3}$");
    }

    protected static boolean isValidRestartNumber() {
        return restartGame == NEW_GAME || restartGame == END_GAME;
    }

    protected static boolean isOverlapNumber() {
        HashSet<String> checkOverlapUserNumber = new HashSet<>();
        for (int i = 0; i < NUMBER_PITCH; i++) {
            checkOverlapUserNumber.add(userNumber.substring(i, i + 1));
        }
        return checkOverlapUserNumber.size() == computerNumber.size();
    }

    protected static void illegalArgumentException() {
        throw new IllegalArgumentException();
    }
}