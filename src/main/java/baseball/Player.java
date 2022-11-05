package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private static final int PLAYER_NUMBERS_SIZE = 3;

    private List<Integer> numbers;

    public Player(List<Integer> numbers){
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers){
        if(numbers.size() != PLAYER_NUMBERS_SIZE)
            throw new IllegalArgumentException("numbers size is not 3");
    }

    private void validateDuplicate(List<Integer> numbers){
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if(nonDuplicateNumbers.size() != PLAYER_NUMBERS_SIZE)
            throw new IllegalArgumentException("duplicates in the numbers");
    }
}
