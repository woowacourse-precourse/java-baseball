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
            isAnswer = compareAnswer(playerInput, answer);
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

    private static boolean compareAnswer(String playerInput, String answer) {
        boolean isAnswer = false;
        int strike = 0;
        int ball = 0;

        strike = checkStrike(playerInput, answer);
        ball = checkBall(playerInput, answer);

        if (strike == 3) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            isAnswer = true;
        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            isAnswer = false;
        } else if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
            isAnswer = false;
        } else if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
            isAnswer = false;
        } else if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
            isAnswer = false;
        }

        return isAnswer;
    }

    private static int checkStrike(String playerInput, String answer) {
        int strike = 0;

        for (int i = 0; i < playerInput.length(); i++) {
            if (playerInput.charAt(i) == answer.charAt(i)) {
                strike++;
            }
        }

        return strike;
    }

    private static int checkBall(String playerInput, String answer) {
        int ball = 0;

        for (int i = 0; i < playerInput.length(); i++) {
            if (answer.contains(String.valueOf(playerInput.charAt(i)))) {
                ball++;
            }
        }

        return ball;
    }

    public static void main(String[] args) {
        playGame();
    }
}
