package baseball.validator;

import java.util.List;

import static baseball.contants.Contants.*;

public class InputValidator {

    // 재실행 입력 검증
    public static void validateNotInPlaying(String input) {
        if (!(input.equals(NEW_GAME) || input.equals(END_GAME))) throw new IllegalArgumentException(EXCEPTION_CHOICE);
    }

    // 게임 중 - 서로 다른 LIST_SIZE 자리 수
    public static void validateInPlaying(List<Integer> input) {
        validateCharacterInPlaying(input);
        long deduplicatedSize = input.stream().distinct().count();
        if (deduplicatedSize != LIST_SIZE) throw new IllegalArgumentException(EXCEPTION_DUPLICATED);
    }

    // 1 ~ 9 내 문자 입력 검증
    public static void validateCharacterInPlaying(List<Integer> input) {
        if (!input.stream().allMatch(n -> n > 0 && n < 10)) throw new IllegalArgumentException(EXCEPTION_OVER_RANGE);
    }
}
