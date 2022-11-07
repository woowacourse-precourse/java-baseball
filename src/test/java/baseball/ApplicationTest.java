package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @DisplayName("랜덤한 서로 다른 3자리 수를 생성하는 메서드")
    @Test
    void createRandomNumbersTest() {
        Computer computer = new Computer();
        List<Integer> list = computer.createRandomNumbers();
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.stream().allMatch(n -> n >= 1 && n <= 9)).isTrue();
        assertThat(list.stream().distinct().allMatch(n -> list.size() == 3)).isTrue();
    }

    @DisplayName("입력받은 값을 Integer타입으로 변환하는 메서드")
    @Test
    void toIntegerPlayerInputTest() {
        String inputTest = "352";
        Player player = new Player();
        List<Integer> playerInputNumber =  player.toIntegerPlayerInput(inputTest);
        for (int i = 0; i < 3; i++) {
            assertTrue(playerInputNumber.get(i) instanceof Integer == true);
        }
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
