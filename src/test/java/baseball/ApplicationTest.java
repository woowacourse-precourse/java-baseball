package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void randomNumber_중복확인() {
        String randomNumber = Computer.createRandomNumber();

        assertThat(randomNumber.charAt(0)).isNotEqualTo(randomNumber.charAt(1));
        assertThat(randomNumber.charAt(0)).isNotEqualTo(randomNumber.charAt(2));
        assertThat(randomNumber.charAt(1)).isNotEqualTo(randomNumber.charAt(2));
    }

    @Test
    void randomNumber_길이확인() {
        String randomNumber = Computer.createRandomNumber();

        assertThat(randomNumber.length()).isEqualTo(3);
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
    void should_3Strike_When_allSame() {
        String randomNumber = "123";
        String userNumber = "123";
        String gameResult = "3스트라이크";
        assertThat(GameController.hint(userNumber, randomNumber)).isEqualTo(gameResult);
    }

    @Test
    void should_Strike_When_SamePositionSameNumber() {
        String randomNumber = "123";
        String userNumber = "145";
        String gameResult = "1스트라이크";
        assertThat(GameController.hint(userNumber, randomNumber)).isEqualTo(gameResult);
    }

    @Test
    void should_Ball_When_SameNumber() {
        String randomNumber = "123";
        String userNumber = "451";
        String gameResult = "1볼";
        assertThat(GameController.hint(userNumber, randomNumber)).isEqualTo(gameResult);
    }

    @Test
    void should_Nothing_When_NothingSame() {
        String randomNumber = "123";
        String userNumber = "456";
        String gameResult = "낫싱";
        assertThat(GameController.hint(userNumber, randomNumber)).isEqualTo(gameResult);
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