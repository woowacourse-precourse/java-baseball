package baseball.domain.repository;

import java.util.ArrayList;
import java.util.List;

public class NumberRepositoryImpl implements NumberRepository{

    private List<Integer> numbers;

    @Override
    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    @Override
    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
