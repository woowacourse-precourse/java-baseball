package baseball.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.Application;
import baseball.constants.GuideSentences;
import baseball.testhelper.ComparingResultExample;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class GameOperatorTest extends NsTest {

    String[] command;
    String expected = "";
    String oneBall = ComparingResultExample.ONE_BALL.getNumbers()
            .toString().replaceAll("[^1-9]", "");
    String threeStrike = ComparingResultExample.THREE_STRIKE.getNumbers()
            .toString().replaceAll("[^1-9]", "");

    @Test
    @DisplayName("숫자 야구 게임 테스트")
    void numberBaseballGameTest() {
        setCommand();
        setExpected();

        assertRandomNumberInRangeTest(
                () -> {
                    run(command);
                    assertThat(output()).isEqualTo(expected);
                },
                4, 5, 6, 4, 5, 6
        );
    }

    void setCommand() {
        List<String> commandList = new ArrayList<>();

        // 실행 예시 ComparingResultExample 의 1볼, 3스트라이크 커맨드 입력 저장
        commandList.add(oneBall);
        commandList.add(threeStrike);

        // 재시작 기능 확인을 위해 아래와 같이 커맨드 입력
        // 1 -> 3스트라이크 숫자 -> 2
        commandList.add("1");
        commandList.add(threeStrike);
        commandList.add("2");

        command = commandList.toArray(new String[0]);
    }

    void setExpected() {
        List<String> expectedList = new ArrayList<>();

        // 시작 안내문 출력
        expectedList.add(GuideSentences.START_GUIDE.getSentence());

        // 커맨드 입력 "1볼, 3스트라이크"에 맞추어 '입력 안내문'과 '비교 결과' 출력
        String oneBallResult = ComparingResultExample.ONE_BALL.getResultSentence();
        expectedList.add(GuideSentences.INPUT_GUIDE.getSentence() + oneBallResult);

        String threeStrikeResult = ComparingResultExample.THREE_STRIKE.getResultSentence();
        expectedList.add(GuideSentences.INPUT_GUIDE.getSentence() + threeStrikeResult);

        // 게임 종료 안내문 및 재시작 여부
        expectedList.add(GuideSentences.END_GUIDE.getSentence());
        expectedList.add(GuideSentences.RESTART_GUIDE.getSentence());

        // 재시작 -> 3스트라이크 -> 종료
        expectedList.add(GuideSentences.INPUT_GUIDE.getSentence() + threeStrikeResult);
        expectedList.add(GuideSentences.END_GUIDE.getSentence());
        expectedList.add(GuideSentences.RESTART_GUIDE.getSentence());

        expected = String.join("\n", expectedList);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
