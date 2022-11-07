package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallCountTest {

    BallCount ballCount = new BallCount();
    BaseballNumbers randomNumbers = new BaseballNumbers();
    BaseballNumbers inputNumbers = new BaseballNumbers();
    BaseballNumbers inputNumbers2 = new BaseballNumbers();

    @Test
    void case1_랜덤값과_인풋값_비교_후_볼_개수_확인() {
        randomNumbers.createBaseballNumbers("123");
        inputNumbers.createBaseballNumbers("234");
        String input = "2볼";
        ballCount.validateBallCount(randomNumbers, inputNumbers);
        assertThat(ballCount.toString()).isEqualTo(input);
    }

    @Test
    void case2_랜덤값과_인풋값_비교_후_스트라이크_개수_확인() {
        randomNumbers.createBaseballNumbers("123");
        inputNumbers.createBaseballNumbers("145");
        String input = "1스트라이크";
        ballCount.validateBallCount(randomNumbers, inputNumbers);
        assertThat(ballCount.toString()).isEqualTo(input);
    }

    @Test
    void case3_인풋값_볼카운트_출력_확인() {
        randomNumbers.createBaseballNumbers("123");
        inputNumbers.createBaseballNumbers("134");
        String input = "1볼 1스트라이크";
        ballCount.validateBallCount(randomNumbers, inputNumbers);
        assertThat(ballCount.toString()).isEqualTo(input);
    }

    @Test
    void case4_모든_인풋값_출력_확인() {
        GameBoard gameBoard = new GameBoard();
        inputNumbers.createBaseballNumbers("134");
        inputNumbers2.createBaseballNumbers("345");

        String input = "현재 입력한 결과입니다.\r\n" + "134 : " + gameBoard.showBallCount(inputNumbers) + "\r\n345 : " + gameBoard.showBallCount(inputNumbers2) + "\r\n";
        assertThat(gameBoard.showRecords()).isEqualTo(input);
    }
}
