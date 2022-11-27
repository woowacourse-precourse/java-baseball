package baseball.domain;

import baseball.generator.NumbersGenerator;

public class Computer {

    private final NumbersGenerator generator;
    private final Compare compare;

    public Computer(NumbersGenerator generator, Compare compare) {
        this.generator = generator;
        this.compare = compare;
    }

    public boolean compare(Player player) {
        return compare.compareTo(generator.generate(), player);
    }
}
