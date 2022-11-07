package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
    void 난수생성() {
        List<Integer> randomNumber = Application.generateRandomNumber();

        assertThat(randomNumber.size()).isEqualTo(3);

        assertThat(randomNumber.stream().allMatch(v -> v >= 1 && v <= 9)).isTrue();

        List<Integer> differentRandomNumber = Application.generateRandomNumber();

        assertThat(randomNumber).isNotEqualTo(differentRandomNumber);
    }

    @Test
    void 맞힌_개수_확인(){
        List<Integer> randomNumber = List.of(1,3,5);

        Application.checkRightNumber("152",randomNumber);
        Application.checkRightNumber("357",randomNumber);
        Application.checkRightNumber("246",randomNumber);
        Application.checkRightNumber("135",randomNumber);

        assertThat(output()).contains("1볼 1스트라이크", "2볼","낫싱", "3스트라이크", "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Test
    void 게임종료(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("135", "1", "589", "2");
                    assertThat(output()).contains("3스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test()
    void throwIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("1354");
                    },
                    1, 3, 5, 5, 8, 9
            );
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("12a");
                    },
                    1, 3, 5, 5, 8, 9
            );
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            assertRandomNumberInRangeTest(
                    () -> {
                        run(" ");
                    },
                    1, 3, 5, 5, 8, 9
            );
        });

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
