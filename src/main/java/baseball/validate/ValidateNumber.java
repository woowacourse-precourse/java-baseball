package baseball.validate;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class ValidateNumber {
    private static final String CHECK_DIGIT_LENGTH = "숫자의 자릿수를 확인해주세요";
    private static final String NO_OVERLAP_NUMBER = "각 자리가 중복되지 않는 수를 입력해주세요";
    private static final String ONLY_IN_CHOICE_LIST = "목록에 있는 숫자를 선택해주세요";
    private static final int REGAME_NUMBER = 1;
    private static final int END_GAME_NUMBER = 2;

    private final static List<Integer> CHOICE_LIST = List.of(REGAME_NUMBER, END_GAME_NUMBER);

    /**
     * 입력 받은 숫자의 자릿수와 게임에서 설정한 자릿수 비교
     * @param number 입력 받은 수
     * @param p 입력 받은 수의 길이와 게임에서 설정한 자릿수를 비교한다.
     */
    public static void validateLength(int number, Predicate<Integer> p) {
        String s = String.valueOf(number);
        int length = s.length();
        if (!p.test(length)) {
            throw new IllegalArgumentException(CHECK_DIGIT_LENGTH);
        }
    }

    /**
     * 입력 받은 숫자를 구성하는 수가 중복이 있는지 확인
     * @param number 입력 받은 수
     */
    public static void validateOverlap(int number) {
        String[] splitNumber = String.valueOf(number).split("");
        LinkedList<String> linkedList = new LinkedList<>();
        for (String n : splitNumber) {
            linkedList.add(n);
        }

        while (linkedList.size() != 0) {
            String pop = linkedList.pop();
            if (linkedList.contains(pop)) {
                throw new IllegalArgumentException(NO_OVERLAP_NUMBER);
            }
        }

    }

    /**
     * 선택 목록에 있는 숫자를 선택했는지 확인
     * @param number 입력 받은 수
     */
    public static void validateInList(int number) {
        if (!CHOICE_LIST.contains(number)) {
            throw new IllegalArgumentException(ONLY_IN_CHOICE_LIST);
        }
    }

}
