package baseball;

import java.util.List;

public class Player {

    private List<Integer> numbers;

    public List<Integer> sayNumbers(List<Integer> numbers) {
        validNumbers(numbers);
        this.numbers = numbers;
        return numbers;
    }

    private void validNumbers(List<Integer> numbers) {
        if (numbers.size() > 3) {
            throw new IllegalArgumentException("Numbers is size Exception!!");
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void giveNumbersToReferee(Referee referee) {
        referee.receivePlayerNumbers(this.numbers);
    }
}
