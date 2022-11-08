package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game gameApplication = new Game();
        gameApplication.startGame();
    }
}

class Game {

    public void startGame() {
        char[] radomNumber = makeRandomNumbers();
        char[] inputNubmer = inputNumber();
        System.out.println(radomNumber);
        System.out.println(inputNubmer);
    }

    public void endGame() {

    }

    public static char[] makeRandomNumbers() {
        char[] randomNumber = new char[3];
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = makeARandomNumber(numbers);
        }
        for (int i = 0; i < 3; i++) {
            randomNumber[i] = (char)('0' + numbers[i]);
        }
        return randomNumber;
    }

    // 중복을 확인해 숫자 한개 생성
    public static int makeARandomNumber(int[] numbers) {
        int num = 0;
        while (true) {
            num = Randoms.pickNumberInRange(1, 9);
            if (!isInNumbers(numbers, num)) {
                break;
            }
        }
        return num;
    }

    public static boolean isInNumbers(int[] numbers, int num) {
        for (int i = 0; i < numbers.length; i++) {
            if (num == numbers[i])
                return true;
        }
        return false;
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