package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;


public class Application {
    public static void main(String[] args) {

        //UserInput.requestBaseballNumber();

        NumberBaseballGame.startGame();
    }
}
class UserInput {
    private static String readLine = "";

    public static int[] requestBaseballNumber() {
        readLine = "";
        readLine = Console.readLine();
        validLength(3);
        isNumber();

        return divideDigits();
    }

    private static void validLength(int length) {
        if (readLine.length() != length) {
            throw new IllegalArgumentException();
        }
    }
    private static void isNumber() {
        Integer.parseInt(readLine);
    }

    private static int[] divideDigits() {
        String[] eachDigits = readLine.split("");
        int[] numberContainer = new int[3];
        for (int index = 0; index < numberContainer.length; index++ ) {
            numberContainer[index] = Integer.parseInt(eachDigits[index]);
        }
        return numberContainer;
    }

    public static int requestContinue() {
        readLine = "";
        readLine = Console.readLine();
        validLength(1);
        isNumber();

        int number = Integer.parseInt(readLine);
        if (number < 1 || number > 2) {
            throw new IllegalArgumentException();
        }
        return number;
    }


}


class BaseballGameSentence {
    public static String GAME_START = "숫자 야구 게임을 시작합니다.";
    public static String REQUEST_NUMBER = "숫자를 입력해주세요 : ";
    public static String BALL = "볼";
    public static String STRIKE = "스트라이크";
    public static String NOTHING = "낫싱";
    public static String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static String SELECT_REPLAY = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
}

class PrintGuidSentence {
    public static void startGame() {
        System.out.println(BaseballGameSentence.GAME_START);
    }
    public static void requestNumber() {
        System.out.print(BaseballGameSentence.REQUEST_NUMBER);
    }
    public static void printResult(int strike, int ball) {
        String dst = "";

        if (ball > 0) {
            dst = dst + ball + BaseballGameSentence.BALL;
        }
        if (strike > 0) {
            if (ball > 0) {
                dst = dst + " ";
            }
            dst = dst + strike + BaseballGameSentence.STRIKE;
        }
        if (strike + ball == 0) {
            dst = BaseballGameSentence.NOTHING;
        }
        System.out.println(dst);

    }
    public static void endGame() {
        System.out.println(BaseballGameSentence.GAME_OVER);
        System.out.println(BaseballGameSentence.SELECT_REPLAY);
    }
}


class BaseballNumber {
    private final int[] baseballNumber;

    BaseballNumber(int[] baseballNumber) {
        this.baseballNumber = baseballNumber;

        NumberValidation();
    }

    private void NumberValidation() {
        for (int index = 0; index < baseballNumber.length; index++) {
            validRange(baseballNumber[index]);
            validDuplication(baseballNumber[index], index);
        }
    }

    private void validRange(int eachNumber) {
        if (eachNumber == 0) {
            throw new IllegalArgumentException();
        }
    }
    private void validDuplication(int eachNumber, int index) {
        for (int i = 0; i < baseballNumber.length; i++) {
            if(index != i && eachNumber == baseballNumber[i]) {
                throw new IllegalArgumentException();
            }
        }
    }

    public int[] checkStrikerAndBall(BaseballNumber userGuess) {
        int[] strikeAndBall = new int[2];

        for (int index = 0; index < baseballNumber.length; index++) {
            int containIndex = checkContain(userGuess.baseballNumber[index]);
            strikeAndBall[0] += checkStrike(containIndex,index);
            strikeAndBall[1] += checkBall(containIndex,index);
        }
        return strikeAndBall;
    }

    public int checkContain(int number) {
        for (int index = 0; index < baseballNumber.length; index++) {
            if (baseballNumber[index] == number) {
                return index;
            }
        }
        return -1;
    }

    private int checkStrike(int containIndex, int userGuessIndex) {
        if (containIndex >= 0 && containIndex == userGuessIndex) {
            return 1;
        }
        return 0;
    }
    private int checkBall(int containIndex, int userGuessIndex) {
        if (containIndex >= 0 && containIndex != userGuessIndex) {
            return 1;
        }
        return 0;
    }
}


class NumberBaseballGame {
    private static BaseballNumber baseballNumber;
    private static boolean gameEndFlag = false;

    public static void startGame() {

        makeRandomBaseballNumber();
        PrintGuidSentence.startGame();
        proceedGame();

    }

    private static void makeRandomBaseballNumber() {
        int[] numberContainer = new int[3];
        int containerIndex = 0;

        List<Integer> baseballNumbers = new ArrayList<>();
        while (baseballNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!baseballNumbers.contains(randomNumber)) {
                baseballNumbers.add(randomNumber);
                numberContainer[containerIndex] = randomNumber;
                containerIndex++;
            }
        }
        baseballNumber = new BaseballNumber(numberContainer);
    }
    private static void proceedGame() {
        gameEndFlag = false;
        while (!gameEndFlag) {
            PrintGuidSentence.requestNumber();
            checkBaseballNumber(new BaseballNumber(UserInput.requestBaseballNumber()));
        }
    }
    private static void checkBaseballNumber(BaseballNumber userGuess) {
        int[] strikeAndBall = baseballNumber.checkStrikerAndBall(userGuess);
        PrintGuidSentence.printResult(strikeAndBall[0], strikeAndBall[1]);

        if (strikeAndBall[0] == 3) {
            PrintGuidSentence.endGame();
            askContinue(UserInput.requestContinue());
        }
    }

    private static void askContinue(int number) {
        if (number == 1) {
            makeRandomBaseballNumber();
            proceedGame();
        }
        gameEndFlag = true;
    }
}