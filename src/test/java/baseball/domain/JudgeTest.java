package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class JudgeTest {
    @Test
    void 알맞는_볼_횟수_반환() {
        //given
        List<Integer> tempNums = List.of(1, 2, 3);
        Answer testAnswer = new Answer(tempNums);
        Judge testJudge = new Judge(testAnswer);

        //when
        List<Integer> testUserInput = List.of(1, 3, 5); // 1스트라이크 1볼
        int ballCount = testJudge.getBallCount(testUserInput);

        //then
        assertThat(ballCount).isEqualTo(1);
    }

    @Test
    void 알맞는_스트라이크_횟수_반환() {
        //given
        List<Integer> tempNums = List.of(1, 2, 3);
        Answer testAnswer = new Answer(tempNums);
        Judge testJudge = new Judge(testAnswer);

        //when
        List<Integer> testUserInput = List.of(1, 3, 5); // 1스트라이크 1볼
        int strikeCount = testJudge.getStrikeCount(testUserInput);

        //then
        assertThat(strikeCount).isEqualTo(1);
    }

    @Test
    void getUserInputScore_실행시_Score_객체_반환() {
        //given
        List<Integer> tempNums = List.of(1, 2, 3);
        Answer testAnswer = new Answer(tempNums);
        Judge testJudge = new Judge(testAnswer);
        List<Integer> userInput = List.of(1, 2, 3);

        //when
        Score score = testJudge.getUserInputScore(userInput);
        CountStatus countStatus = score.getCountStatus();

        // 임의로 생성한 Score 객체
        Score testScore = new Score(0, 3);
        CountStatus testCountStatus = testScore.getCountStatus();

        //then
        assertThat(countStatus).isEqualTo(testCountStatus);
    }
}
