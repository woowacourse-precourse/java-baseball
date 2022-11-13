package bestpractice.baseball;

import bestpractice.baseball.domain.NumberGenerator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        NumberGenerator generator = new NumberGenerator();
        List<Integer> randomNumbers = generator.createRandomNumbers();
        System.out.println(randomNumbers);
    }
}
