package baseball;

import java.util.ArrayList;
import java.util.List;

public class Referee {

    private Rule rule;
    private List<Integer> playerNumbers;

    public Referee(Rule rule) {
        this.rule = rule;
        this.playerNumbers = new ArrayList<>();
    }

    public void receiveComputerNumbers(List<Integer> numbers) {
        this.rule.selectedNumber(numbers);
    }

    public void receivePlayerNumbers(List<Integer> numbers) {
        this.playerNumbers = numbers;
    }

    public ResponseView answerNumber() {
        return rule.answerNumber(playerNumbers);
    }
}
