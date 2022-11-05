package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 컴퓨터의_수_제대로_생성되었는지_확인() {
        for (int i = 0; i < 1000; i++) {
            List<Integer> numArr = Application.makeComputerRandomNumber();
            assertThat(numArr).hasSize(3);

            assertThat(numArr.get(0))
                    .isNotEqualTo(numArr.get(1))
                    .isNotEqualTo(numArr.get(2));

            assertThat(numArr.get(1))
                    .isNotEqualTo(numArr.get(2));
        }
    }

    @Test
    void 잘못된_값을_입력했을_경우_예외처리가_정상적으로_이루어지는지_확인(){
        String input = "";
        boolean result = false;
        assertThatThrownBy(() -> Application.checkTheNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void Str에서_int형으로_정상적으로_변환되는지_확인(){
        String number = "123";
        int result = 123;
        assertThat(Application.changeStrToInt(number)).isEqualTo(result);
    }

    @Test
    void int형에서_list로_정상적으로_변환되는지_확인() {
        int number = 123;
        List<Integer> result = List.of(1, 2, 3);
        assertThat(Application.changeIntToList(number)).isEqualTo(result);
    }

    @Test
    void 중복된_숫자가_있는지_확인() {
        List<Integer> numArr = List.of(2, 1, 2);
        boolean result = true;
        assertThat(Application.isOverlap(numArr)).isEqualTo(result);
    }

    @Test
    void 세자리_숫자가_맞는지_확인() {
        List<Integer> numArr = List.of(1, 2, 3, 4);
        boolean result = true;
        assertThat(Application.isNotSizeThree(numArr)).isEqualTo(result);
    }

    @Test
    void 음수가_아닌지_확인() {
        int number = -1;
        boolean result = true;
        assertThat(Application.isNegativeNumber(number)).isEqualTo(result);
    }

    @Test
    void 입력에_0이_포함되어_있는지_확인() {
        List<Integer> numArr = List.of(0, 0, 1);
        boolean result = true;
        assertThat(Application.hasZero(numArr)).isEqualTo(result);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
