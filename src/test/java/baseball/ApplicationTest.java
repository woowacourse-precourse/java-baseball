package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    Application game = new Application();

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

    @Test
    void 난수_생성_확인() {
        String randomThreeDigitNumberString = game.getRandomThreeDigitNumberString();
        String pattern = "^[1-9]{3}$";

        assertThat(Pattern.matches(pattern, randomThreeDigitNumberString)).isTrue();

        for (int i = 0; i < randomThreeDigitNumberString.length(); i++) {
            String indexDigitNumber = randomThreeDigitNumberString.charAt(i) + "";
            String checkOverlapString = randomThreeDigitNumberString.replace(indexDigitNumber, "");

            assertThat(checkOverlapString.length() < 2).isFalse();
        }
    }


    @Test
    void 사용자_입력과_정답_비교() {
        game.compareUserInputToAnswer("123", "321");
        game.compareUserInputToAnswer("123", "456");
        game.compareUserInputToAnswer("123", "123");

        assertThat(output()).contains("2볼 1스트라이크", "낫싱", "3스트라이크");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "3", "asd", "11", "12", "1345", " "})
    void 게임재시작_사용자입력_예외_테스트(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> game.restartGame())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"012", "233", "asd", "111", "12", "1345", "1", " "})
    void 게임시작후_예외_테스트(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
