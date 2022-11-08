package baseball.objects;

import baseball.view.service.ViewService;

import java.util.ArrayList;
import java.util.List;

public class Referee {

    private final Rule rule = new Rule();
    private List<Integer> playerNumbers = new ArrayList<>();

    public void receiveComputerNumbers(List<Integer> numbers) {
        this.rule.selectedNumber(numbers);
    }

    public void receivePlayerNumbers(List<Integer> numbers) {
        playerNumbers = numbers;
    }

    public ViewService answerNumber() {
        return rule.answerNumber(playerNumbers);
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

    public List<Integer> getSelectedNumbers() {
        return rule.getSelectedNumbers();
    }
}
