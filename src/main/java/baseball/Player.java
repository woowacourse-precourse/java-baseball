package baseball;

import java.util.List;

public class Player {

    private List<Integer> numbers;

    public List<Integer> sayNumbers(List<Integer> numbers) {
        if (numbers.size() > 3) {
            throw new IllegalArgumentException("Numbers is size Exception!!");
        }

        this.numbers = numbers;
        return numbers;
    }

    public void giveNumbersToReferee(Referee referee) {
        referee.receiveNumbers(numbers);
    }
}
