package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

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
    void 볼_스트라이크_출력_테스트() {
        LinkedHashMap<String, Integer> strikesAndBalls = new LinkedHashMap<String, Integer>() {{
            put("strike", 2);
            put("ball", 1);
        }};

        Application.gameResult(strikesAndBalls);

        assertThat(output()).isEqualTo("1볼 2스트라이크");
    }

    @Test
    void 볼_스트라이크_계산_테스트() {
        LinkedHashMap<Integer, Integer> computers = new LinkedHashMap<Integer, Integer>(){{
            put(0,5);
            put(1,1);
            put(2,9);
        }};
        LinkedHashMap<Integer, Integer> users = new LinkedHashMap<Integer, Integer>(){{
            put(0,9);
            put(1,1);
            put(2,5);
        }};
        LinkedHashMap<String, Integer> result = new LinkedHashMap<String, Integer>();

        result = Application.comparing(computers, users);
        assertThat(result).containsEntry("strike",1);
        assertThat(result).containsEntry("ball",2);

    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
