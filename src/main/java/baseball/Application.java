package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static int getStrike(List<Integer> answer, List<Integer> userInput) {
        Integer strike = 0;

        for (int index = 0; index < 3; index++) {
            if (answer.get(index).equals(userInput.get(index))) {
                strike += 1;
            }
        }

        return strike;
    }

    public void startGame() {
        System.out.print("숫자 야구 게임을 시작합니다.");
    }

    public static List<Integer> getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");

        return Arrays
                .stream(Console.readLine().split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<Integer> getAnswer() {
        List<Integer> answer = new ArrayList<>();

        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
    }
}
