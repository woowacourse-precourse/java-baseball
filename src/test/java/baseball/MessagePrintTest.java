package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class MessagePrintTest extends NsTest {

    @Nested
    @DisplayName("게임 실행 중 출력되는 메세지 테스트")
    class PrintTest {

        @Test
        @DisplayName("계산 결과 출력 메세지 테스트")
        void ballMessageTest() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("312", "213", "654", "123", "1", "798", "987", "2");
                        assertThat(output()).contains("3볼", "2볼 1스트라이크", "낫싱", "3스트라이크", "3볼", "3스트라이크", "게임 종료");
                    },
                    1, 2, 3, 9, 8, 7
            );
        }

        @Test
        @DisplayName("게임 전체 메세지 테스트")
        void entireMessageTest() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("592", "925", "734", "1", "374", "592", "2");
                        assertThat(output()).isEqualTo(
                                "숫자 야구 게임을 시작합니다.\n" +
                                        "숫자를 입력해주세요 : " +
                                        "낫싱\n" +
                                        "숫자를 입력해주세요 : " +
                                        "낫싱\n" +
                                        "숫자를 입력해주세요 : " +
                                        "3스트라이크\n" +
                                        "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n" +
                                        "숫자를 입력해주세요 : " +
                                        "낫싱\n" +
                                        "숫자를 입력해주세요 : " +
                                        "3스트라이크\n" +
                                        "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    },
                    7, 3, 4, 5, 9, 2
            );
        }

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
