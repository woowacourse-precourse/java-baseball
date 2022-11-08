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

    @Test
    void selectNumbers_임의의_수_3개_리스트에_넣어서_반환() {
        int size = Application.selectNumbers().size();
        int firstNumber = Application.selectNumbers().get(0);
        int secondNumber = Application.selectNumbers().get(1);
        int thirdNumber = Application.selectNumbers().get(2);

        assertThat(size).isEqualTo(3);
        assertThat(firstNumber).isNotEqualTo(secondNumber);
        assertThat(secondNumber).isNotEqualTo(thirdNumber);
        assertThat(thirdNumber).isNotEqualTo(firstNumber);
    }

    @Test
    void validateUserNumbers_사용자가_조건에_부합하지_않는_수를_입력했을_때_예외발생() {
        String input = "1234";

        assertThatThrownBy(() -> Application.validateUserNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세자리가 아닌 수를 입력하였습니다.");

        String input2 = "a13";

        assertThatThrownBy(() -> Application.validateUserNumbers(input2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닌 값을 입력하였습니다.");

        String input3 = "112";

        assertThatThrownBy(() -> Application.validateUserNumbers(input3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 수를 입력하였습니다.");
    }

    @Test
    void addToList_입력받은_값을_리스트에_추가() {
        String input = "123";

        assertThat(Application.addToList(input)).contains(1, 2, 3);
    }

    @Test
    void countCount_컴퓨터의_숫자와_입력받은_수를_비교해_스트라이크_볼_나싱을_반환() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> input = List.of(4, 5, 6);
        List<Integer> input2 = List.of(3, 1, 2);
        List<Integer> input3 = List.of(1, 2, 3);
        List<Integer> input4 = List.of(1, 4, 5);
        List<Integer> input5 = List.of(3, 2, 1);
        List<Integer> input6 = List.of(3, 6, 7);
        List<Integer> input7 = List.of(8, 2, 3);
        List<Integer> input8 = List.of(3, 1, 9);
        List<Integer> input9 = List.of(6, 1, 3);

        assertThat(Application.countCount(computer, input)).isEqualTo(List.of(0, 0, 3));
        assertThat(Application.countCount(computer, input2)).isEqualTo(List.of(0, 3, 0));
        assertThat(Application.countCount(computer, input3)).isEqualTo(List.of(3, 0, 0));
        assertThat(Application.countCount(computer, input4)).isEqualTo(List.of(1, 0, 2));
        assertThat(Application.countCount(computer, input5)).isEqualTo(List.of(1, 2, 0));
        assertThat(Application.countCount(computer, input6)).isEqualTo(List.of(0, 1, 2));
        assertThat(Application.countCount(computer, input7)).isEqualTo(List.of(2, 0, 1));
        assertThat(Application.countCount(computer, input8)).isEqualTo(List.of(0, 2, 1));
        assertThat(Application.countCount(computer, input9)).isEqualTo(List.of(1, 1, 1));
    }

    @Test
    void isRestart_게임을_한번_더_할지_결정_1과2_이외의_값입력시_예외발생() {
        String input = "1";
        String input2 = "2";
        String input3 = "a";

        assertThat(Application.isRestart(input)).isEqualTo(true);
        assertThat(Application.isRestart(input2)).isEqualTo(false);
        assertThatThrownBy(() -> Application.isRestart(input3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1, 2 이외의 값을 입력했습니다.");
    }

    @Test
    void printCount_볼카운트를_형식에_맞게_출력() {
        List<Integer> input = List.of(3, 0, 0);
        List<Integer> input2 = List.of(0, 3, 0);
        List<Integer> input3 = List.of(0, 0, 3);
        List<Integer> input4 = List.of(1, 2, 0);
        List<Integer> input5 = List.of(1, 0, 2);
        List<Integer> input6 = List.of(0, 1, 2);
        List<Integer> input7 = List.of(1, 1, 1);

        assertThat(Application.printCount(input)).isEqualTo("3스트라이크");
        assertThat(Application.printCount(input2)).isEqualTo("3볼");
        assertThat(Application.printCount(input3)).isEqualTo("낫싱");
        assertThat(Application.printCount(input4)).isEqualTo("2볼 1스트라이크");
        assertThat(Application.printCount(input5)).isEqualTo("1스트라이크");
        assertThat(Application.printCount(input6)).isEqualTo("1볼");
        assertThat(Application.printCount(input7)).isEqualTo("1볼 1스트라이크");

    }
}
