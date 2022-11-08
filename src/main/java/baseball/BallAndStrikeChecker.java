package baseball;

import baseball.rule.*;

import java.util.ArrayList;
import java.util.List;

public class BallAndStrikeChecker {
    private final List<BaseballRule> rules = new ArrayList<>();

    public BallAndStrikeChecker(){
        addRule(new Nothing());
        addRule(new OnlyBall());
        addRule(new OnlyStrike());
        addRule(new BallAndStrike());
        addRule(new AllStrike());
    }

    public void addRule(BaseballRule rule) {
        rules.add(rule);
    }

    public void reply(int ball, int strike) {
        rules.stream()
                .filter(rule -> rule.check(ball, strike))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .execute(ball, strike);
    }
}
