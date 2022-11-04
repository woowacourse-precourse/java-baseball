package baseball.service;

import baseball.dto.Score;
import baseball.system.voter.Voter;
import baseball.vo.UserNumber;

public class BaseballService {
    private final Voter<UserNumber, Score> voter;

    public BaseballService(Voter<UserNumber, Score> voter) {
        this.voter = voter;
    }

    public Score compareInputWithAnswer(UserNumber input) {
        return voter.vote(input);
    }
}
