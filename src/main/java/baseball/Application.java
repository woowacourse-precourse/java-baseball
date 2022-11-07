package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        printInitMessage();
        List<Integer> userAnswer = stringConvertToIntegerList(getUserAnswer()); // 입력받은 값을 리스트로 변경
        Score score = new Score(); // 점수 초기화

    }

    private static void printInitMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static String getUserAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static List<Integer> stringConvertToIntegerList(String str) {
        return Arrays.stream(str.split(""))
                .map(el -> Integer.parseInt(el))
                .collect(Collectors.toList());
    }

    public static List<Integer> pickThreeNumbers() {
        List<Integer> result = new ArrayList<>();
        while (result.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!result.contains(randomNumber)) {
                result.add(randomNumber);
            }
        }
        return result;
    }
}
