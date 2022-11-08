package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Exceptions {
    List<Integer> user = new ArrayList<>();
    Set<Integer> userSet = new HashSet<>(user);

    public void exceptionTest() throws RedundantException, SizeException, NaturalException {

        if (userSet.size() != user.size()) {
            throw new RedundantException("중복되는 숫자를 입력할 수 없습니다.");
        }
        if (user.size() != 3) {
            throw new SizeException("숫자 세개를 입력해야 합니다.");
        }
        if (user.contains(0)) {
            throw new NaturalException("1~9 사이의 숫자를 입력해야 합니다.");
        }
    }
    static class RedundantException extends Exception {
        RedundantException(String redundant) {
            super(redundant);
        }
    }

    static class SizeException extends Exception {
        SizeException(String size) {
            super(size);
        }
    }

    static class NaturalException extends Exception {
        NaturalException(String natural) {
            super(natural);
        }
    }
}

