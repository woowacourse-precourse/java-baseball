package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class Application {
    public static void main(String[] args) {
        while (true) {
            List<Integer> computer = initializeGame();

        }
    }

    private static List<Integer> initializeGame() {
        System.out.println("숫자 야구 게임을 시작합니다.\n");

        return selectRandomNumbers();
    }
    private static List<Integer> selectRandomNumbers() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    private static List<Integer> getPlayerInput() {
        String input = Console.readLine();
        List<Integer> player = new ArrayList<>();

        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < input.length(); i++) {
            player.add(input.charAt(i) - '0');
        }

        return player;
    }

    static int countStrike(List<Integer> computer, List<Integer> player) {
        int strike = 0;

        for (int i = 0; i < player.size(); i++) {
            if (Objects.equals(computer.get(i), player.get(i))) {
                strike += 1;
            }
        }

        return strike;
    }
    static int countBall(List<Integer> computer, List<Integer> player) {
        int ball = 0;

        for (int i = 0; i < player.size(); i++) {
            if (Objects.equals(computer.get(i), player.get(i))) {
                continue;
            } else if (player.contains(computer.get(i))) {
                ball += 1;
            }
        }

        return ball;
    }

    static String makeHint(int strike, int ball) {
        String hint;

        if (strike == 0 && ball == 0) {
            hint = "낫싱";
        } else if (strike > 0 && ball == 0){
            hint = strike + "스트라이크";
        } else if (strike == 0 && ball > 0) {
            hint = ball + "볼";
        } else {
            hint = ball + "볼 " + strike + "스트라이크";
        }

        return hint;
    }

    private static boolean checkThreeStrike(int strike) {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
            return true;
        }

        return false;
    }

    private static int replayOrTerminateGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        int endStatus = Integer.parseInt(Console.readLine());

        return endStatus;
    }
}