package baseball.view;

import org.junit.jupiter.api.Test;

import static baseball.view.Input.*;

class InputTest {

    @Test
    void 사용자_숫자_입력받기() {
        String input = userNum();
        System.out.println("input = " + input);
    }

    @Test
    void 사용자_종료여부_입력받기() {
        String input = exitStatus();
        System.out.println("input = " + input);
    }
}