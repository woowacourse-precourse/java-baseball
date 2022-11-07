package baseball.model;

import baseball.model.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseBallGame {

    public Map<BaseBallHitsType, Integer> baseBallHitsTypeMap(BallNumbers hits, BallNumbersCreateStrategy homeRunStrategy) {
        return BaseBallHitsType.hitsTypeMap(homeRun(homeRunStrategy),hits);
    }

    private BallNumbers homeRun(BallNumbersCreateStrategy homeRunStrategy) {
       return new BallNumbers(createChars(homeRunStrategy));
    }

    private List<Character> createChars(BallNumbersCreateStrategy homeRunStrategy) {
        List<Integer> ballNumbers = homeRunStrategy.createBallNumbers();

        return ballNumbers.stream()
                .map(String::valueOf)
                .map(stringNumber -> stringNumber.codePoints().mapToObj(string -> (char) string))
                .flatMap(Stream::distinct)
                .collect(Collectors.toList());
    }
}
