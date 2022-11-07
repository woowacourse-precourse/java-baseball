package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    private static List<Integer> createRandomNumber() {
        List<Integer> computerNum = new ArrayList<>();

        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        return computerNum;
    }

    private static List<Integer> numToDigitList(String number) {
        List<Integer> numberList = new ArrayList<>();

        String[] numberSplit = number.split("");

        for (String num : numberSplit) {
            int toInt = Integer.parseInt(num);
            numberList.add(toInt);
        }

        return numberList;
    }

    private static int countStrike(
            List<Integer> computerNumber,
            List<Integer> userNumber
    ) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumber.get(i).equals(userNumber.get(i))) {
                count += 1;
            }
        }

        return count;
    }

    private static int countBall(
            List<Integer> computerNumber,
            List<Integer> userNumber,
            int strike
    ) {
        int count = 0;

        for (int number : userNumber) {
            if (computerNumber.contains(number)) {
                count += 1;
            }
        }

        // 같은 자리에 같은 숫자가 있어도 count 되기 때문에, 결과값에서 스트라이크 개수를 빼준다.
        count -= strike;

        return count;
    }

    private static String setHint(int ball, int strike) {

        if (ball + strike == 0) {
            return "낫싱";
        }

        String hint = "";

        if (ball > 0) {
            hint = hint.concat(Integer.toString(ball));
            hint = hint.concat("볼");

            if (strike > 0) {
                hint = hint.concat(" ");
            }
        }

        if (strike > 0) {
            hint = hint.concat(Integer.toString(strike));
            hint = hint.concat("스트라이크");
        }

        return hint;
    }

    private static void validateUserNumber(String userNumber) {
        if (userNumber.length() != 3) {
            throw new IllegalArgumentException("입력된 값의 길이가 3이 아닙니다.");
        }

        String pattern = "^[1-9]*$";
        boolean isMatch = Pattern.matches(pattern, userNumber);

        if (!isMatch) {
            throw new IllegalArgumentException("1-9 외의 값이 입력되었습니다.");
        }

        String[] numberSplit = userNumber.split("");
        String digit1 = numberSplit[0];
        String digit2 = numberSplit[1];
        String digit3 = numberSplit[2];
        boolean isDuplicate = digit1.equals(digit2) || digit1.equals(digit3) || digit2.equals(digit3);

        if (isDuplicate) {
            throw new IllegalArgumentException("중복된 수가 입력되었습니다.");
        }
    }

    private static void validateGameStart(String userInput) {
        String pattern = "^[1-2]$";
        boolean isMatch = Pattern.matches(pattern, userInput);

        if (!isMatch) {
            throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
        }
    }

    private static String isAnswer(int strike) {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String userInput = Console.readLine();
            validateGameStart(userInput);

            return userInput;
        }

        return "1";
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computerNum = createRandomNumber();
        String userInput = "1";

        while (userInput.equals("1")) {
            System.out.print("숫자를 입력해주세요 : ");
            String guessNumber = Console.readLine();
            validateUserNumber(guessNumber);
            List<Integer> user_num = numToDigitList(guessNumber);
            int strike = countStrike(computerNum, user_num);
            int ball = countBall(computerNum, user_num, strike);
            System.out.println(setHint(ball, strike));

            userInput = isAnswer(strike);

            if (strike == 3 && userInput.equals("1")) {
                computerNum = createRandomNumber();
            }
        }
    }
}
