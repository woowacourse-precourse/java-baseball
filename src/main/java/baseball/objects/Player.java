package baseball.objects;

import java.util.List;

public class Player {

    private List<Integer> numbers;

    public void sayNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void giveNumbersToReferee(Referee referee) {
        referee.receivePlayerNumbers(this.numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
