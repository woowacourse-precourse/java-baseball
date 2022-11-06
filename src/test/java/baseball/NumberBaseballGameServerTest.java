package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class NumberBaseballGameServerTest {

    @Test
    void 게임숫자는_3자리의_숫자입니다() {
        List<Integer> gameNumberList = new NumberBaseballGameServer().makeNewGameNumber();
        int expectedGameNumberList = 3;
        int actualGameNumberList = gameNumberList.size();
        assertThat(actualGameNumberList).isEqualTo(expectedGameNumberList);
    }

    @Test
    void 게임숫자는_서로_다른_숫자로_구성되어_있습니다() {
        List<Integer> gameNumberList = new NumberBaseballGameServer().makeNewGameNumber();
        boolean expectedIsDuplicated = false;
        boolean actualIsDuplicated = false;

        while (gameNumberList.size() != 0) {
            int degreeNumber = gameNumberList.remove(0);
            actualIsDuplicated |= gameNumberList.contains(degreeNumber);
        }
        assertThat(actualIsDuplicated).isEqualTo(expectedIsDuplicated);
    }

    @Test
    void 플레이어_숫자_판정결과는_2스트라이크가_맞습니다() {
        List<Integer> gameNumberList = List.of(2, 3, 9);
        int playerInputNumber = 234;
        int expectCountStrikes = 2, expectCountBalls = 0;

        NumberBaseballGameJudgedResultDto actualJudgedResultDto =
            new NumberBaseballGameServer()
                .judgeInputNumber(playerInputNumber, gameNumberList);

        boolean expectedResult = true;
        boolean actualResult = false;
        if (actualJudgedResultDto.countBalls == expectCountBalls
            && actualJudgedResultDto.countStrikes == expectCountStrikes) {
            actualResult = true;
        }

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void 플레이어_숫자_판정결과는_3스트라이크가_맞습니다() {
        List<Integer> gameNumberList = List.of(4, 7, 9);
        int playerInputNumber = 479;
        int expectCountStrikes = 3, expectCountBalls = 0;

        NumberBaseballGameJudgedResultDto actualJudgedResultDto =
            new NumberBaseballGameServer()
                .judgeInputNumber(playerInputNumber, gameNumberList);

        boolean expectedResult = true;
        boolean actualResult = false;
        if (actualJudgedResultDto.countBalls == expectCountBalls
            && actualJudgedResultDto.countStrikes == expectCountStrikes) {
            actualResult = true;
        }

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void 플레이어_숫자_판정결과는_낫싱가_맞습니다() {
        List<Integer> gameNumberList = List.of(2, 3, 9);
        int playerInputNumber = 186;
        int expectCountStrikes = 0, expectCountBalls = 0;

        NumberBaseballGameJudgedResultDto actualJudgedResultDto =
            new NumberBaseballGameServer()
                .judgeInputNumber(playerInputNumber, gameNumberList);

        boolean expectedResult = true;
        boolean actualResult = false;
        if (actualJudgedResultDto.countBalls == expectCountBalls
            && actualJudgedResultDto.countStrikes == expectCountStrikes) {
            actualResult = true;
        }

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void 플레이어_숫자_판정결과는_3볼이_맞습니다() {
        List<Integer> gameNumberList = List.of(2, 3, 9);
        int playerInputNumber = 392;
        int expectCountStrikes = 0, expectCountBalls = 3;

        NumberBaseballGameJudgedResultDto actualJudgedResultDto =
            new NumberBaseballGameServer()
                .judgeInputNumber(playerInputNumber, gameNumberList);

        boolean expectedResult = true;
        boolean actualResult = false;
        if (actualJudgedResultDto.countBalls == expectCountBalls
            && actualJudgedResultDto.countStrikes == expectCountStrikes) {
            actualResult = true;
        }

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void 플레이어_숫자_판정결과는_2볼_1스트라이크가_맞습니다() {
        List<Integer> gameNumberList = List.of(2, 3, 9);
        int playerInputNumber = 329;
        int expectCountStrikes = 1, expectCountBalls = 2;

        NumberBaseballGameJudgedResultDto actualJudgedResultDto =
            new NumberBaseballGameServer()
                .judgeInputNumber(playerInputNumber, gameNumberList);

        boolean expectedResult = true;
        boolean actualResult = false;
        if (actualJudgedResultDto.countBalls == expectCountBalls
            && actualJudgedResultDto.countStrikes == expectCountStrikes) {
            actualResult = true;
        }

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}