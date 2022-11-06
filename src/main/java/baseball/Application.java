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
            isAnswer = compareAnswer(input, answer);
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

    public static boolean compareAnswer(String input, String answer) {
        boolean isAnswer = false;
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < answer.length(); i++) {
            Character temp = input.charAt(i);
            if (answer.charAt(i) == temp) {
                strike++;
            }
            else if (answer.contains(String.valueOf(temp))) {
                ball++;
            }
        }

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
        else if (ball > 0 && strike == 0) {
            System.out.println(ball + "볼");
        }
        else if (ball == 0 && strike > 0) {
            System.out.println(strike + "스트라이크");
        }
        else if (ball < 3 && strike < 3) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }

        if (strike == 3) {
            isAnswer = true;
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

        return isAnswer;
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
