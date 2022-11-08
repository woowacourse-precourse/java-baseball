package baseball;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class UserTest {


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