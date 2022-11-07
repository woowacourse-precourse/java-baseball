package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseBallTest {

    List<Integer> computerNumber;

    List<Integer> playerNumber;

    private int strike;

    private int ball;

    @BeforeEach
    void before() {
        computerNumber = new ArrayList<>();
        playerNumber = new ArrayList<>();
        strike = 0;
        ball = 0;
    }

    @DisplayName("strike 개수 테스트")
    @Test
    public void strike_count_check() {
        computerNumber = Arrays.asList(1, 4, 3);
        playerNumber = Arrays.asList(1, 4, 5);

        strike = BaseBall.countStrike(computerNumber, playerNumber);
        Assertions.assertThat(strike).isEqualTo(2);
    }

    @DisplayName("ball 개수 테스트")
    @Test
    public void ball_count_check() {
        computerNumber = Arrays.asList(1, 2, 3);
        playerNumber = Arrays.asList(5, 1, 2);

        strike = BaseBall.countStrike(computerNumber, playerNumber);
        ball = BaseBall.countBall(strike, computerNumber, playerNumber);
        Assertions.assertThat(ball).isEqualTo(2);
    }

    @DisplayName("Nothing test")
    @Test
    public void nothing_check() {
        computerNumber = Arrays.asList(1, 2, 3);
        playerNumber = Arrays.asList(4, 5, 6);

        strike = BaseBall.countStrike(computerNumber, playerNumber);
        ball = BaseBall.countBall(strike, computerNumber, playerNumber);

        Assertions.assertThat(strike).isEqualTo(0);
        Assertions.assertThat(ball).isEqualTo(0);
    }

    @DisplayName("1 ball test")
    @Test
    public void one_ball_check() {
        computerNumber = Arrays.asList(1, 2, 3);
        playerNumber = Arrays.asList(6, 1, 5);

        strike = BaseBall.countStrike(computerNumber, playerNumber);
        ball = BaseBall.countBall(strike, computerNumber, playerNumber);

        Assertions.assertThat(strike).isEqualTo(0);
        Assertions.assertThat(ball).isEqualTo(1);
    }

    @DisplayName("2 ball test")
    @Test
    public void two_ball_test() {
        computerNumber = Arrays.asList(1, 2, 3);
        playerNumber = Arrays.asList(4, 1, 2);

        strike = BaseBall.countStrike(computerNumber, playerNumber);
        ball = BaseBall.countBall(strike, computerNumber, playerNumber);

        Assertions.assertThat(strike).isEqualTo(0);
        Assertions.assertThat(ball).isEqualTo(2);
    }

    @DisplayName("3 ball test")
    @Test
    public void three_ball_check() {
        computerNumber = Arrays.asList(1, 2, 3);
        playerNumber = Arrays.asList(3, 1, 2);

        strike = BaseBall.countStrike(computerNumber, playerNumber);
        ball = BaseBall.countBall(strike, computerNumber, playerNumber);

        Assertions.assertThat(strike).isEqualTo(0);
        Assertions.assertThat(ball).isEqualTo(3);
    }

    @DisplayName("1 strike test")
    @Test
    public void one_strike_test() {
        computerNumber = Arrays.asList(1, 2, 3);
        playerNumber = Arrays.asList(1, 4, 5);

        strike = BaseBall.countStrike(computerNumber, playerNumber);
        ball = BaseBall.countBall(strike, computerNumber, playerNumber);

        Assertions.assertThat(strike).isEqualTo(1);
        Assertions.assertThat(ball).isEqualTo(0);
    }

    @DisplayName("2 strike test")
    @Test
    public void two_strike_test() {
        computerNumber = Arrays.asList(1, 2, 3);
        playerNumber = Arrays.asList(1, 2, 6);

        strike = BaseBall.countStrike(computerNumber, playerNumber);
        ball = BaseBall.countBall(strike, computerNumber, playerNumber);

        Assertions.assertThat(strike).isEqualTo(2);
        Assertions.assertThat(ball).isEqualTo(0);
    }

    @DisplayName("3 strike test")
    @Test
    public void three_strike_test() {
        computerNumber = Arrays.asList(1, 2, 3);
        playerNumber = Arrays.asList(1, 2, 3);

        strike = BaseBall.countStrike(computerNumber, playerNumber);
        ball = BaseBall.countBall(strike, computerNumber, playerNumber);

        Assertions.assertThat(strike).isEqualTo(3);
        Assertions.assertThat(ball).isEqualTo(0);
    }

    @DisplayName("ball & strike test")
    @Test
    public void ball_strike_check() {
        computerNumber = Arrays.asList(1, 2, 3);
        playerNumber = Arrays.asList(1, 4, 2);

        strike = BaseBall.countStrike(computerNumber, playerNumber);
        ball = BaseBall.countBall(strike, computerNumber, playerNumber);

        Assertions.assertThat(strike).isEqualTo(1);
        Assertions.assertThat(ball).isEqualTo(1);

    }
}
