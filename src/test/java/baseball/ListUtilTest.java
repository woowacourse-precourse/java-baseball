package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ListUtilTest {

    @Nested
    @DisplayName("중복이 아닌 숫자를 찾는 메소드")
    class GetRandomIntegerExcludeInList {


        @RepeatedTest(1000)
        @DisplayName("빈 리스트가 들어갔을 때")
        void listIsEmpty() throws Exception {
            //Given
            Game game = new Game();
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

            //When
            List<Integer> answer = List.of();
            int number = ListUtil.getRandomIntegerExcludeInList(answer);

            //Then
            assertThat(numbers.contains(number)).isEqualTo(true);
        }

        @DisplayName("리스트가 1개 일떄")
        @RepeatedTest(1000)
        void listHasOneElement() throws Exception {
            //Given
            Game game = new Game();

            //When
            List<Integer> answer = List.of(1);
            int number = ListUtil.getRandomIntegerExcludeInList(answer);

            //Then
            assertThat(number).isNotEqualTo(1);
        }
    }


    @Nested
    @DisplayName("받은 문자열을 리스트로 변환")
    class StringToSeparatedIntegerList {

        @Test
        @DisplayName("에러가 나지 않을 때")
        void noException() throws Exception {
            //Given
            User user = new User();

            String input = "123";
            //When
            List<Integer> resultList = ListUtil.stringToSeparatedIntegerList(input, 3);

            //Then
            assertThat(resultList).isEqualTo(List.of(1, 2, 3));
        }

        @Test
        @DisplayName("문자가 포함되어 있을 때")
        void hasLetter() throws Exception {
            //Given
            User user = new User();

            String input = "1a3";
            //When
            assertThatThrownBy(() -> ListUtil.stringToSeparatedIntegerList(input, 3))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("입력의 길이가 맞지 않을 때")
        void inputLengthException() throws Exception {
            //Given
            User user = new User();

            String input = "1234";
            //When
            assertThatThrownBy(() -> ListUtil.stringToSeparatedIntegerList(input, 3))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("두 리스트 안에 같은 숫자의 갯수를 세는 메소드")
    class countSameNumberInLists {
        @Test
        @DisplayName("중복이 없을 때")
        void countZeroVerboseTest() throws Exception {
            //Given
            List<Integer> answer = List.of(1, 2, 3);
            List<Integer> guess = List.of(4, 5, 6);

            //When
            int cnt = ListUtil.countSameNumberInLists(guess, answer);

            //Then
            assertThat(cnt).isEqualTo(0);
        }

        @Test
        @DisplayName("중복이 2개일 때")
        void count2VerboseTest() throws Exception {
            List<Integer> answer = List.of(1, 2, 3);
            List<Integer> guess = List.of(3, 2, 5);

            //When
            int cnt = ListUtil.countSameNumberInLists(guess, answer);

            //Then
            assertThat(cnt).isEqualTo(2);
        }
    }

    @Nested
    @DisplayName("같은 위치에 같은 숫자가 있는지 찾는 메서드")
    class countSameNumberInSameLocationInLists {
        @Test
        @DisplayName("겹치는 숫자가 없을 때")
        void countNoStrike() throws Exception {
            List<Integer> answer = List.of(1, 2, 3);
            List<Integer> guess = List.of(3, 1, 2);

            //When
            Integer cnt = ListUtil.countSameNumberInSameLocationInLists(guess, answer);

            //Then
            assertThat(cnt).isEqualTo(0);
        }

        @Test
        @DisplayName("겹치는 숫자가 2개일 때")
        void count2Strike() throws Exception {
            List<Integer> answer = List.of(1, 2, 3);
            List<Integer> guess = List.of(6, 2, 3);

            //When
            Integer cnt = ListUtil.countSameNumberInSameLocationInLists(guess, answer);

            //Then
            assertThat(cnt).isEqualTo(2);
        }

        @Test
        @DisplayName("겹치는 숫자가 3개일 때")
        void countAllStrike() throws Exception {
            List<Integer> answer = List.of(1, 2, 3);
            List<Integer> guess = List.of(1, 2, 3);

            //When
            Integer cnt = ListUtil.countSameNumberInSameLocationInLists(guess, answer);

            //Then
            assertThat(cnt).isEqualTo(3);
        }
    }
}