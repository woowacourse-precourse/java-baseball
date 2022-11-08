package baseball.validator;

import java.util.List;

public class InputValidator {

    // 2. 게임 종료 - 1 혹은 2
    public static void validateNotInPlaying(String input) throws IllegalArgumentException {
        if (!(input.equals("1") || input.equals("2"))) throw new IllegalArgumentException();
    }

    // 게임 중 - 서로 다른 3자리 수
    public static void validateInPlaying(List<Integer> input) throws IllegalArgumentException {
        invalidCharacterInPlaying(input);
        long deduplicatedSize = input.stream().distinct().count();
        if (deduplicatedSize != 3) throw new IllegalArgumentException();
    }

    // 1 ~ 9 외의 문자 입력 ( base )
    public static void invalidCharacterInPlaying(List<Integer> input) throws IllegalArgumentException {
        if (!input.stream().allMatch(n -> n > 0 && n < 10)) throw new IllegalArgumentException();
    }
}
