package baseball.number;

import static baseball.util.Util.pickRandomNumberList;

public abstract class ComputerNumber {
    public static NumberDto generate() {
        return new NumberDto(pickRandomNumberList());
    }

    public static NumberDto generate(NumberDto numberDto) {
        numberDto.setNumber(pickRandomNumberList());
        return numberDto;
    }
}
