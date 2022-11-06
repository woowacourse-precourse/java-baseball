package baseball.view;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


import static baseball.view.InputView.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class viewTest extends NsTest {
    @Test
    void startProgramViewTest(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("123","2");
                    Assertions.assertThat(output()).contains("숫자 야구 게임을 시작합니다.");
                },
                1,2,3
        );
    }

    @Test
    void inputNumbersViewTest(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("123","2");
                    Assertions.assertThat(output()).contains("숫자를 입력해주세요 :");
                },
                1,2,3
        );
    }

    @Test
    void inputRestartViewTest(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("123","2");
                    Assertions.assertThat(output()).contains("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                },
                1,2,3
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
