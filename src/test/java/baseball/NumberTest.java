package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import validator.InputValidator;

import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest extends NsTest {

    @Test
    void 컴퓨터_숫자_검증() {
        BaseballNumber baseballNumber = new BaseballNumber();
        List<Integer> numbers = baseballNumber.makeRandomNumber();

        String number = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        assertThat(InputValidator.isRightInput(number)).isTrue();
    }

    @Test
    void 입력_숫자_예외_공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException((String) null))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 입력_숫자_예외_큰_길이() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2613"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 입력_숫자_예외_작은_길이() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("26"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 입력_숫자_예외_범위() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("206"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 입력_숫자_예외_중복() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("262"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 입력_숫자_예외_문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("#26"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 입력_숫자_예외_영어() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("26a"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 입력_종료_예외_공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException((String) null))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 입력_종료_예외_범위() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("3"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 입력_종료_예외_문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("#"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
