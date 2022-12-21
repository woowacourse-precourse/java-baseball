package baseball.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.exception.UserInputException;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class UserFunctionTest {
    UserFunction user = new UserFunction();

    @Nested
    class LengthCheckTest {
        String inputTest = "123";

        @Test
        void inputLengthCheck() {
            assertThat(user.inputLengthCheck(inputTest))
                    .isTrue();
        }

        @Test
        void inputLengthCheck_len() {
            int arrLen = inputTest.length();
            int result = 3;
            assertThat(arrLen)
                    .isEqualTo(result);
        }

        @Test
        void inputLengthCheck_error_len_2() {
            assertThat(user.inputLengthCheck("12"))
                    .isFalse();
        }

        @Test
        void inputLengthCheck_error_len_4() {
            assertThat(user.inputLengthCheck("1234"))
                    .isFalse();
        }

        @Test
        void inputLengthCheck_error_len_5() {
            assertThat(user.inputLengthCheck("12345"))
                    .isFalse();
        }
    }

    @Nested
    class InputCheckIntTest {
        String inputTest;

        @Test
        void inputCheckInt() {
            inputTest = "123";
            assertThat(user.inputCheckInt(inputTest))
                    .isTrue();
        }

        @Test
        void inputCheckInt_error_1() {
            inputTest = "일이삼";
            assertThat(user.inputCheckInt(inputTest))
                    .isFalse();
        }

        @Test
        void inputCheckInt_error_2() {
            inputTest = "1A3";
            assertThat(user.inputCheckInt(inputTest))
                    .isFalse();
        }

        @Test
        void inputCheckInt_error_3() {
            inputTest = "!@#";
            assertThat(user.inputCheckInt(inputTest))
                    .isFalse();
        }

        @Test
        void inputCheckInt_error_4() {
            inputTest = "!@#";
            assertThat(user.inputCheckInt(inputTest))
                    .isFalse();
        }

        @Test
        void inputCheckInt_error_5() {
            inputTest = "one";
            assertThat(user.inputCheckInt(inputTest))
                    .isFalse();
        }
    }

    @Nested
    class InputTextMakeToIntArrTest {
        String inputTest;

        @Test
        void inputToIntArr() {
            inputTest = "123";
            assertThat(user.inputCheckInt(inputTest))
                    .isTrue();
        }

        @Test
        void inputToIntArr_error() {
            inputTest = "1234";
            assertThat(user.inputCheckInt(inputTest))
                    .isTrue();
        }
    }

    @Nested
    class IntArrValidationTest {
        @Test
        void intArrValidation() {
            int[] intArr = {1, 2, 3};
            assertThat(user.intArrValidation(intArr))
                    .isTrue();

        }

        @Test
        void intArrValidation_error() {
            int[] intArr = {1, 2, 10};
            assertThat(user.intArrValidation(intArr))
                    .isFalse();
        }
    }

    @Nested
    class IntArrToCollectionListTest {
        @Test
        void intArrToCollectionList() {
            int[] intArr = {1, 2, 3};
            List<Integer> list = user.intArrToCollectionList(intArr);
            List<Integer> result = List.of(1, 2, 3);
            assertThat(list).containsAll(result);
        }
    }

    @Nested
    class CollectionListValidationTest {
        @Test
        void collectionListValidation() {
            List<Integer> list = List.of(1, 2, 3);
            assertThat(user.collectionListValidation(list))
                    .isTrue();
        }

        @Test
        void collectionListValidation_error() {
            List<Integer> list = List.of(1, 2, 2);
            assertThat(user.collectionListValidation(list))
                    .isFalse();
        }
    }


}