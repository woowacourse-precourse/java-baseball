package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static int getStrike(List<Integer> answer, String userInput) {
        Integer strike = 0;

        for (int index = 0; index < 3; index++) {
            if (answer.get(index) == userInput.charAt(index)) {
                strike += 1;
            }
        }

        return strike;
    }

    public void startGame() {
        System.out.print("숫자 야구 게임을 시작합니다.");
    }

    public static String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");

        return Console.readLine();
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
