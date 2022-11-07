package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        boolean gameflag = true;

        while (gameflag) {

            System.out.println("숫자 야구 게임을 시작합니다");

            List<Integer> computerNumber = generateNum();

            String checkNumbers = "";

            while (!checkNumbers.equals("3스트라이크")) {
                System.out.print("숫자를 입력해주세요 : ");
                List<Integer> userNumber = inputNum(inputSystem());
                checkNumbers = checkNumbers(computerNumber, userNumber);
                System.out.println(checkNumbers);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            gameflag = finish(inputSystem());
        }
    }

    static List<Integer> generateNum() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        System.out.println(computerNumber);
        return computerNumber;
    }

    static List<Integer> inputNum(String input) {
        List<Integer> userNumber = new ArrayList<>();
        for (String number : input.split("")) {
            userNumber.add(Integer.parseInt(number));
        }
        if (userNumber.size() != 3 || userNumber.size() != userNumber.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
        for (int number : userNumber) {
            if (Character.isDigit(number) || number == 0) {
                throw new IllegalArgumentException();
            }
        }
        return userNumber;
    }

    static String checkNumbers(List<Integer> computerNumber, List<Integer> userNumber) {

        int strike = 0;
        int total = 0;

        for (int i = 0; i < userNumber.size(); i++) {
            if (computerNumber.contains(userNumber.get(i))) {
                total += 1;
            }
            if (computerNumber.get(i) == userNumber.get(i)) {
                strike += 1;
            }
        }
        int ball = total - strike;

        if (total == 0) {
            return "낫싱";
        } else if (strike == 0) {
            return ball + "볼";
        } else if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }

    static boolean finish(String input) {

        int restart = Integer.parseInt(input);

        if (restart == 1) {
            return true;
        } else if (restart == 2) {
            return false;
        }

        throw new IllegalArgumentException();
    }

    static String inputSystem() {
        return Console.readLine();
    }
}







