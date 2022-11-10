package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

class GameTest extends NsTest {
    @Test
    void 알파벳_입력_오류(){
        Game game = new Game();

        Exception ex = Assertions.assertThrows(Exception.class, () -> game.getUserNumber("abcd"));
        Assertions.assertEquals("3자리 숫자 입력",ex);
    }

    @Test
    void 세자리가_아닌_여러자리_입력() {
        Game game = new Game();

        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);

        Assertions.assertEquals(game.getUserNumber("123"),arr);

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
