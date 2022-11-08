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

    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        char[] randomNumbers = makeRandomNumbers();
        char[] inputNumbers = inputNumber();
        System.out.println(inputNumbers);
        System.out.println(randomNumbers);
        printResult(inputNumbers, randomNumbers);
    }

    public static void endGame() {

    }

    public static char[] makeRandomNumbers() {
        char[] randomNumber = new char[3];
        int[] numbers = new int[3];

        for (int i = 0; i < 3; i++) {
            numbers[i] = makeARandomNumber(numbers);
        }

        for (int i = 0; i < 3; i++) {
            randomNumber[i] = (char) ('0' + numbers[i]);
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
        System.out.print("숫자를 입력해주세요 : ");
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

    public static void printResult(char[] inputNumber, char[] randomNumber) {
        int ballNumber = countBall(inputNumber, randomNumber);
        int strikeNumber = countStrike(inputNumber, randomNumber);

        if (ballNumber + strikeNumber == 0) {
            System.out.println("낫싱");
        } else if (strikeNumber == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            endGame();
        } else {
            if (ballNumber > 0)
                System.out.printf("%d볼", ballNumber);
            if (strikeNumber > 0)
                System.out.printf("%d스트라이크", strikeNumber);
            System.out.println("");
        }
    }

    public static int countStrike(char[] inputNumber, char[] randomNumber) {
        int strikeNumber = 0;

        for (int i = 0; i < 3; i++) {
            if (inputNumber[i] == randomNumber[i])
                strikeNumber++;
        }

        return strikeNumber;
    }

    public static int countBall(char[] inputNumber, char[] randomNumber) {
        int ballNumber = 0;

        for (int i = 0; i < 3; i++) {
            if (compareOtherPositionNumber(inputNumber, randomNumber, i))
                ballNumber++;
        }

        return ballNumber;
    }

    public static boolean compareOtherPositionNumber(char[] inputNumber, char[] randomNumber, int index) {
        for (int i = 0; i < 3; i++) {
            if (i == index)
                continue;
            if (inputNumber[index] == randomNumber[i])
                return true;
        }

        return false;
    }
}