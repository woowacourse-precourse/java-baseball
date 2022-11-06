package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashSet;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    BaseBallGame testGame = new BaseBallGame();
    @Nested
    class 게임시작기능_테스트 {
        public static final int COMPUTER_NUMBERS_SIZE = 3;
        String actualOutputWhenStartGame;
        @BeforeEach
        void 게임시작시키기() {
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            testGame.startGame();
            actualOutputWhenStartGame = out.toString()
                    .replace(System.getProperty("line.separator").toString(), "");
        }
        @Test
        void 게임시작하면_출력되는_시작문구_확인() {
            String expectedOutputWhenStartGame = "숫자 야구 게임을 시작합니다.";
            assertThat(actualOutputWhenStartGame).isEqualTo(actualOutputWhenStartGame);
        }
        @Test
        void 게임시작하면_설정되는_수가_3개인지_확인() {
            assertThat(testGame.computerNumbers.size()).isEqualTo(COMPUTER_NUMBERS_SIZE);
        }
        @Test
        void 게임시작하면_설정되는_수가_서로_다른지_확인() {
            // 만약 중복되는 수가 있다면 hashSet으로 변환했을 때 길이가 줄어든다
            HashSet<Integer> computerNumbers = new HashSet<>(testGame.computerNumbers);
            assertThat(computerNumbers.size()).isEqualTo(COMPUTER_NUMBERS_SIZE);
        }
    }

    @Nested
    class 게임진행기능_테스트 {
        @Test
        void 사용자입력이_3글자가_아니면_오류발생() {
            String inValidInput = "1234";
            assertThatThrownBy(() -> testGame.inputValidator.validateInput(inValidInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }
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
