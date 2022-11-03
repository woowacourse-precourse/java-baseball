package baseball.service;

import baseball.dto.Score;
import baseball.system.voter.Voter;

import java.util.List;

public class BaseballService {
    private final Voter<List<Integer>, Score> voter;

    public BaseballService(Voter<List<Integer>, Score> voter) {
        this.voter = voter;
    }

    public Score compareInputWithAnswer(List<Integer> input) {
        return voter.vote(input);
    }
}
