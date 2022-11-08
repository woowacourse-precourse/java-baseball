package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BaseballNumberTest {

    @Test
    @DisplayName("validateRangeForAll 메소드 사용 시 List에 1~9범위 초과하는 요소 있을 시 예외 발생")
    void validate_range_for_all_test(){
        List<Integer> nums = List.of(10,1,2);
        BaseballNumber baseballNumber = new BaseballNumber();
        assertThatThrownBy(() -> baseballNumber.validateRangeForAll(nums))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 숫자가 범위를 초과했습니다.");
    }

    @Test
    @DisplayName("validateDigit 메소드 사용 시 3자리 이상 숫자일 때 예외 발생")
    void validate_digit_test(){
        List<Integer> nums = List.of(1,2,3,4);
        BaseballNumber baseballNumber = new BaseballNumber();
        assertThatThrownBy(() -> baseballNumber.validateDigit(nums))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세 자리 수가 아닙니다.");
    }

    @Test
    @DisplayName("validateDuplication 메소드 사용 시 중복되는 수가 있을 때 예외 발생")
    void validate_duplication_test(){
        List<Integer> nums = List.of(1,1,1);
        BaseballNumber baseballNumber = new BaseballNumber();
        assertThatThrownBy(() -> baseballNumber.validateDuplication(nums))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 수가 있습니다.");
    }


}