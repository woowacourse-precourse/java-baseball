package baseball;

import java.util.List;

public class BaseBall {

    public static String checkNumber(List<Integer> player, List<Integer> computer) {
        int strike = countStrike(player, computer);
        int ball = countBall(strike, player, computer);

        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        if (strike == 0) {
            return ball + "볼";
        }

        if (ball == 0) {
            return strike + "스트라이크";
        }

        return ball + "볼 " + strike + "스트라이크";
    }

    public static int countStrike(List<Integer> player, List<Integer> computer) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (player.get(i).equals(computer.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public static int countBall(int strike, List<Integer> player, List<Integer> computer) {
        int ball = 0;
        for (int number = 1; number <= 9; number++) {
            if (player.contains(number) && computer.contains(number)) {
                ball++;
            }
        }
        return ball - strike;
    }

}

