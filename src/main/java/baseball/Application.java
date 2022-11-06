package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;


public class Application {
    public static void main(String[] args) {

        System.out.print("숫자를 입력해 주세요 : ");
        System.out.println(UserInput.request());


    }
}


class UserInput {
    private static String readLine = "";
    public static String request() {
        readLine = Console.readLine();
        validLength();
        isNumber();

        return readLine;
    }

    private static void validLength() {
        if (readLine.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private static void isNumber() {
        Integer.parseInt(readLine);
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
    public static void loadGame() {
        System.out.println(BaseballGameSentence.GAME_START);
    }
    public static void requestNumber() {
        System.out.print(BaseballGameSentence.REQUEST_NUMBER);
    }
    public static void printResult() {

    }
    public static void endGame() {
        System.out.print(BaseballGameSentence.GAME_OVER);
        System.out.print(BaseballGameSentence.SELECT_REPLAY);
    }
}

class BaseballNumberMaker {


}



class BaseballNumber {
    private int[] baseballNumber;

    BaseballNumber(int[] baseballNumber) {
        this.baseballNumber = baseballNumber;
        //divideDigits();
        NumberValidation();
    }

    private void divideDigits() { // 이부분 인풋으로 빼고 그냥 int[]이거 받는게 나을듯
        //String numberToString = Integer.toString(baseballNumber);
        //String[] eachDigits = numberToString.split("");

        //for (int index = 0; index < eachDigits.length; index++) {
        //    this.baseballNumber[index] = Integer.parseInt(eachDigits[index]);
        //}
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
            if(index != i || eachNumber == baseballNumber[i]) {
                throw new IllegalArgumentException();
            }
        }
    }


    // 포함확인 함수
    // 위치확인 함수

}


class NumberBaseballGame {
    private BaseballNumber baseballNumber;

    public void startGame() {

    }

    private void makeRandomBaseballNumber() {
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
    private void proceedGame() {

    }
    private void checkBaseballNumber(BaseballNumber userGuess) {

    }


}