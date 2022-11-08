package baseball;

import baseball.game.BaseballGame;
import baseball.game.BaseballInput;
import baseball.game.BaseballResult;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    private static BaseballInput baseballInput;
    @BeforeAll
    static void initAll(){
        baseballInput = new BaseballInput();
    }

    @Test
    void 리스트_반환_테스트(){
        String input = "456";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        char[] input_list = input.toCharArray();
        List<Integer> result_list = new ArrayList<>();
        for(int i = 0; i < input_list.length; i++){
            result_list.add(input_list[i] - '0');
        }
        System.setIn(in);
        baseballInput.userInputGame();
        assertThat(baseballInput.inputNumList).isEqualTo(result_list);
    }

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
