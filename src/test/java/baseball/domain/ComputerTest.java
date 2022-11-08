package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class ComputerTest {

    @Test
    void 서로_다른_3개의_숫자_선택_테스트() {

        Computer computer = new Computer();
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

        Computer computer = new Computer();

        List<Integer> computerList = List.of(1, 2, 3);
        List<Integer> playerList = List.of(1, 2, 4);

        int sameCnt = computer.checkSameNumbersCount(computerList, playerList);

        assertThat(sameCnt).isEqualTo(2);
    }

    @Test
    void 같은_자릿수_검사_테스트() {

        Computer computer = new Computer();

        List<Integer> computerList = List.of(1, 5, 3);
        List<Integer> playerList = List.of(1, 2, 4);

        int sameCnt = computer.checkSameNumberOfDigit(computerList, playerList);

        assertThat(sameCnt).isEqualTo(1);
    }

    @Test
    void 스트라이크_볼_리스트_변환() {

        Computer computer = new Computer();

        List<Integer> strikeBallList = computer.getStrikeBallList(3, 1);

        assertThat(strikeBallList).containsExactly(2, 1);
    }

    @Test
    void 스트라이크_볼_출력() {

        Computer computer = new Computer();

        String result = computer.printResult(List.of(2, 1));

        assertThat(result).isEqualTo("2볼 1스트라이크");
    }
}