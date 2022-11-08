package baseball;

import baseball.game.utils.IntegerValidator;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class IntegerValidatorTest {

    private static final int GAME_NUMBER_SIZE = 3;
    private static final int START_INCLUSIVE_INTEGER = 1;
    private static final int END_INCLUSIVE_INTEGER = 9;

    @Nested
    @DisplayName("validatePresume 메서드는")
    class Describe_validatePresume {
        @Nested
        @DisplayName("List<Integer>이 주어졌을 때")
        class Given_Integer_List {
            @Nested
            @DisplayName("리스트 사이즈가 " + GAME_NUMBER_SIZE + " 이고")
            class When_Size_Correct {
                @Nested
                @DisplayName("중복된 숫자가 없고")
                class When_No_Duplicated {
                    @Nested
                    @DisplayName(START_INCLUSIVE_INTEGER + "부터 " + END_INCLUSIVE_INTEGER + "사이의 숫자가 아니면")
                    class When_Over_Range {
                        @Test
                        @DisplayName("IllegalArgumentException을 반환한다.")
                        void Then_return_IllegalArgumentException() {
                            List<Integer> input = Arrays.asList(0, 1, 2);
                            Assertions.assertThatThrownBy(() -> IntegerValidator.validatePresume(input))
                                    .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(
                                            START_INCLUSIVE_INTEGER + "~" + END_INCLUSIVE_INTEGER + "사이의 숫자만 입력할 수 있습니다.");
                        }
                    }
                }

                @Nested
                @DisplayName("중복된 숫자가 있다면")
                class When_Duplicated {
                    @Test
                    @DisplayName("IllegalArgumentException을 반환한다.")
                    void Then_return_IllegalArgumentException() {
                        List<Integer> input = Arrays.asList(1, 2, 2);
                        Assertions.assertThatThrownBy(() -> IntegerValidator.validatePresume(input))
                                .isInstanceOf(IllegalArgumentException.class)
                                .hasMessageContaining("중복된 숫자를 포함할 수 없습니다.");
                    }
                }
            }

            @Nested
            @DisplayName("리스트 사이즈가 " + GAME_NUMBER_SIZE + " 초과라면")
            class When_Size_Over {
                @Test
                @DisplayName("IllegalArgumentException을 반환한다.")
                void Then_return_IllegalArgumentException() {
                    List<Integer> input = Arrays.asList(1, 2, 3, 4);
                    Assertions.assertThatThrownBy(() -> IntegerValidator.validatePresume(input))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining(GAME_NUMBER_SIZE + "자리 숫자만 입력할 수 있습니다.");
                }
            }

            @Nested
            @DisplayName("리스트 사이즈가 " + GAME_NUMBER_SIZE + " 미만이라면")
            class When_Size_Under {
                @Test
                @DisplayName("IllegalArgumentException을 반환한다.")
                void Then_return_IllegalArgumentException() {
                    List<Integer> input = Arrays.asList(1, 2);
                    Assertions.assertThatThrownBy(() -> IntegerValidator.validatePresume(input))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining(GAME_NUMBER_SIZE + "자리 숫자만 입력할 수 있습니다.");
                }
            }
        }
    }

    @Nested
    @DisplayName("validateRestartChoice 메서드는")
    class Describe_validateRestartChoice {
        @Nested
        @DisplayName("int 입력이 주어졌을 때")
        class Given_Integer {
            @Nested
            @DisplayName("선택범위에 없는 숫자라면")
            class When_Not_In_Range {
                @Test
                @DisplayName("IllegalArgumentException을 반환한다.")
                void Then_return_IllegalArgumentException() {
                    int input = 3;
                    Assertions.assertThatThrownBy(() -> IntegerValidator.validateRestartChoice(input))
                            .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("선택 옵션에 없는 숫자입니다.");
                }
            }
        }
    }

}
