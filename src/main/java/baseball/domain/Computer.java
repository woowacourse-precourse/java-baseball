package baseball.domain;

import baseball.generator.NumbersGenerator;
import baseball.view.InputView;

import java.util.List;

public class Computer {

    private final List<Integer> numbers;
    private final Compare compare;

    public Computer(NumbersGenerator generator, Compare compare) {
        this.numbers = generator.generate();
        this.compare = compare;
    }

    public boolean compareTo(Player player) {
        compare.strikeOrBallCount(numbers, player.selectNumbers(InputView.readNumbers()));
        return compare.isPass();
    }
}
