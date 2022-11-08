package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    static int[] randomNumber = new int[3];
    public static void start() throws IllegalArgumentException{
        generateThreeDigitNumber();
        guessWithUser();
    }

    public static void guessWithUser() throws IllegalArgumentException{
        System.out.println("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        if (!userInputValidation(userInput)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean userInputValidation(String userInput) throws IllegalArgumentException {
        if (userInput == null) {
            throw new IllegalArgumentException();
        }
        try {
            int userInputInt = Integer.parseInt(userInput);
            if (userInputInt > 999 || userInputInt < 100) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public static void generateThreeDigitNumber() {
        randomNumber[0] = Randoms.pickNumberInRange(1, 9);
        randomNumber[1] = Randoms.pickNumberInRange(0, 9);
        randomNumber[2] = Randoms.pickNumberInRange(0, 9);
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다");
        try {
            start();
        } catch (IllegalArgumentException e) {
        }


    }
}
