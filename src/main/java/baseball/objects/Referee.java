package baseball.objects;

import baseball.view.service.ViewService;

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

    public ViewService answerNumber() {
        return rule.answerNumber(playerNumbers);
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }
}
