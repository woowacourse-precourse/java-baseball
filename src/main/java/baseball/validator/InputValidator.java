package baseball.validator;

import java.util.List;

public class InputValidator {

    // 2. 게임 종료 - 1 혹은 2
    public static boolean validateNotInPlaying(List<Integer> input){
        if ( invalidCharacterNotInPlaying(input) && input.size() == 1) return true;
        return false;
    }

    // 게임 중 - 서로 다른 3자리 수
    public static boolean validateInPlaying(List<Integer> input){
        long deduplicatedSize = input.stream().distinct().count();
        if ( invalidCharacterInPlaying(input) && deduplicatedSize == 3 ) return true;
        return false;
    }
    // 1 ~ 9 외의 문자 입력 ( base )
    public static boolean invalidCharacterInPlaying(List<Integer> input){
        return input.stream().allMatch(n -> n > 0 && n < 10);
    }

    public static boolean invalidCharacterNotInPlaying(List<Integer> input){
        return input.stream().allMatch(n -> n > 0 && n < 2);
    }
}
