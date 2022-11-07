package baseball;

import java.util.List;
import java.util.Objects;

public class gameResult {
    public boolean get_result(Computer computer, User user) {

        int strike = count_strike(computer.get_number(), user.get_number());
        int ball = count_ball(computer.get_number(), user.get_number(), strike);

        print_result(ball, strike);

        return game_win(strike);
    }

    private int count_strike(List<Integer> computer, List<Integer> user) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(computer.get(i), user.get(i))) strike++;
        }

        return strike;
    }

    private int count_ball(List<Integer> computer, List<Integer> user, int strike) {
        int ball = 0;
        for (Integer e : computer) {
            if (user.contains(e)) ball++;
        }

        return ball - strike;
    }

    private void print_result(int ball, int strike) {
        if (ball != 0 && strike != 0) System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        if (ball != 0 && strike == 0) System.out.printf("%d볼\n", ball);
        if (ball == 0 && strike != 0) System.out.printf("%d스트라이크\n", strike);
        if (ball == 0 && strike == 0) System.out.println("낫싱");
    }

    private boolean game_win(int strike) {
        if (strike == 3) return true;
        return false;
    }


}
