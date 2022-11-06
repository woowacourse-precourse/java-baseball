package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.FactoryBasedNavigableIterableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class MultiDigitNumberTest {
    @Nested
    @DisplayName("MultiDigitNumber 객체 생성자는 사용자로부터 숫자를 입력받아 객체를 생성하는데,")
    class describe_multiDigitNumber_constructor{
        @Nested
        @DisplayName("입력으로 주어지는 숫자는")
        class describe_argument_of_constructor{
            @Test
            @DisplayName("3자리 수여야 한다.")
            void validate_filtering_number_not_3digit_number(){
                Assertions.assertThatThrownBy(() -> new MultiDigitNumber(1234)).isInstanceOf(IllegalArgumentException.class);
            }
            @Test
            @DisplayName("각 자리수가 중복되면 안된다.")
            void validate_filtering_number_has_duplicate_digit(){
                Assertions.assertThatThrownBy(() -> new MultiDigitNumber(112)).isInstanceOf(IllegalArgumentException.class);
            }
            @Test
            @DisplayName("각 자리수는 1-9사이의 값을 가져야 한다.")
            void validate_filtering_number_has_digit_outOfRange(){
                Assertions.assertThatThrownBy(() -> new MultiDigitNumber(102)).isInstanceOf(IllegalArgumentException.class);
                Assertions.assertThatThrownBy(() -> new MultiDigitNumber(012)).isInstanceOf(IllegalArgumentException.class);
                Assertions.assertThatThrownBy(() -> new MultiDigitNumber(960)).isInstanceOf(IllegalArgumentException.class);
            }

            @Test
            @DisplayName("주어진 조건을 만족하는 경우에만 생성이 가능하다.")
            void validate_approve_generateInstance_when_number_satisfying_allCondition(){
                for(int i = 0 ; i < 1000 ; i++){
                    boolean flag = true;

                    try {
                        if(!MultiDigitNumber.validateConsistOfThreeDigit(i)
                            || !MultiDigitNumber.validateEachSingleDigitIsNotDuplicate(MultiDigitNumber.convertMultiDigitNumberIntoSingleDigitList(i))){
                            flag = false;
                        }
                    }catch (IllegalArgumentException e){
                        flag = false;
                    }

                    if(flag){
                        new MultiDigitNumber(i);
                    }
                    else{
                        int finalI = i;
                        Assertions.assertThatThrownBy(() -> new MultiDigitNumber(finalI)).isInstanceOf(IllegalArgumentException.class);
                    }
                }
            }
        }
    }
}
