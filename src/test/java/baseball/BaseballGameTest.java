package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import static org.assertj.core.api.Assertions.*;

class BaseballGameTest extends NsTest {

    BaseballGame baseballGame = new BaseballGame();

    @Test
    public void 컴퓨터_랜덤숫자_생성() {

        //given
        List<Integer> computer = baseballGame.makeComputerNumber();

        //when
        Set<Integer> computerValidationSet = new HashSet<>(computer);

        //then
        assertThat(computerValidationSet.size()).isEqualTo(3);

    }

    @Test
    public void 점수_계산_테스트() {

        //given
        List<Integer> computer = new ArrayList<>(Arrays.asList(1, 3, 5));
        String userInput = "531";

        //when
        Map<String, Integer> score = baseballGame.makeScore(userInput, computer);

        //then
        assertThat(score.get("ball")).isEqualTo(2);
        assertThat(score.get("strike")).isEqualTo(1);

    }

    @Test
    public void 점수_알림_테스트_스트라이크() {

        //given
        Map<String, Integer> strikeScore = new HashMap<>();
        strikeScore.put("ball", 0);
        strikeScore.put("strike", 3);

        //when
        baseballGame.alertScore(strikeScore);

        //then
        assertThat(output()).contains("스트라이크").doesNotContain("볼", "낫싱");

    }

    @Test
    public void 점수_알림_테스트_볼() {

        //given
        Map<String, Integer> ballScore = new HashMap<>();
        ballScore.put("ball", 3);
        ballScore.put("strike", 0);

        //when
        baseballGame.alertScore(ballScore);

        //then
        assertThat(output()).contains("볼").doesNotContain("스트라이크", "낫싱");
    }

    @Test
    public void 점수_알림_테스트_낫싱() {

        //given
        Map<String, Integer> nothingScore = new HashMap<>();
        nothingScore.put("ball", 0);
        nothingScore.put("strike", 0);

        //when
        baseballGame.alertScore(nothingScore);

        //then
        assertThat(output()).contains("낫싱").doesNotContain("볼", "스트라이크");
    }


    @Override
    public void runMain() {
    }
}