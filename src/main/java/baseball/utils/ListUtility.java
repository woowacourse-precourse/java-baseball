package baseball.utils;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public final class ListUtility {
    private ListUtility() {
    }

    public static ArrayList<Integer> splitDigitsIntoList(int number) {
        ArrayList<Integer> splittedDigits = new ArrayList<>();
        String stringNumber = Integer.toString(number);
        for (int i = 0; i < stringNumber.length(); i++) {
            char charDigit = stringNumber.charAt(i);
            splittedDigits.add(Character.getNumericValue(charDigit));
        }
        return splittedDigits;
    }

    public static int getDistinctCountInIntegerList(List<Integer> list) {
        return (int) makeDistinctStream(list)
                .count();
    }

    public static int mergeDistinctIntegerInList(List<Integer> list) {
        return makeDistinctStream(list)
                .reduce((x, y) -> x * 10 + y)
                .get();
    }

    private static Stream<Integer> makeDistinctStream(List<Integer> list) {
        return list
                .stream()
                .distinct();
    }
}
