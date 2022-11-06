package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {

    Game game;

    @BeforeEach
    void init() {
        game = new Game();
    }

    @Test
    @DisplayName("Computer 는 서로 다른 3개의 숫자를 만들 수 있다")
    void testComputerMakesThreeDifferentNumber() throws Exception {
        //given
        List<Integer> numberList = game.makesDifferenceThreeNumber();

        //when
        Set<Integer> numberSet = new HashSet<>(numberList);

        //then
        assertThat(numberSet.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("Computer 와 User 숫자가 주어졌을 때 Strike와 Ball의 개수를 구할 수 있다")
    void testFindStrikeAndBall() throws Exception {
        //given
        String user1 = "123";
        List<Integer> computer1 = List.of(1, 2, 3);

        String user2 = "847";
        List<Integer> computer2 = List.of(8, 7, 4);

        String user3 = "847";
        List<Integer> computer3 = List.of(8, 7, 5);

        String user4 = "847";
        List<Integer> computer4 = List.of(8, 4, 9);

        String user5 = "847";
        List<Integer> computer5 = List.of(1, 2, 3);

        //when
        List<Integer> result1 = findStrikeAndBallHelper(user1, computer1); //3스트라이크
        List<Integer> result2 = findStrikeAndBallHelper(user2, computer2); //1스트라이크 2볼
        List<Integer> result3 = findStrikeAndBallHelper(user3, computer3); //1스트라이크 1볼
        List<Integer> result4 = findStrikeAndBallHelper(user4, computer4); //2스트라이크
        List<Integer> result5 = findStrikeAndBallHelper(user5, computer5); //낫싱

        //then
        assertThat(result1).containsExactly(3, 0);
        assertThat(result2).containsExactly(1, 2);
        assertThat(result3).containsExactly(1, 1);
        assertThat(result4).containsExactly(2, 0);
        assertThat(result5).containsExactly(0, 0);
    }

    private List<Integer> findStrikeAndBallHelper(String user, List<Integer> computer) {
        return game.findStrikeAndBall(user, computer);
    }

    @Test
    @DisplayName("User는 1~9 사이의 서로 다른 세 개의 숫자만 입력할 수 있습니다.")
    void testOnlyThreeDifferentNumbers() throws Exception {
        //given
        String user1 = "123";
        String user2 = "2345";
        String user3 = "012";
        String user4 = "122";

        //when
        boolean result1 = game.isCorrectInput(user1);
        boolean result2 = game.isCorrectInput(user2);
        boolean result3 = game.isCorrectInput(user3);
        boolean result4 = game.isCorrectInput(user4);

        //then
        assertTrue(result1);
        assertFalse(result2);
        assertFalse(result3);
        assertFalse(result4);
    }
}