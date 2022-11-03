package baseball.service;

import baseball.dto.Score;
import baseball.system.voter.BaseballVoter;
import baseball.system.voter.Voter;

import java.util.List;

public class BaseballService {
    public Score compareInputWithAnswer(List<Integer> input) {
        Voter<List<Integer>, Score> voter = new BaseballVoter();
        return voter.vote(input);
    }
}
