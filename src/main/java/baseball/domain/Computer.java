package baseball.domain;

import baseball.RandomNumberGenerator;

import java.util.List;

public class Computer {

    private final RandomNumberGenerator generator;

    public Computer(RandomNumberGenerator generator) {
        this.generator = generator;
    }

    public Answer generate() {
        List<Integer> generate = generator.generate();
        return new Answer(generate);
    }
}
