package baseball.model.number;

import baseball.model.util.Constant;
import baseball.model.util.Utilization;
import baseball.model.util.Validation;

import java.util.List;

public abstract class ComputerNumber {
    public static NumberDto generate() {
        return new NumberDto(generateNumberList());
    }

    public static NumberDto generate(NumberDto numberDto) {
        numberDto.setNumber(generateNumberList());
        return numberDto;
    }

    private static List<Integer> generateNumberList() {
        List<Integer> numbers = Utilization.pickRandomNumberList();
        while (!Validation.validateNumberNotRepeated(numbers, Constant.NUMBER_LENGTH)) {
            numbers = Utilization.pickRandomNumberList();
        }
        return numbers;
    }
}
