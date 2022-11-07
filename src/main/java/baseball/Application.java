package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

    }

    static List<Integer> generateNum() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    static List<Integer> inputNum() {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> userNumber = new ArrayList<>();
        for (String number : Console.readLine().split("")) {
            userNumber.add(Integer.parseInt(number));
            if (userNumber.size() > 3 || userNumber.size() != userNumber.stream().distinct().count()) {
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
}






