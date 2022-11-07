package baseball;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BaseballGameTest {
    @Test
    void getScore1() {
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.computer = "713";
        String user = "123";

        Map<String, Integer> map = baseBallGame.calculateScores(user);
        String resultString = baseBallGame.getResultAsString(map);
        System.out.println(resultString);
        assertThat(resultString).isEqualTo("1볼 1스트라이크");
        assertThat(baseBallGame.isRightAnswer()).isFalse();
    }


    @Test
    void getScore2() {
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.computer = "713";
        String user = "145";

        Map<String, Integer> map = baseBallGame.calculateScores(user);
        String resultString = baseBallGame.getResultAsString(map);
        System.out.println(resultString);
        assertThat(resultString).isEqualTo("1볼 ");
        assertThat(baseBallGame.isRightAnswer()).isFalse();
    }



    @Test
    void getScore3() {
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.computer = "713";
        String user = "671";

        Map<String, Integer> map = baseBallGame.calculateScores(user);
        String resultString = baseBallGame.getResultAsString(map);
        System.out.println(resultString);
        assertThat(resultString).isEqualTo("2볼 ");
        assertThat(baseBallGame.isRightAnswer()).isFalse();
    }




    @Test
    void getScore4() {
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.computer = "713";
        String user = "216";

        Map<String, Integer> map = baseBallGame.calculateScores(user);
        String resultString = baseBallGame.getResultAsString(map);
        System.out.println(resultString);
        assertThat(resultString).isEqualTo("1스트라이크");
        assertThat(baseBallGame.isRightAnswer()).isFalse();
    }

    @Test
    void getScore5() {
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.computer = "713";
        String user = "713";

        Map<String, Integer> map = baseBallGame.calculateScores(user);
        String resultString = baseBallGame.getResultAsString(map);
        System.out.println(resultString);
        assertThat(resultString).isEqualTo("3스트라이크");
        assertThat(baseBallGame.isRightAnswer()).isTrue();
    }
}
