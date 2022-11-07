package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;

import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GameTest {


    @Nested
    @DisplayName("중복이 아닌 숫자를 찾는 메소드")
    class getRandomIntegerExcludeInList {


        @RepeatedTest(1000)
        @DisplayName("빈 리스트가 들어갔을 때")
        void listIsEmpty() throws Exception {
            //Given
            Game game = new Game();
            Method getRandomIntegerExcludeInList = Game.class.getDeclaredMethod("getRandomIntegerExcludeInList", List.class);
            getRandomIntegerExcludeInList.setAccessible(true);
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

            //When
            List<Integer> answer = List.of();
            int number = (int) getRandomIntegerExcludeInList.invoke(game, answer);

            //Then
            assertThat(numbers.contains(number)).isEqualTo(true);
        }

        @DisplayName("리스트가 1개 일떄")
        @RepeatedTest(1000)
        void listHasOneElement() throws Exception {
            //Given
            Game game = new Game();
            Method getRandomIntegerExcludeInList = Game.class.getDeclaredMethod("getRandomIntegerExcludeInList", List.class);
            getRandomIntegerExcludeInList.setAccessible(true);

            //When
            List<Integer> answer = List.of(1);
            int number = (int) getRandomIntegerExcludeInList.invoke(game, answer);

            //Then
            assertThat(number).isNotEqualTo(1);
        }
    }

}