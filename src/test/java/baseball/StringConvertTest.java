package baseball;

import baseball.game.utils.StringConverter;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class StringConvertTest {

    @Nested
    @DisplayName("ToInteger 메서드는")
    class Describe_ToInteger {

        @Nested
        @DisplayName("크기 1의 String이 주어지고")
        class Given_Size_1_String {
            @Nested
            @DisplayName("숫자라면")
            class Given_Number {

                @Test
                @DisplayName("integer을 반환한다.")
                void Then_return_integer() {
                    String input = "5";
                    int result = StringConverter.toInteger(input);
                    Assertions.assertThat(result).isEqualTo(5);
                }
            }

            @Nested
            @DisplayName("숫자가 아니라면")
            class Given_not_number_String {

                @Test
                @DisplayName("IllegalArgumentException을 반환한다.")
                void Then_return_IllegalArgumentException() {
                    String input = "5";
                    int result = StringConverter.toInteger(input);
                    Assertions.assertThat(result).isEqualTo(5);
                }
            }
        }

        @Nested
        @DisplayName("크기 2 이상의 String이 주어지면")
        class Given_size_1_over_String {
            @Test
            @DisplayName("IllegalArgumentException을 반환한다.")
            void Then_return_IllegalArgumentException() {
                String input = "51";

                Assertions.assertThatThrownBy(() -> StringConverter.toInteger(input))
                        .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("1글자만 입력할 수 있습니다.");
            }
        }
    }

    @Nested
    @DisplayName("toIntegerList 메서드는")
    class Describe_ToIntegerList {
        @Nested
        @DisplayName("연속된 숫자 String이 주어지면")
        class Given_Consecutively_Number_String {
            @Test
            @DisplayName("List<Integer>을 반환한다.")
            void Then_return_List_Integer() {
                String input = "123";

                Assertions.assertThat(StringConverter.toIntegerList(input)).isEqualTo(Arrays.asList(1, 2, 3));
            }
        }

        @Nested
        @DisplayName("연속된 숫자가 아닌 String이 주어지면")
        class Given_Not_Consecutively_Number_String {
            @Test
            @DisplayName("IllegalArgumentException을 반환한다.")
            void Then_return_List_Integer() {
                String input = "1a23";

                Assertions.assertThatThrownBy(() -> StringConverter.toIntegerList(input))
                        .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("숫자만 입력할 수 있습니다.");
            }
        }
    }
}
