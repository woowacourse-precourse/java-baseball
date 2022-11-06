package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        List<Integer> answer = createAnswer();

        while (true) {
            boolean gameEnded = gamePlay(answer);
            if (gameEnded && !gameReplayOptionInput()) {
                break;
            }
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

    // 사용자가 입력한 정답을 반환하는 함수, 입력은 서로 다른 3자리 수여야 한다.
    public static List<Integer> userInput() throws IllegalArgumentException {
        List<Integer> answer = new ArrayList<>();
        String consoleInput = Console.readLine();
        if (consoleInput.length() != 3) {
            throw new IllegalArgumentException("입력이 3자리 수가 아닙니다.");
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

    // 게임을 재시작하면 true 를 반환하고 종료하면 false 를 반환
    public static boolean gameReplayOptionInput() throws IllegalArgumentException {
        System.out.println("게임을 새로 시작하려면: 1, 종료하려면 2를 입력하시요.");
        String consoleInput = Console.readLine();
        if (!consoleInput.equals("1") && !consoleInput.equals("2")) {
            throw new IllegalArgumentException("입력은 1 혹은 2로 해주세요.");
        } else if (consoleInput.equals("1")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean gamePlay(List<Integer> answer) {
        int ball = 0;
        int strike = 0;

        System.out.print("숫자를 입력해주세요: ");
        List<Integer> userInput = userInput();

        for (int i = 0; i < userInput.size(); i++) {
            if (Objects.equals(userInput.get(i), answer.get(i))) {
                strike++;
            } else if (answer.contains(userInput.get(i))) {
                ball++;
            }
        }

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return false;
        } else if (strike == 0) {
            System.out.println(ball + "볼");
            return false;
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
            return false;
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
            return false;
        }
    }
}
