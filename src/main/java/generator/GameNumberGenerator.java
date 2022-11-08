package generator;

import java.util.List;
import java.util.ArrayList;

public class GameNumberGenerator {
    private final List<Integer> numbers; // 수집된 숫자들을 저장

    public GameNumberGenerator() {
        this.numbers = new ArrayList<>(3);
    }

    public GameNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public String getNumber() {
        while (numbers.size() < 3) {
            int number = RandomNumberGenerator.getNumber();
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return this.getNumberString();
    }

    private String getNumberString() {
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number);
        }
        numbers.clear(); // 재사용을 위해 비움
        return sb.toString();
    }
}
