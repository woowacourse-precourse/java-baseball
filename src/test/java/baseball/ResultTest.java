package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ResultTest {

    @Test
    void initialize() {
        Result result = new Result();
        result.setBallCount(1);
        result.setStrikeCount(2);
        result.initialize();
        int resultValue = 0;
        assertThat(resultValue).isEqualTo(result.getBallCount());
        assertThat(resultValue).isEqualTo(result.getStrikeCount());
    }

    @Test
    void increaseBallCount() {
        Result result = new Result();
        result.increaseBallCount();
        int resultValue = 1;
        assertThat(resultValue).isEqualTo(result.getBallCount());
    }

    @Test
    void increaseStrikeCount() {
        Result result = new Result();
        result.increaseStrikeCount();
        int resultValue = 1;
        assertThat(resultValue).isEqualTo(result.getStrikeCount());
    }

    @Test
    void createResultMessage_1볼2스트라이크() {
        Result result = new Result();
        result.setBallCount(1);
        result.setStrikeCount(2);
        String resultMessage = result.createResultMessage();
        String resultValue = "1볼 2스트라이크";
        assertThat(resultValue).isEqualTo(resultMessage);
    }

    @Test
    void createResultMessage_3볼() {
        Result result = new Result();
        result.setBallCount(3);
        result.setStrikeCount(0);
        String resultMessage = result.createResultMessage();
        String resultValue = "3볼";
        assertThat(resultValue).isEqualTo(resultMessage);
    }

    @Test
    void createResultMessage_3스트라이크() {
        Result result = new Result();
        result.setBallCount(0);
        result.setStrikeCount(3);
        String resultMessage = result.createResultMessage();
        String resultValue = "3스트라이크";
        assertThat(resultValue).isEqualTo(resultMessage);
    }

    @Test
    void createResultMessage_낫싱() {
        Result result = new Result();
        result.setBallCount(0);
        result.setStrikeCount(0);
        String resultMessage = result.createResultMessage();
        String resultValue = "낫싱";
        assertThat(resultValue).isEqualTo(resultMessage);
    }

    @Test
    void isWrongAnswer_처음상태() {
        Result result = new Result();
        boolean isWrongAnswer = result.isWrongAnswer();
        boolean resultValue = true;
        assertThat(resultValue).isEqualTo(isWrongAnswer);
    }

    @Test
    void isWrongAnswer_정답() {
        Result result = new Result();
        result.setStrikeCount(3);
        boolean isWrongAnswer = result.isWrongAnswer();
        boolean resultValue = false;
        assertThat(resultValue).isEqualTo(isWrongAnswer);
    }
}