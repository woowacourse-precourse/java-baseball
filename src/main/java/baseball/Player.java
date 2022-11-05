package baseball;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    private List<Integer> numbers = new ArrayList<>();

    public List<Integer> getNumbers() {
        return numbers;
    }

    public abstract void setNumbers(int sizeOfNumbers);
}
