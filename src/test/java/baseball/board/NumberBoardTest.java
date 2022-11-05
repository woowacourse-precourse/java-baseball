package baseball.board;

import static org.assertj.core.api.Assertions.*;

import baseball.compare.ComparisonResultType;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumberBoardTest {

    NumberBoard numberBoard;

    @BeforeEach
    void setUp() {
        numberBoard = new NumberBoard();
    }

    @Test
    void compareNumbers_메소드는_두_리스트를_비교한_빈도수_해시맵을_반환() {
        List<Integer> userNumbers = List.of(1, 2, 3);
        List<Integer> opponentNumbers = List.of(1, 2, 3);

        HashMap<ComparisonResultType, Integer> result = new HashMap<>();
        result.put(ComparisonResultType.STRIKE, 3);

        assertThat(numberBoard.compareNumbers(userNumbers, opponentNumbers)).isEqualTo(result);
    }

    @Test
    void compareNumbers_메소드는_두_리스트를_비교한_빈도수_해시맵을_반환2() {
        List<Integer> userNumbers = List.of(1, 2, 3);
        List<Integer> opponentNumbers = List.of(1, 2, 4);

        HashMap<ComparisonResultType, Integer> result = new HashMap<>();
        result.put(ComparisonResultType.STRIKE, 2);

        assertThat(numberBoard.compareNumbers(userNumbers, opponentNumbers)).isEqualTo(result);
    }

    @Test
    void compareNumbers_메소드는_두_리스트를_비교한_빈도수_해시맵을_반환3() {
        List<Integer> userNumbers = List.of(1, 2, 3);
        List<Integer> opponentNumbers = List.of(4, 5, 6);

        HashMap<ComparisonResultType, Integer> result = new HashMap<>();

        assertThat(numberBoard.compareNumbers(userNumbers, opponentNumbers)).isEqualTo(result);
    }

    @Test
    void compareNumbers_메소드는_두_리스트를_비교한_빈도수_해시맵을_반환4() {
        List<Integer> userNumbers = List.of(1, 2, 3);
        List<Integer> opponentNumbers = List.of(2, 1, 3);

        HashMap<ComparisonResultType, Integer> result = new HashMap<>();
        result.put(ComparisonResultType.STRIKE, 1);
        result.put(ComparisonResultType.BALL, 2);

        assertThat(numberBoard.compareNumbers(userNumbers, opponentNumbers)).isEqualTo(result);
    }

    @Test
    void compareNumbers_메소드는_두_리스트를_비교한_빈도수_해시맵을_반환5() {
        List<Integer> userNumbers = List.of(1, 2, 3);
        List<Integer> opponentNumbers = List.of(2, 3, 1);

        HashMap<ComparisonResultType, Integer> result = new HashMap<>();
        result.put(ComparisonResultType.BALL, 3);

        assertThat(numberBoard.compareNumbers(userNumbers, opponentNumbers)).isEqualTo(result);
    }

    @Test
    void getResultMessage_메소드는_각_비교_결과_타입별_개수를_공백을_사이로_문자열을_반환() {
        List<Integer> userNumbers = List.of(1, 2, 3);
        List<Integer> opponentNumbers = List.of(1, 2, 3);
        numberBoard.compareNumbers(userNumbers, opponentNumbers);

        assertThat(numberBoard.getResultMessage()).isEqualTo("3스트라이크");
    }

    @Test
    void getResultMessage_메소드는_각_비교_결과_타입별_개수를_공백을_사이로_문자열을_반환2() {
        List<Integer> userNumbers = List.of(1, 2, 3);
        List<Integer> opponentNumbers = List.of(2, 1, 3);
        numberBoard.compareNumbers(userNumbers, opponentNumbers);

        assertThat(numberBoard.getResultMessage()).isEqualTo("2볼 1스트라이크");
    }

    @Test
    void getResultMessage_메소드는_각_비교_결과_타입별_개수를_공백을_사이로_문자열을_반환3() {
        List<Integer> userNumbers = List.of(1, 2, 3);
        List<Integer> opponentNumbers = List.of(4, 5, 6);
        numberBoard.compareNumbers(userNumbers, opponentNumbers);

        assertThat(numberBoard.getResultMessage()).isEqualTo(NumberBoardConstant.NOT_MATCH_AT_ALL_MESSAGE);
    }
}
