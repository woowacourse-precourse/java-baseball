package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> numbers = new ArrayList<>();

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void addNumber(int number) {
        numbers.add(number);
    }

    public void initialize() {
        numbers.clear();
    }
}
