package baseball.domain;

import baseball.generator.NumbersGenerator;

import java.util.List;

public class Computer {

    private NumbersGenerator numbersGenerator;

    public Computer(NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    public List<Integer> generateNumber() {
        return numbersGenerator.generate();
    }
}
