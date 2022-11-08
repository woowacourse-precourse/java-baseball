package baseball.validate;

import java.util.List;

public class ValidateNumber {
    private static final String ONLY_IN_CHOICE_LIST = "목록에 있는 숫자를 선택해주세요";
    private static final int REGAME_NUMBER = 1;
    private static final int END_GAME_NUMBER = 2;

    private final static List<Integer> CHOICE_LIST = List.of(REGAME_NUMBER, END_GAME_NUMBER);

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
