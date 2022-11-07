package baseball.core;

import baseball.core.converter.ThreeNumberConverter;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Player {

    private List<Integer> threeNumbers;
    private final ThreeNumberConverter converter;

    public Player() {
        this.converter = new ThreeNumberConverter();
    }

    public void inputThreeNumbers() {
        this.threeNumbers = converter.getThreeNumbers(Console.readLine());
    }

    public List<Integer> sayThreeNumbers() {
        return threeNumbers;
    }

    public StatusCode inputStatusCode() {
        return StatusCode.from(Console.readLine());
    }
}
