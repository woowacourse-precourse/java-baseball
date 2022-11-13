package bestpractice.baseball;

import bestpractice.baseball.domain.Judgment;
import bestpractice.baseball.domain.NumberGenerator;
import bestpractice.baseball.domain.Referee;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        Referee referee = new Referee();
        String result = referee.compare(Arrays.asList(6, 5, 4), Arrays.asList(1, 2, 3));
        System.out.println(result);

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
