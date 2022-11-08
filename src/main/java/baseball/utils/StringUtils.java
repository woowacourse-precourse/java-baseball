package baseball.utils;

import java.util.Objects;

public class StringUtils {
    private static final String UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE = "생성할 수 없는 Utility 클래스입니다.";
    
    private StringUtils() {
        throw new IllegalStateException(UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE);
    }
    
    public static boolean isBlank(final String userNumbers) {
        return Objects.isNull(userNumbers) || userNumbers.isEmpty();
    }
}
