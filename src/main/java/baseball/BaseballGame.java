package baseball;

import java.util.List;

public class BaseballGame {

    static int strikeCheck(List<Integer> cut, List<Integer> computer) {
        int cnt = 0;

        for (int i = 0; i < 3; i++) {
            if (cut.get(i) == computer.get(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    static int ballCheck(List<Integer> cut, List<Integer> computer) {
        int cnt = 0;

        for (int i = 0; i < 3; i++) {
            if ((cut.get(i) != computer.get(i)) && computer.contains(cut.get(i))) {
                cnt++;
            }
        }
        return cnt;
    }

    static boolean notingCheck(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return true;
        }
        return false;
    }

    static boolean endCheck(int strike) {
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    static void ballAndStrike(int strike, int ball) {
        if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    static boolean playGame() {
        List<Integer> computer = Input.computerRandomNumber();

        while (true) {
            String player = Input.userNumber();
            Input.userNumberErrorCheck(player);
            List<Integer> user = Input.cutNumber(player);
            int strike = strikeCheck(user, computer);
            int ball = ballCheck(user, computer);

            if (endCheck(strike)) {
                return true;
            } else if (notingCheck(strike, ball)) {
                System.out.println("낫싱");
            } else {
                ballAndStrike(strike, ball);
            }
        }
    }

    static boolean replayCheck(int replay) {
        if (replay == 1) {
            return true;
        } else if (replay != 1 && replay != 2) {
            throw new IllegalArgumentException("올바른 입력값이 아닙니다.");
        }
        return false;
    }
}
