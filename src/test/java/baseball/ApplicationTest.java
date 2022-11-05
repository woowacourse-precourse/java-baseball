package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void randomNumber_중복확인() {
        List<Integer> randomNumber = Computer.createRandomNumber();

        assertThat(randomNumber.get(0)).isNotEqualTo(randomNumber.get(1));
        assertThat(randomNumber.get(0)).isNotEqualTo(randomNumber.get(2));
        assertThat(randomNumber.get(1)).isNotEqualTo(randomNumber.get(2));
    }

    @Test
    void randomNumber_길이확인() {
        List<Integer> randomNumber = Computer.createRandomNumber();

        assertThat(randomNumber.size()).isEqualTo(3);
    }

    @Test
    void should_IllegalArgumentException_When_NumberOverlap() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void should_IllegalArgumentException_When_NumberLengthIsNot3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void should_IllegalArgumentException_When_NumberIsNotDigit() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("number"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void should_IllegalArgumentException_When_NumberContain0() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("102"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void should_Strike_When_SamePositionSameNumber() {
        List<Integer> randomNumber = List.of(1, 2, 3);
        List<Integer> userNumber = List.of(1, 4, 5);
        String result = "1스트라이크";
        assertThat(Computer.getHint(userNumber, randomNumber)).isEqualTo(result);
    }

    @Test
    void should_Ball_When_SameNumber() {
        List<Integer> randomNumber = List.of(1, 2, 3);
        List<Integer> userNumber = List.of(4, 5, 1);
        String result = "1볼";
        assertThat(Computer.getHint(userNumber, randomNumber)).isEqualTo(result);
    }

    @Test
    void should_Nothing_When_NothingSame() {
        List<Integer> randomNumber = List.of(1, 2, 3);
        List<Integer> userNumber = List.of(4, 5 , 6);
        String result = "낫싱";
        assertThat(Computer.getHint(userNumber, randomNumber)).isEqualTo(result);
    }

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
