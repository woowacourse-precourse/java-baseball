package baseball.objects;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final NumberGenerator numberGenerator = new NumberGenerator();
    private final List<Integer> numbers = new ArrayList<>();

    public Computer() {
        generateNumbers();
    }

    private void generateNumbers() {
        numberGenerator.generate(numbers);
    }

    public void giveNumbersToReferee(Referee referee) {
        referee.receiveComputerNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
