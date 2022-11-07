package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @DisplayName("플레이어 숫자가 주어진 상황에서 비교 했을 때 낫싱")
    @Test
    void givenPlayerNum_whenCalculate_thenResultIs00() {
        List<Integer> computerNum = List.of(4, 5, 6);
        List<Integer> playerNum = List.of(1, 2, 3);

        List<Integer> result = calculate(computerNum, playerNum);
        String strResult = printResult(result);
        assertThat(strResult).isEqualTo("낫싱\n");

    }

    @DisplayName("플레이어 숫자가 주어진 상황에서 비교 했을 때 1볼")
    @Test
    void givenPlayerNum_whenCalculate_thenResultIs10() {
        List<Integer> computerNum = List.of(3, 4, 5);
        List<Integer> playerNum = List.of(1, 2, 3);

        List<Integer> result = calculate(computerNum, playerNum);
        String strResult = printResult(result);
        assertThat(strResult).isEqualTo("1볼\n");
    }

    @DisplayName("플레이어 숫자가 주어진 상황에서 비교 했을 때 2볼")
    @Test
    void givenPlayerNum_whenCalculate_thenResultIs20() {
        List<Integer> computerNum = List.of(2, 3, 4);
        List<Integer> playerNum = List.of(1, 2, 3);

        List<Integer> result = calculate(computerNum, playerNum);
        String strResult = printResult(result);
        assertThat(strResult).isEqualTo("2볼\n");
    }

    @DisplayName("플레이어 숫자가 주어진 상황에서 비교 했을 때 3볼")
    @Test
    void givenPlayerNum_whenCalculate_thenResultIs30() {
        List<Integer> computerNum = List.of(3, 1, 2);
        List<Integer> playerNum = List.of(1, 2, 3);

        List<Integer> result = calculate(computerNum, playerNum);
        String strResult = printResult(result);
        assertThat(strResult).isEqualTo("3볼\n");
    }

    @DisplayName("플레이어 숫자가 주어진 상황에서 비교 했을 때 1스트라이크")
    @Test
    void givenPlayerNum_whenCalculate_thenResultIs01() {
        List<Integer> computerNum = List.of(1, 5, 6);
        List<Integer> playerNum = List.of(1, 2, 3);

        List<Integer> result = calculate(computerNum, playerNum);
        String strResult = printResult(result);
        assertThat(strResult).isEqualTo("1스트라이크\n");
    }


    @DisplayName("플레이어 숫자가 주어진 상황에서 비교 했을 때 2스트라이크")
    @Test
    void givenPlayerNum_whenCalculate_thenResultIs02() {
        List<Integer> computerNum = List.of(1, 2, 4);
        List<Integer> playerNum = List.of(1, 2, 3);

        List<Integer> result = calculate(computerNum, playerNum);
        String strResult = printResult(result);
        assertThat(strResult).isEqualTo("2스트라이크\n");
    }

    @DisplayName("플레이어 숫자가 주어진 상황에서 비교 했을 때 정답")
    @Test
    void givenPlayerNum_whenCalculate_thenResultIs03() {
        List<Integer> computerNum = List.of(1, 2, 3);
        List<Integer> playerNum = List.of(1, 2, 3);

        List<Integer> result = calculate(computerNum, playerNum);
        String strResult = printResult(result);
        assertThat(strResult).isEqualTo(
                "3스트라이크\n" +
                        "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
    }

    @DisplayName("플레이어 숫자가 주어진 상황에서 비교 했을 때 1볼 1스트라이크")
    @Test
    void givenPlayerNum_whenCalculate_thenResultIs11() {
        List<Integer> computerNum = List.of(1, 5, 2);
        List<Integer> playerNum = List.of(1, 2, 3);

        List<Integer> result = calculate(computerNum, playerNum);
        String strResult = printResult(result);
        assertThat(strResult).isEqualTo("1볼 1스트라이크\n");
    }

    @DisplayName("플레이어 숫자가 주어진 상황에서 비교 했을 때 2볼 1스트라이크")
    @Test
    void givenPlayerNum_whenCalculate_thenResultIs21() {
        List<Integer> computerNum = List.of(1, 3, 2);
        List<Integer> playerNum = List.of(1, 2, 3);

        List<Integer> result = calculate(computerNum, playerNum);
        String strResult = printResult(result);
        assertThat(strResult).isEqualTo("2볼 1스트라이크\n");
    }

    List<Integer> calculate(List<Integer> computer, List<Integer> player) {
        List<Integer> result = new ArrayList<>();
        result.add(findBall(computer, player));
        result.add(findStrike(computer, player));

        return result;
    }

    int findStrike(List<Integer> computer, List<Integer> player) {
        int count = 0;
        for (int index = 0; index < 3; index++) {
            if (computer.get(index) == player.get(index)) {
                count++;
            }
        }
        return count;
    }

    int findBall(List<Integer> computer, List<Integer> player) {
        int count = 0;
        for (int index = 0; index < 3; index++) {
            if (computer.get(index) != player.get(index) && computer.contains(player.get(index))) {
                count++;
            }
        }
        return count;
    }

    String printResult(List<Integer> result) {
        int ball = result.get(0);
        int strike = result.get(1);
        StringBuilder stringBuilder = new StringBuilder();
        if (ball == 0 && strike == 0) {
            stringBuilder.append("낫싱\n");
        } else if (ball == 0 && strike == 3) {
            stringBuilder.append("3스트라이크\n");
            stringBuilder.append("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
            stringBuilder.append("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        } else {
            if (ball != 0 && strike != 0) {
                stringBuilder.append(ball + "볼 " + strike + "스트라이크\n");
            } else if (ball != 0) {
                stringBuilder.append(ball + "볼\n");

            } else if (strike != 0) {
                stringBuilder.append(strike + "스트라이크\n");
            }
        }
        return stringBuilder.toString();
    }
}