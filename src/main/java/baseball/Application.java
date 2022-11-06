package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        List<Integer> restart = List.of(1);
        List<Integer> finish = List.of(2);

        List<Integer> answer = createAnswer();
        boolean gameFinished = false;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            if (gameFinished) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            } else {
                System.out.print("숫자를 입력해주세요 : ");
            }

            List<Integer> userInput = userInput();

            if (userInput.equals(restart)){
                answer = createAnswer();
                gameFinished = false;
                continue;
            }

            if (userInput.equals(finish)){
                break;
            }

            gameFinished = checkResult(answer, userInput);
        }
    }

    // 정답을 생성하는 함수: 정답은 1~9까지 서로 다른 수로 이루어진 3자리의 수이다.
    public static List<Integer> createAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }

        return answer;
    }

    // 사용자가 입력한 정답을 반환하는 함수, 입력은 서로 다른 3자리 수여야 한다. 단 1 과 2는 재시작, 종료를 위해 허용
    public static List<Integer> userInput() throws IllegalArgumentException {
        List<Integer> answer = new ArrayList<>();
        String consoleInput = Console.readLine();

        if (consoleInput.length() != 3 && !consoleInput.equals("1") && !consoleInput.equals("2")) {
            throw new IllegalArgumentException("유효하지 않는 입력입니다.");
        }

        for (int i = 0; i < consoleInput.length(); i++) {
            int charInt = Character.getNumericValue(consoleInput.charAt(i));
            if (!answer.contains(charInt)) {
                answer.add(charInt);
            } else {
                throw new IllegalArgumentException("서로 다른 3자리 수를 입력해주세요.");
            }
        }

        return answer;
    }

    // 사용자가 숫자를 맞추면 true 맞추지 못하면 false 반환
    public static boolean checkResult(List<Integer> answer, List<Integer> userInput) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < userInput.size(); i++) {
            if (Objects.equals(userInput.get(i), answer.get(i))) {
                strike++;
            } else if (answer.contains(userInput.get(i))) {
                ball++;
            }
        }

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else {
            return false;
        }
    }
}
