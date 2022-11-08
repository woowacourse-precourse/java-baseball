package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListUtil {

    static public int getRandomIntegerExcludeInList(List<Integer> answer) {
        int number;

        do {
            number = Randoms.pickNumberInRange(1, 9);
        } while (answer.contains(number));

        return number;
    }

    static public List<Integer> stringToSeparatedIntegerList(String input, int INPUT_LENGTH) throws IllegalArgumentException {
        if (UserInputException.isContainLetter(input)) {
            throw new IllegalArgumentException("문자가 포함되어 있습니다.");
        }

        if (!UserInputException.isInputLength(input, INPUT_LENGTH)) {
            throw new IllegalArgumentException("입력의 숫자의 길이가 맞지 않습니다.");
        }

        return IntStream.range(0, input.length())
                .map(i -> Character.getNumericValue(input.charAt(i)))
                .boxed()
                .collect(Collectors.toList());
    }

    static public int countSameNumberInLists(List<Integer> guess, List<Integer> answer) {
        return (int) guess.stream()
                .filter(number -> answer.contains(number))
                .count();
    }
}
