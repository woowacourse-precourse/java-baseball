package baseball.system.voter;

import baseball.system.AnswerHolder;
import baseball.vo.Answer;
import baseball.dto.Score;
import baseball.vo.UserNumber;

import java.util.List;
import java.util.Objects;

public class BaseballVoter implements Voter<UserNumber, Score> {
    @Override
    public Score vote(UserNumber target) {
        Answer answer = AnswerHolder.getAnswer();
        List<Integer> answerList = answer.getAnswer();

        Score score = Score.makeNewScore();

        for (int index = 0; index < target.size(); index++) {
            if (isPositionAndNumberMatching(target.get(index), index, answerList)) {
                score.addStrike();
            } else if (isNotPositionButNumberMatching(target.get(index), answerList)) {
                score.addBall();
            }
        }

        return score;
    }

    private boolean isPositionAndNumberMatching(Integer target, Integer index, List<Integer> answer) {
        return Objects.equals(target, answer.get(index));
    }

    private boolean isNotPositionButNumberMatching(Integer target, List<Integer> answer) {
        return answer.contains(target);
    }
}
