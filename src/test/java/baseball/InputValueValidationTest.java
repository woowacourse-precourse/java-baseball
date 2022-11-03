package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class InputValueValidationTest{

    @Nested
    class IsNumberTest {
        @Test
        void case1() {
            InputValueValidation valueValidation = new InputValueValidation();
            assertThat(valueValidation.isNumber("123")).isEqualTo(true);
        }

        @Test
        void case2() {
            InputValueValidation valueValidation = new InputValueValidation();
            assertThat(valueValidation.isNumber("123aa")).isEqualTo(false);
        }


        @Test
        void case3() {
            InputValueValidation valueValidation = new InputValueValidation();
            assertThat(valueValidation.isNumber("adv")).isEqualTo(false);
        }
    }

    @Nested
    class IsLengthThreeTest {
        @Test
        void case1() {
            InputValueValidation valueValidation = new InputValueValidation();
            assertThat(valueValidation.isLengthThree("1233")).isEqualTo(false);
        }

        @Test
        void case2() {
            InputValueValidation valueValidation = new InputValueValidation();
            assertThat(valueValidation.isLengthThree("123")).isEqualTo(true);
        }
    }

    @Nested
    class NoDuplicatesTest {
        @Test
        void case1() {
            InputValueValidation valueValidation = new InputValueValidation();
            assertThat(valueValidation.noDuplicates("122")).isEqualTo(false);
        }

        @Test
        void case2() {
            InputValueValidation valueValidation = new InputValueValidation();
            assertThat(valueValidation.noDuplicates("787")).isEqualTo(false);
        }

        @Test
        void case3() {
            InputValueValidation valueValidation = new InputValueValidation();
            assertThat(valueValidation.noDuplicates("789")).isEqualTo(true);
        }
    }

    @Nested
    class IsValidTest {
        @Test
        void case1() {
            InputValueValidation valueValidation = new InputValueValidation();
            assertThat(valueValidation.noDuplicates("12fg1")).isEqualTo(false);
        }

        @Test
        void case2() {
            InputValueValidation valueValidation = new InputValueValidation();
            assertThat(valueValidation.noDuplicates("1234")).isEqualTo(false);
        }

        @Test
        void case3() {
            InputValueValidation valueValidation = new InputValueValidation();
            assertThat(valueValidation.noDuplicates("789")).isEqualTo(true);
        }
    }

}
