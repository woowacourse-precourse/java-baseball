package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.HashMap;
import java.util.HashSet;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
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
    void 기능1_랜덤넘버_테스트 () {
        HashSet<Character> checkDuplicate = new HashSet<>();
        String computerNumber = Application.getRandomNumbers();
        computerNumber.chars().forEach(item -> checkDuplicate.add((char) item));
        assertThat(checkDuplicate.size()).isEqualTo(3);
    }

    @Test
    void 기능3_사용자넘버_테스트 () {
        assertThatThrownBy(() -> Application.checkUserNumbersValidation("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 기능4_StrikeBall_테스트 () {
        assertThat(Application.countStrikeBall("123", "312")).isEqualTo("03");
        assertThat(Application.countStrikeBall("123", "412")).isEqualTo("02");
        assertThat(Application.countStrikeBall("123", "123")).isEqualTo("30");
    }

    @Test
    void 기능4_결과문출력_테스트 () {
        assertThat(Application.getMatchResult("123", "312")).isEqualTo("3볼");
        assertThat(Application.getMatchResult("123", "412")).isEqualTo("2볼");
        assertThat(Application.getMatchResult("123", "134")).isEqualTo("1볼 1스트라이크");
        assertThat(Application.getMatchResult("123", "123")).isEqualTo("3스트라이크");
        assertThat(Application.getMatchResult("123", "465")).isEqualTo("낫싱");
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
