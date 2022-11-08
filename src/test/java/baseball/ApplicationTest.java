package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

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
    void 랜덤값_생성() {
        int randomValue = Application.getRandomValue();
        int len = 0;
        Set<Integer> set = new HashSet<>();
        for (; randomValue > 0; len++) {
            int num = randomValue % 10;
            randomValue /= 10;
            set.add(num);
        }

        assertThat(len).isEqualTo(3);
        assertThat(set.size()).isEqualTo(3);

    }

    @Test
    void 입력값_유효성_검증_성공() {
        boolean valid = Application.validationOfInput("123");
        assertThat(valid).isTrue();
    }

    @Test
    void 입력값_유효성_검증_실패_중복값() {
        boolean valid = Application.validationOfInput("111");
        assertThat(valid).isFalse();
    }

    @Test
    void 입력값_유효성_검증_실패_길이() {
        boolean valid = Application.validationOfInput("1234");
        assertThat(valid).isFalse();
    }

    @Test
    void 입력값_유효성_검증_실패_숫자이외의값() {
        boolean valid = Application.validationOfInput("asd");
        assertThat(valid).isFalse();
    }

    @Test
    void 숫자를_배열로_바꾸기() {
        int[] intToArr = Application.getIntToArr(432);
        assertThat(intToArr[4]).isEqualTo(3);
        assertThat(intToArr[3]).isEqualTo(2);
        assertThat(intToArr[2]).isEqualTo(1);
    }

    @Test
    void 볼_스트라이크_계산하기() {
        int input =321;
        int[] randoms = {0,3,2,1,0,0,0,0,0,0};
        int[] result = Application.compareToNum(input, randoms);
        assertThat(result[0]).isEqualTo(2);
        assertThat(result[1]).isEqualTo(1);
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
