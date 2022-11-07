package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        gameStart();
    }

    private static String getRandomThreeDigitNumberString() {
        List<String> computer = new ArrayList<>();
        while (computer.size() < 3) {
            String randomNumber = Randoms.pickNumberInRange(1, 9)+"";
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return String.join("",  computer);
    }

    private static String userInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInputString = Console.readLine();
        System.out.println(userInputString);

        userInputValidation(userInputString);
        return userInputString;
    }

    private static void userInputValidation(String userInputString) {
        String pattern = "^[1-9]{3}$";
        if (!Pattern.matches(pattern, userInputString)) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < userInputString.length(); i++) {
            String indexDigitNumber = userInputString.charAt(i) + "";
            String checkOverlapString = userInputString.replace(indexDigitNumber, "");

            if (checkOverlapString.length() < 2) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static int compareUserInputToAnswer(String userInput, String answer) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (userInput.charAt(i) == answer.charAt(i)) {
                strike += 1;
            } else if (answer.contains(userInput.charAt(i) + "")) {
                ball += 1;
            }
        }
        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike != 0) {
            System.out.print(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        System.out.println();

        return strike;
    }

    private static boolean checkGameOver(int strike) {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return restartGame();
        }
        return true;
    }

    private static boolean restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInputString = Console.readLine();
        if (userInputString.equals("1")) {
            return true;
        } else if (userInputString.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static void gameStart() {
        String answer = getRandomThreeDigitNumberString();
        int strike = 0;
        while (checkGameOver(strike)) {
            strike = compareUserInputToAnswer(userInput(), answer);
        }
    }
}
