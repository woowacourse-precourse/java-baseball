package baseball.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("잘못된_값을_입력하는_경우_IllegalArgumentException를_발생시킨다")
public class ValidationTest {

    Validation validation = new Validation();

    @Test
    void 세자리_숫자가_아닌_경우_예외_테스트() {

        assertThatThrownBy(() ->validation.validatePlayerNumbers(List.of(1,2,3,5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세자리 숫자만 입력 가능합니다.");
    }

    @Test
    void 입력값이_1에서_9범위내의_숫자가_아닌경우() {

        assertThatThrownBy(() ->validation.validatePlayerNumbers(List.of(1,2,36)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("각 자릿수는 1-9 사이의 숫자만 입력 가능합니다.");
    }

    @Test
    void 숫자가_중복되는_경우_예외_테스트() {

        assertThatThrownBy(() ->validation.validatePlayerNumbers(List.of(1,2,2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자를 입력할 수 없습니다.");
    }
}
