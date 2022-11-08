package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListUtil {
    public static int getRandomIntegerExcludeInList(List<Integer> answer) {
        int number;

        do {
            number = Randoms.pickNumberInRange(1, 9);
        } while (answer.contains(number));

        return number;
    }

    public static List<Integer> stringToSeparatedIntegerList(String input, int INPUT_LENGTH) throws IllegalArgumentException {
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

    public static int countSameNumberInSameLocationInLists(List<Integer> guess, List<Integer> answer) {
        return (int) guess.stream()
                .filter(number -> answer.contains(number))
                .count();
    }

    public static int countSameNumberInLists(List<Integer> guess, List<Integer> answer) {
        return (int) IntStream.range(0, 3)
                .filter(index -> answer.get(index) == guess.get(index))
                .count();
    }
}
