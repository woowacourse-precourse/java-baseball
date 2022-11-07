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
}






