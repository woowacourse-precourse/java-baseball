package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FunctionTest {

    @Test
    public void TEST1_1() {
        List<Integer> computerNumbers = Utils.pickComputerNumber();

        Assertions.assertThat(computerNumbers).hasSize(3);
        Assertions.assertThat(computerNumbers.get(0)).isNotEqualTo(computerNumbers.get(1)).isNotEqualTo(computerNumbers.get(2));
    }

    @Test
    public void TEST1_3_Strike() {
        List<Integer> computerNumber = List.of(1, 2, 3);
        List<Integer> userNumber = List.of(1, 2, 3);

        int ball = 0;
        int strike = 0;
        for (int i = 0; i < computerNumber.size(); i++) {
            // strike 확인
            if (computerNumber.get(i) == userNumber.get(i)) {
                strike++;
            } else if (computerNumber.contains(userNumber.get(i))) {
                // ball 확인
                ball++;
            }
        }
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
            // strike 확인
            if (computerNumber.get(i) == userNumber.get(i)) {
                strike++;
            } else if (computerNumber.contains(userNumber.get(i))) {
                // ball 확인
                ball++;
            }
        }
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
        Assertions.assertThat(strike).isEqualTo(0);
        Assertions.assertThat(ball).isEqualTo(0);
    }


}
