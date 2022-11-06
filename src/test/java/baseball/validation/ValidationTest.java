package baseball.validation;

import baseball.utils.validation.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("잘못된_값을_입력하는_경우_IllegalArgumentException를_발생시킨다")
public class ValidationTest {

    Validation validation = new Validation();

    @Test
    void 세자리_숫자가_아닌_경우_예외_테스트() {

        assertThatThrownBy(() ->validation.validatePlayerNumbers("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세자리 숫자만 입력 가능합니다.");
    }

    @Test
    void 숫자_이외의_문자를_입력하는_경우_예외_테스트() {

        assertThatThrownBy(() ->validation.validatePlayerNumbers("aderwe"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력 가능합니다.");
    }

    @Test
    void 숫자에_0_이_포함되어있는_경우_예외_테스트() {

        assertThatThrownBy(() ->validation.validatePlayerNumbers("105"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("각 자릿수는 1-9 사이입니다.");
    }
    @Test
    void 숫자가_중복되는_경우_예외_테스트() {

        assertThatThrownBy(() ->validation.validatePlayerNumbers("141"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자를 입력할 수 없습니다.");
    }
}
