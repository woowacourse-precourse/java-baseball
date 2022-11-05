package baseball.player;

import baseball.utils.NumberParsing;

import java.util.ArrayList;
import java.util.List;


public class Computer {


    private List<Integer> computerNumbers;

    public Computer() {
        this.computerNumbers = createNonDuplicationRandomThreeNumbers();
    }

    private List<Integer> createNonDuplicationRandomThreeNumbers() {

        List<Integer> numbers = new ArrayList<>();

        for (; ; ) {

            numbers = NumberParsing.createRandomNumbers(numbers, 3, 1, 9);

            if (!NumberParsing.isDuplication(numbers)) {
                break;
            }

        }

        return numbers;
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }
}
