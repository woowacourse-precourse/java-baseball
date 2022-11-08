package baseball;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BaseballGameTest {
    @Test
    void getScore1() {
        String computer = "713";
        BaseBallGame baseBallGame = new BaseBallGame(computer);
        String user = "123";

        Map<String, Integer> map = baseBallGame.calculateScores(user);
        String resultString = baseBallGame.getResultAsString(map);
        assertThat(resultString).isEqualTo("1볼 1스트라이크");
    }


    @Test
    void getScore2() {
        String computer = "713";
        BaseBallGame baseBallGame = new BaseBallGame(computer);
        String user = "145";

        Map<String, Integer> map = baseBallGame.calculateScores(user);
        String resultString = baseBallGame.getResultAsString(map);
        assertThat(resultString).isEqualTo("1볼 ");
    }



    @Test
    void getScore3() {
        String computer = "713";
        BaseBallGame baseBallGame = new BaseBallGame(computer);
        String user = "671";

        Map<String, Integer> map = baseBallGame.calculateScores(user);
        String resultString = baseBallGame.getResultAsString(map);
        assertThat(resultString).isEqualTo("2볼 ");
    }




    @Test
    void getScore4() {
        String computer = "713";
        BaseBallGame baseBallGame = new BaseBallGame(computer);
        String user = "216";

        Map<String, Integer> map = baseBallGame.calculateScores(user);
        String resultString = baseBallGame.getResultAsString(map);
        assertThat(resultString).isEqualTo("1스트라이크");
    }

    @Test
    void getScore5() {
        String computer = "713";
        BaseBallGame baseBallGame = new BaseBallGame(computer);
        String user = "713";

        Map<String, Integer> map = baseBallGame.calculateScores(user);
        String resultString = baseBallGame.getResultAsString(map);
        assertThat(resultString).isEqualTo("3스트라이크");
    }

    @Test
    void inputIsCorrectAnswer() {
        String computer = "713";
        BaseBallGame baseBallGame = new BaseBallGame(computer);
        String user = "713";

        Map<String, Integer> map = baseBallGame.calculateScores(user);
        String resultString = baseBallGame.getResultAsString(map);
        boolean correct = baseBallGame.isRightAnswer(map);
        assertThat(correct).isTrue();
    }

    @Test
    void inputIsNotAnswer() {
        String computer = "713";
        BaseBallGame baseBallGame = new BaseBallGame(computer);
        String user = "123";

        Map<String, Integer> map = baseBallGame.calculateScores(user);
        String resultString = baseBallGame.getResultAsString(map);
        boolean correct = baseBallGame.isRightAnswer(map);
        assertThat(correct).isFalse();
    }
}
