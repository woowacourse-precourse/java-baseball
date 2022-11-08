package baseball;

import baseball.model.player.BaseBallNumber;
import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BaseBallNumberTest {

    @Nested
    @DisplayName("BaseBallNumber Class")
    class BaseBallNumberKoTest {

        @Nested
        @DisplayName("validateSize method is")
        class DescribeValidateSize {

            @Test
            @DisplayName("empty")
            void validateSizeEmpty() {
                Assertions.assertThatThrownBy(() -> {
                    BaseBallNumber baseBallNumber = new BaseBallNumber(Collections.emptyList());
                }).isInstanceOf(IllegalArgumentException.class);
            }

            @Test
            @DisplayName("less")
            void validateSizeLess() {
                Assertions.assertThatThrownBy(() -> {
                    BaseBallNumber baseBallNumber = new BaseBallNumber(List.of('1', '2'));
                }).isInstanceOf(IllegalArgumentException.class);
            }

            @Test
            @DisplayName("more")
            void validateSizeMore() {
                Assertions.assertThatThrownBy(() -> {
                    BaseBallNumber baseBallNumber = new BaseBallNumber(List.of('1', '2', '3', '4'));
                }).isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        @DisplayName("validateDuplicate method is")
        class DescribeValidateDuplicate {

            @Test
            @DisplayName("two")
            void validateDuplicateTwo() {
                Assertions.assertThatThrownBy(() -> {
                    BaseBallNumber baseBallNumber = new BaseBallNumber(List.of('1', '1', '2'));
                }).isInstanceOf(IllegalArgumentException.class);
            }

            @Test
            @DisplayName("three")
            void validateDuplicateThree() {
                Assertions.assertThatThrownBy(() -> {
                    BaseBallNumber baseBallNumber = new BaseBallNumber(List.of('1', '1', '1'));
                }).isInstanceOf(IllegalArgumentException.class);
            }
        }
    }
}