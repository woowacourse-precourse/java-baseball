package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }
}

class Game {

    public void startGame() {

    }

    public void endGame() {

    }

    public static void makeRandomNumber(Integer[] solutionNumber) {

    }

    public static char[] inputNumber() {
        String inputString = Console.readLine();
        isValidLength(inputString);
        isValidNumber(inputString);
        return inputString.toCharArray();
    }

    public static void isValidLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력된 값이 세자리 수가 아닙니다.");
        }
    }

    public static void isValidNumber(String input) {
        char[] inputCharList = input.toCharArray();
        if (inputCharList[0] == inputCharList[1] ||
                inputCharList[0] == inputCharList[2] || inputCharList[1] == inputCharList[2]) {
            throw new IllegalArgumentException("입력된 값에 중복된 숫자가 있습니다.");
        }
    }

}