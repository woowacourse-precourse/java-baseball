package baseball;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class UserTest {

    @Nested
    @DisplayName("받은 문자열을 리스트로 변환")
    class StringToSeparatedIntegerList {

        @Test
        @DisplayName("에러가 나지 않을 때")
        void noException() throws Exception {
            //Given
            User user = new User();
            Method stringToSeparatedIntegerList = User.class.getDeclaredMethod("stringToSeparatedIntegerList", String.class);
            stringToSeparatedIntegerList.setAccessible(true);

            String input = "123";
            //When
            List<Integer> resultList = (List<Integer>) stringToSeparatedIntegerList.invoke(user, input);

            //Then
            assertThat(resultList).isEqualTo(List.of(1, 2, 3));
        }

        @Test
        @DisplayName("문자가 포함되어 있을 때")
        void hasLetter() throws Exception {
            //Given
            User user = new User();
            Method stringToSeparatedIntegerList = User.class.getDeclaredMethod("stringToSeparatedIntegerList", String.class);
            stringToSeparatedIntegerList.setAccessible(true);

            String input = "1a3";
            //When
            assertThatThrownBy(() -> stringToSeparatedIntegerList.invoke(user, input))
                    .getCause()
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("입력의 길이가 맞지 않을 때")
        void inputLengthException() throws Exception {
            //Given
            User user = new User();
            Method stringToSeparatedIntegerList = User.class.getDeclaredMethod("stringToSeparatedIntegerList", String.class);
            stringToSeparatedIntegerList.setAccessible(true);

            String input = "1234";
            //When
            assertThatThrownBy(() -> stringToSeparatedIntegerList.invoke(user, input))
                    .getCause()
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("유저의 입력을 받는 메소드")
    class GetUserPredictedAnswer {

        @Test
        @DisplayName("에러 없는 입력")
        void noException() throws Exception {
            //Given
            User user = new User();
            ByteArrayInputStream in = new ByteArrayInputStream("123".getBytes());
            System.setIn(in);

            //When
            List<Integer> userPredictedAnswer = user.getUserPredictedAnswer();

            //Then
            assertThat(userPredictedAnswer).isEqualTo(List.of(1, 2, 3));
        }

        @Test
        @DisplayName("중복 숫자 에러")
        void duplicatedNumber() throws Exception {
            //Given
            User user = new User();
            ByteArrayInputStream in = new ByteArrayInputStream("112".getBytes());
            System.setIn(in);

            //When, Then
            assertThatThrownBy(() -> user.getUserPredictedAnswer())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("입력 길이 예외")
        void inputLengthException() throws Exception {
            //Given
            User user = new User();
            ByteArrayInputStream in = new ByteArrayInputStream("1234".getBytes());
            System.setIn(in);

            //When, Then
            assertThatThrownBy(() -> user.getUserPredictedAnswer())
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }
}