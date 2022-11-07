package baseball.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HomeRun {

    public List<BallNumber> homeRun(BallNumbersCreateStrategy homeRunStrategy) {
        List<Integer> ballNumbers = homeRunStrategy.createBallNumbers();

        return ballNumbers.stream()
                .map(String::valueOf)
                .map(stringNumber -> stringNumber.codePoints().mapToObj(string -> (char) string))
                .flatMap(Stream::distinct)
                .map(BallNumber::ballNumber)
                .collect(Collectors.toList());
    }
}
