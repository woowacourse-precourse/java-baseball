package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static void playGame() {
        String answer = createRandomNumber();
        String playerInput;
        boolean isAnswer = false;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (!isAnswer) {
            playerInput = Console.readLine();
            isValidInput(playerInput);
            // TODO: 스트라이크, 볼, 정답 판독
        }
    }

    private static String createRandomNumber() {
        String answer = new String();

        while (answer.length() < 3) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!answer.contains(randomNumber)) {
                answer += randomNumber;
            }
        }

        return answer;
    }

    private static void isValidInput(String playerInput) {
        List<Character> input = new ArrayList<>();

        if (playerInput.length() != 3) {
            throw new IllegalArgumentException("잘못된 입력 입니다. 게임을 종료합니다.");
        }

        for (int i = 0; i < playerInput.length(); i++) {
            if (input.contains(playerInput.charAt(i))) {
                throw new IllegalArgumentException("잘못된 입력 입니다. 게임을 종료합니다.");
            }
            input.add(playerInput.charAt(i));
        }
    }

    public static void main(String[] args) {
        playGame();
    }
}
