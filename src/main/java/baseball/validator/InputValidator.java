package baseball.validator;

import java.util.List;

public class InputValidator {

    // 2. 게임 종료 - 1 혹은 2
    public static void validateNotInPlaying(String input) {
        if (!(input.equals("1") || input.equals("2"))) throw new IllegalArgumentException("1 혹은 2만 입력하세요.");
    }

    // 게임 중 - 서로 다른 3자리 수
    public static void validateInPlaying(List<Integer> input) {
        invalidCharacterInPlaying(input);
        long deduplicatedSize = input.stream().distinct().count();
        if (deduplicatedSize != 3) throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
    }

    // 1 ~ 9 외의 문자 입력 ( base )
    public static void invalidCharacterInPlaying(List<Integer> input) {
        if (!input.stream().allMatch(n -> n > 0 && n < 10)) throw new IllegalArgumentException("1 ~ 9 사이 숫자를 입력하세요.");
    }
}
