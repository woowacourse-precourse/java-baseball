package baseball.view;

import baseball.dto.StrikeBallCountDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.NsTest;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleViewTest extends NsTest{

    @Test
    void printStrikeBallCount() {
        //given
        ConsoleView consoleView = new ConsoleView();

        //when
        StrikeBallCountDto strikeBallCountDto1 = new StrikeBallCountDto(3, 0);
        StrikeBallCountDto strikeBallCountDto2 = new StrikeBallCountDto(2, 0);
        StrikeBallCountDto strikeBallCountDto3 = new StrikeBallCountDto(0, 2);
        StrikeBallCountDto strikeBallCountDto4 = new StrikeBallCountDto(1, 1);

        consoleView.printStrikeBallCount(strikeBallCountDto1);
        consoleView.printStrikeBallCount(strikeBallCountDto2);
        consoleView.printStrikeBallCount(strikeBallCountDto3);
        consoleView.printStrikeBallCount(strikeBallCountDto4);

        //then
        Assertions.assertThat(output()).contains("3스트라이크", "2스트라이크", "2볼", "1볼 1스트라이크");
    }

    @Override
    protected void runMain() {}
}