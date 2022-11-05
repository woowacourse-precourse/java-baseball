package baseball;

import java.util.List;

public class Exception {
    private static final int DIGIT_NUMBER = 3;

    public void userException(List<Integer> user) {
        if (user.size() != DIGIT_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
