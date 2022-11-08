package baseball;

import static baseball.User.player;
import static baseball.User.userSet;

public class Exceptions {


    public void exceptionTest() throws RedundantException, SizeException, NaturalException {

        if (userSet.size() != player.size()) {
            throw new RedundantException("중복되는 숫자를 입력할 수 없습니다.");
        }
        if (player.size() != 3) {
            throw new SizeException("숫자 세개를 입력해야 합니다.");
        }
        if (player.contains(0)) {
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

