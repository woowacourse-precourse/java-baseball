package bestpractice.baseball;

import bestpractice.baseball.domain.Judgment;
import bestpractice.baseball.domain.NumberGenerator;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        NumberGenerator generator = new NumberGenerator();
        List<Integer> randomNumbers = generator.createRandomNumbers();
        System.out.println(randomNumbers);

        Judgment judgment = new Judgment();
        int count = judgment.correctCount(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 9));
        System.out.println(count);

        boolean place = judgment.hasPlace(Arrays.asList(1, 2, 3), 0, 2);
        System.out.println(place);


    }
}
