package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void startApp() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        startGame();
    }

    public static void startGame() {
        String answer = createThreeDigitNumber();
        boolean isAnswer = false;

        while (!isAnswer) {
            String input = Console.readLine();
            isValidInputInGame(input);
            // TODO: 정답 비교 호출
        }

        // TODO: 게임 종료 호출
    }

    public static String createThreeDigitNumber() {
        String answer = new String();

        while (answer.length() < 3) {
            String num = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!answer.contains(num)) {
                answer += num;
            }
        }

        return answer;
    }

    public static void isValidInputInGame(String input) {
        List<Character> temp = new ArrayList<>();

        if (input.length() != 3) {
            throw new IllegalArgumentException("유효하지 않는 값을 입력했습니다. 프로그램이 종료됩니다.");
        }
        for (int i = 0; i < input.length(); i++) {
            if (temp.contains(input.charAt(i))) {
                throw new IllegalArgumentException("유효하지 않는 값을 입력했습니다. 프로그램이 종료됩니다.");
            }
            temp.add(input.charAt(i));
        }
    }

    public static void main(String[] args) {
        startApp();
    }
}
