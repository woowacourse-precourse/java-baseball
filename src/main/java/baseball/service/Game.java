package baseball.service;

public class Game {
    private Rule rule;

    public void run() {
        rule = new Rule(new Player(), new Computer());
        do {
            rule.generateRandomNumber();
            rule.getNumber();
            rule.isValid();
            rule.decideStrikeOrBall();
            rule.printResult();
        } while (rule.reStart);
    }
}
