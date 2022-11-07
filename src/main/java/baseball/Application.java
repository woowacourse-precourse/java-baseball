package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

enum BaseballResult {
    NOTHING("낫띵"),
    BALL("볼"),
    STRIKE("스트라이크");

    private final String korName;

    BaseballResult(String korName) {
        this.korName = korName;
    }

    public String getKorName() {
        return korName;
    }
}

public class Application {

    public static void main(String[] args) {
        printGameStartMessage();

        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> userNumber = splitStrNumberToList(Console.readLine());
        List<Integer> computerNumber = Randoms.pickUniqueNumbersInRange(1, 9, 3);

        HashMap<BaseballResult, Integer> gameResult = new HashMap<>();

        for (int i = 0; i < userNumber.size(); i++) {
            BaseballResult currentIdxGameResult = getCurrentIdxGameResult(i, userNumber, computerNumber);
            gameResult.put(currentIdxGameResult, gameResult.getOrDefault(currentIdxGameResult, 0) + 1);
        }
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

    public static BaseballResult getCurrentIdxGameResult(int currentIdx, List<Integer> userNumber, List<Integer> computerNumber) {
        if (isEqualInts(userNumber.get(currentIdx), computerNumber.get(currentIdx))) {
            return BaseballResult.STRIKE;
        }

        for (int i = 0; i < userNumber.size(); i++) {
            if (isEqualInts(userNumber.get(currentIdx), computerNumber.get(i))) {
                return BaseballResult.BALL;
            }
        }

        return BaseballResult.NOTHING;
    }

    private static boolean isEqualInts(int number, int comparingNumber) {
        return number == comparingNumber;
    }
}
