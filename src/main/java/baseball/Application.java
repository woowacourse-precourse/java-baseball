package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    static int[] randomNumber = new int[3];
    static int[] userNumber = new int[3];

    public static void start() throws IllegalArgumentException {
        generateThreeDigitNumber();
        guessWithUser();
    }

    public static void guessWithUser() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        if (!userInputValidation(userInput)) {
            throw new IllegalArgumentException();
        }
        saveUserInput(userInput);
        compareInputWithNumber(userInput);
    }

    private static void saveUserInput(String userInput) {
        userNumber[0] = Integer.parseInt(userInput.substring(0, 1));
        userNumber[1] = Integer.parseInt(userInput.substring(1, 2));
        userNumber[2] = Integer.parseInt(userInput.substring(2, 3));
    }

    public static void compareInputWithNumber(String userInput) {
        int strike = 0;
        int ball = 0;

        for (int digit = 0; digit < userNumber.length; digit++) {
            int strikeOrBall = checkStrikeOrBall(userNumber[digit], digit);
            if (strikeOrBall == 2) {
                strike++;
            } else if (strikeOrBall == 1) {
                ball++;
            }
        }

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            //askNewGame();
        }
        else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            guessWithUser();
        }
        else if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
            guessWithUser();
        }
        else if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
            guessWithUser();
        }
        else if (strike != 0 && ball != 0) {
            System.out.println(strike + "스트라이크 " + ball + "볼");
            guessWithUser();
        }

    }

    private static int checkStrikeOrBall(int i, int digit) {
        if (i == randomNumber[digit]) {
            return 2;
        }
        for (int j = 0; j < 3; j++) {
            if (j != digit && i == randomNumber[j]) {
                return 1;
            }
        }
        return 0;
    }


    public static boolean userInputValidation(String userInput) throws IllegalArgumentException {
        if (userInput == null) {
            throw new IllegalArgumentException();
        }
        try {
            int userInputInt = Integer.parseInt(userInput);
            if (userInputInt < 111 || userInputInt > 999) {
                throw new IllegalArgumentException();
            }
            if (userInputInt % 10 == 0 || userInputInt % 100 == 0) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public static void generateThreeDigitNumber() {
        randomNumber[0] = Randoms.pickNumberInRange(1, 9);
        randomNumber[1] = Randoms.pickNumberInRange(1, 9);
        while (randomNumber[1] == randomNumber[0]) {
            randomNumber[1] = Randoms.pickNumberInRange(1, 9);
        }
        randomNumber[2] = Randoms.pickNumberInRange(1, 9);
        while (randomNumber[2] == randomNumber[0] || randomNumber[2] == randomNumber[1]) {
            randomNumber[2] = Randoms.pickNumberInRange(1, 9);
        }
    }

    public static void main(String[] args) throws IllegalArgumentException {
        System.out.println("숫자 야구 게임을 시작합니다");

        start();
    }
}
