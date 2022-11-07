package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        printGameStartMessage();

        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> userNumber = splitStrNumberToList(Console.readLine());
        List<Integer> computerNumber = Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

    private static void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static List<Integer> splitStrNumberToList(String strNumber) {
        List<Integer> userNumberList = new ArrayList<>();

        userNumberList.add(Character.getNumericValue(strNumber.charAt(0)));
        userNumberList.add(Character.getNumericValue(strNumber.charAt(1)));
        userNumberList.add(Character.getNumericValue(strNumber.charAt(2)));

        return userNumberList;
    }
}
