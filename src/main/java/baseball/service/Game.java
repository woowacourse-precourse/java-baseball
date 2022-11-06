package baseball.service;

public class Game {
    Rule rule;

    public Game() {
        this.rule = new Rule();
    }

    public void run() {
        do {
            rule.getNumber();
            rule.isValid();
            rule.decideStrikeOrBall();
        } while (rule.reStart);
    }
}
