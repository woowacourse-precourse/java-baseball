package baseball.number;

import java.util.List;

import static baseball.util.Constant.NUMBER_LENGTH;
import static baseball.util.Util.pickRandomNumberList;
import static baseball.util.Validation.validateNumberNotRepeated;

public abstract class ComputerNumber {
    public static NumberDto generate() {
        return new NumberDto(generateNumberList());
    }

    public static NumberDto generate(NumberDto numberDto) {
        numberDto.setNumber(generateNumberList());
        return numberDto;
    }

    private static List<Integer> generateNumberList() {
        List<Integer> numbers = pickRandomNumberList();
        while (!validateNumberNotRepeated(numbers, NUMBER_LENGTH)) {
            numbers = pickRandomNumberList();
        }
        return numbers;
    }
}
