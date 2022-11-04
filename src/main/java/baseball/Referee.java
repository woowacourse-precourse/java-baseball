package baseball;

import java.util.List;

public class Referee {

    private List<Integer> numbers;

    public void receiveNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
