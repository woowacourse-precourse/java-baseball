package baseball;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final NumberGenerator numberGenerator;
    private final List<Integer> numbers;

    public Computer(NumberGenerator generateNumber) {
        this.numberGenerator = generateNumber;
        this.numbers = new ArrayList<>();
    }

    public void generateNumbers() {
        numberGenerator.generate(numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void giveNumbersToReferee(Referee referee) {
        referee.receiveComputerNumbers(numbers);
    }
}
