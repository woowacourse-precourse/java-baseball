package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class ComputerTest {
    private static final List<Integer> computerList = List.of(1, 2, 3);
    private Computer computer;

    @BeforeEach
    void setUp() {
        computer = new Computer();
    }

    @ParameterizedTest
    @CsvSource({"1,2,3,3스트라이크", "7,8,9,낫싱", "2,3,1,3볼", "1,3,2,2볼 1스트라이크"})
    void 통합_테스트(int number1, int number2, int number3, String expected) {

        List<Integer> playerList = List.of(number1, number2, number3);

        int sameNumbersCount = computer.checkSameNumbersCount(computerList, playerList);
        int sameNumberOfDigit = computer.checkSameNumberOfDigit(computerList, playerList);
        List<Integer> ballStrikeList = computer.getBallStrikeList(sameNumbersCount, sameNumberOfDigit);
        String result = computer.printResult(ballStrikeList);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 서로_다른_3개의_숫자_선택_테스트() {

        int validateCnt = 0;

        List<Integer> selectNumberList = computer.selectNumbers();
        for (Integer number : selectNumberList) {
            for (Integer selectNumber : selectNumberList) {
                if (number == selectNumber) validateCnt++;
            }
        }

        assertThat(selectNumberList).hasSize(3);
        assertThat(validateCnt).isEqualTo(3);

    }

    @Test
    void 같은_숫자_갯수_검사_테스트() {

        List<Integer> computerList = List.of(1, 2, 3);
        List<Integer> playerList = List.of(1, 2, 4);

        int sameCnt = computer.checkSameNumbersCount(computerList, playerList);

        assertThat(sameCnt).isEqualTo(2);
    }

    @Test
    void 같은_자릿수_검사_테스트() {

        List<Integer> computerList = List.of(1, 5, 3);
        List<Integer> playerList = List.of(1, 2, 4);

        int sameCnt = computer.checkSameNumberOfDigit(computerList, playerList);

        assertThat(sameCnt).isEqualTo(1);
    }

    @Test
    void 볼_스트라이크_리스트_변환() {

        List<Integer> strikeBallList = computer.getBallStrikeList(3, 1);

        assertThat(strikeBallList).containsExactly(2, 1);
    }

    @Test
    void 볼_스타라이크_출력() {

        String result = computer.printResult(List.of(2, 1));
        String result2 = computer.printResult(List.of(0, 3));

        assertThat(result).isEqualTo("2볼 1스트라이크");
        assertThat(result2).isEqualTo("3스트라이크");
    }
}