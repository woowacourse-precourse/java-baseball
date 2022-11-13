package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FunctionTest {

    @Test
    public void TEST1_3_Strike() {
        List<Integer> computerNumber = List.of(1, 2, 3);
        List<Integer> userNumber = List.of(1, 2, 3);

        int ball = 0;
        int strike = 0;
        for (int i = 0; i < computerNumber.size(); i++) {
            if (computerNumber.get(i) == userNumber.get(i)) {
                strike++;
            } else if (computerNumber.contains(userNumber.get(i))) {
                ball++;
            }
        }
        printResult(strike, ball);

        Assertions.assertThat(strike).isEqualTo(3);
        Assertions.assertThat(ball).isEqualTo(0);
    }

    @Test
    public void TEST1_only_Strike() {
        List<Integer> computerNumber = List.of(1, 2, 3);
        List<Integer> userNumber = List.of(1, 2, 4);

        int ball = 0;
        int strike = 0;
        for (int i = 0; i < computerNumber.size(); i++) {
            if (computerNumber.get(i) == userNumber.get(i)) {
                strike++;
            } else if (computerNumber.contains(userNumber.get(i))) {
                ball++;
            }
        }
        printResult(strike, ball);

        Assertions.assertThat(strike).isEqualTo(2);
        Assertions.assertThat(ball).isEqualTo(0);
    }

    @Test
    public void TEST1_3_only_ball() {
        List<Integer> computerNumber = List.of(1, 2, 3);
        List<Integer> userNumber = List.of(3, 1, 2);

        int ball = 0;
        int strike = 0;
        for (int i = 0; i < computerNumber.size(); i++) {
            if (computerNumber.get(i) == userNumber.get(i)) {
                strike++;
            } else if (computerNumber.contains(userNumber.get(i))) {
                ball++;
            }
        }
        printResult(strike, ball);

        Assertions.assertThat(strike).isEqualTo(0);
        Assertions.assertThat(ball).isEqualTo(3);
    }

    @Test
    public void TEST1_3_ball_strike() {
        List<Integer> computerNumber = List.of(1, 2, 3);
        List<Integer> userNumber = List.of(3, 2, 1);

        int ball = 0;
        int strike = 0;
        for (int i = 0; i < computerNumber.size(); i++) {
            if (computerNumber.get(i) == userNumber.get(i)) {
                strike++;
            } else if (computerNumber.contains(userNumber.get(i))) {
                ball++;
            }
        }
        printResult(strike, ball);

        Assertions.assertThat(strike).isEqualTo(1);
        Assertions.assertThat(ball).isEqualTo(2);
    }

    @Test
    public void TEST1_3_nothing() {
        List<Integer> computerNumber = List.of(1, 2, 3);
        List<Integer> userNumber = List.of(4, 5, 6);

        int ball = 0;
        int strike = 0;
        for (int i = 0; i < computerNumber.size(); i++) {
            if (computerNumber.get(i) == userNumber.get(i)) {
                strike++;
            } else if (computerNumber.contains(userNumber.get(i))) {
                ball++;
            }
        }
        printResult(strike, ball);

        Assertions.assertThat(strike).isEqualTo(0);
        Assertions.assertThat(ball).isEqualTo(0);
    }

    public void printResult(int strike, int ball) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (ball != 0) {
            System.out.println(ball + "볼");
        } else if (strike != 0) {
            System.out.println(strike + "스트라이크");
        }

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
