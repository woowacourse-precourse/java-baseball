package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import baseball.Opponent;
import baseball.HintMaker;
import baseball.HintMessage;
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
    void opponentHaveThreeNumber(){
        Opponent cpu = new Opponent();
        assertThat(cpu.getNumbers().size()).isEqualTo(3);
    }

    @Test
    void makeHintTest(){
        Opponent cpu = new Opponent();
        List<Integer> cpu_numbers = List.of(1,2,3);
        cpu.setNumbers(cpu_numbers);
        HintMaker hintMaker = new HintMaker(cpu);

        assertThat(hintMaker.getHintby("123")).isEqualTo("30");
        assertThat(hintMaker.getHintby("231")).isEqualTo("03");
        assertThat(hintMaker.getHintby("124")).isEqualTo("20");
        assertThat(hintMaker.getHintby("132")).isEqualTo("12");
    }

    @Test
    void printMessageTest(){
        Opponent cpu = new Opponent();
        List<Integer> cpu_numbers = List.of(1,2,3);
        cpu.setNumbers(cpu_numbers);
        HintMaker hintMaker = new HintMaker(cpu);

        String hint;

        hint = hintMaker.getHintby("123");
        assertThat(HintMessage.getMessage(hint)).isEqualTo("3스트라이크");
        hint = hintMaker.getHintby("231");
        assertThat(HintMessage.getMessage(hint)).isEqualTo("3볼 ");
        hint = hintMaker.getHintby("132");
        assertThat(HintMessage.getMessage(hint)).isEqualTo("2볼 1스트라이크");
        hint = hintMaker.getHintby("456");
        assertThat(HintMessage.getMessage(hint)).isEqualTo("낫싱");

    }

    @Test
    void validatorTest(){
        assertThatThrownBy(() -> Validator.checkStart("1234"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.checkStart("-1234"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.checkStart("-12"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.checkStart("131"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.checkStart("111"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
