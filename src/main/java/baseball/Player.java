package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private static final int PLAYER_NUMBERS_SIZE = 3;

    private List<Integer> numbers;

    public Player(List<Integer> numbers){
        validateRange(numbers);
        validateSize(numbers);
        validateDuplicate(numbers);

        this.numbers = numbers;
    }

    private void validateRange(List<Integer> numbers){
        if(!numbers.stream().allMatch(number -> number > 0 && number <10))
            throw new IllegalArgumentException("Wrong number range");
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

    public int findIndexOfNumber(int number){
        return this.numbers.indexOf(number);
    }

    public boolean compareIndex(int index, int number){
        return this.numbers.get(index).equals(number);
    }
}
