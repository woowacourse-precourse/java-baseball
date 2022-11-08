package baseball;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class UserTest {

    @Nested
    class checkInputForAnswerTest {

        @Test
        void caseNull() {
            User user = new User();
            user.input = "";
            assertThrowsExactly(IllegalArgumentException.class, () -> {
                user.checkInputForAnswer();
            });
        }

        @Test
        void caseNotNumeric() {
            User user = new User();
            user.input = "abc";
            assertThrowsExactly(IllegalArgumentException.class, () -> {
                user.checkInputForAnswer();
            });
        }

        @Test
        void caseLengthInvalid() {
            User user = new User();
            user.input = "1";
            assertThrowsExactly(IllegalArgumentException.class, () -> {
                user.checkInputForAnswer();
            });
        }

        @Test
        void caseContainsZero() {
            User user = new User();
            user.input = "012";
            assertThrowsExactly(IllegalArgumentException.class, () -> {
                user.checkInputForAnswer();
            });
        }

        @Test
        void caseHasSameNumber() {
            User user = new User();
            user.input = "122";
            assertThrowsExactly(IllegalArgumentException.class, () -> {
                user.checkInputForAnswer();
            });
        }

        @Test
        void caseValid() {
            User user = new User();
            user.input = "123";
            boolean resultValid = user.checkInputForAnswer();
            assertTrue(resultValid);
        }
    }

    @Nested
    class checkInputForOptionTest {

        @Test
        void caseNull() {
            User user = new User();
            user.input = "";
            assertThrowsExactly(IllegalArgumentException.class, () -> {
                user.checkInputForOption();
            });
        }

        @Test
        void caseNotNumeric() {
            User user = new User();
            user.input = "a";
            assertThrowsExactly(IllegalArgumentException.class, () -> {
                user.checkInputForOption();
            });
        }

        @Test
        void caseLengthInvalid() {
            User user = new User();
            user.input = "12";
            assertThrowsExactly(IllegalArgumentException.class, () -> {
                user.checkInputForOption();
            });
        }

        @Test
        void caseOptionOne() {
            User user = new User();
            user.input = "1";
            boolean resultOptionOne = user.checkInputForOption();
            assertTrue(resultOptionOne);
        }

        @Test
        void caseOptionTwo() {
            User user = new User();
            user.input = "2";
            boolean resultOptionTwo = user.checkInputForOption();
            assertTrue(resultOptionTwo);
        }
    }

}