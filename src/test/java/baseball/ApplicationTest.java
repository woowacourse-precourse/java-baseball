package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.mockito.MockedStatic;

@DisplayName("숫자 야구 게임은")
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
class ApplicationTest extends NsTest {


    @Nested
    @Order(1)
    @TestClassOrder(ClassOrderer.OrderAnnotation.class)
    @DisplayName("게임이 시작할 때 설정된")
    public class 초기화_테스트 {
        final int RESET_COUNT = 10;
        List[] multipleAnswerNumbers = new List[RESET_COUNT];
        Game baseballGame = new Game();
        {
            IntStream.range(0, RESET_COUNT)
                    .forEach(i -> {
                        multipleAnswerNumbers[i] = baseballGame.getAnswerNumbers();
                        baseballGame.initialize();
                    });
        }
        @Test
        @Order(1)
        @DisplayName("1부터 9까지의")
        public void 숫자_범위_테스트() {
            System.out.println(String.format(
                    "다음은 총 %d회에 걸쳐 생성된 랜덤한 정답 숫자입니다.", RESET_COUNT
            ));
            System.out.println("모든 숫자는 1 ~ 9 사이의 숫자이어야 합니다");
            boolean result = Arrays.stream(multipleAnswerNumbers)
                    .flatMap(Collection::stream)
                    .peek(answerNumber -> System.out.print(String.format("%d ", answerNumber)))
                    .allMatch(answerNumber -> 0 < (int) answerNumber && (int) answerNumber <= 9);
            assertThat(result).isTrue();
        }

        @Test
        @Order(2)
        @DisplayName("서로 다른 수로 이루어진")
        public void 숫자_중복_테스트() {
            System.out.println(String.format(
                    "다음은 총 %d회에 걸쳐 생성된 랜덤한 정답 숫자들의 배열입니다.", RESET_COUNT
            ));
            System.out.println("각 배열엔 중복된 숫자가 없어야 합니다.");
            boolean result = Arrays.stream(multipleAnswerNumbers)
                    .peek(System.out::println)
                    .allMatch(answerNumbers -> answerNumbers.size() == Set.copyOf(answerNumbers).size());
            assertThat(result).isTrue();
        }

        @Test
        @Order(3)
        @DisplayName("3자리의 수를 맞추는 게임이다.")
        public void 숫자_개수_테스트() {
            System.out.println(String.format(
                    "다음은 총 %d회에 걸쳐 생성된 랜덤한 정답 숫자들의 배열입니다.", RESET_COUNT
            ));
            System.out.println("각 배열의 숫자 개수는 3개여야 합니다.");
            boolean result = Arrays.stream(multipleAnswerNumbers)
                    .peek(System.out::println)
                    .allMatch(answerNumbers -> answerNumbers.size() == 3);
            assertThat(result).isTrue();
        }
    }

    @Nested
    @Order(2)
    @DisplayName("컴퓨터의 숫자가 4, 2, 5일 때")
    public class 진행_테스트 {
        final MockedStatic<Randoms> mock = mockStatic(Randoms.class);
        {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(4, List.of(2, 5).toArray());
        }
        private final Game game = new Game();

        @Test
        @DisplayName("123을 제시한 경우 : 1스트라이크")
        public void 스트라이크_테스트() {
            game.operate("123");
            assertThat(output()).contains("1스트라이크");
        }

        @Test
        @DisplayName("456을 제시한 경우 : 1볼 1스트라이크")
        public void 볼_테스트() {
            game.operate("456");
            assertThat(output()).contains("1볼 1스트라이크");
        }

        @Test
        @DisplayName("789를 제시한 경우 : 낫싱")
        public void 낫싱_테스트 () {
            game.operate("789");
            assertThat(output()).contains("낫싱");
        }

        {
            mock.close();
        }
    }

    @Nested
    @Order(1)
    @DisplayName("게임을 종료한 후")
    public class 종료_테스트 {

        @Test
        @DisplayName("1을 입력해 게임을 다시 시작하거나 2를 입력해 완전히 종료할 수 있다.")
        public void 게임종료_후_재시작() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("246", "135", "1", "597", "589", "2");
                        assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                    },
                    1, 3, 5, 5, 8, 9
            );
        }
    }

    @Nested
    @Order(4)
    @DisplayName("사용자가 잘못된 값을 입력할 경우")
    public class 에러_테스트 {

        @Test
        @DisplayName("IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.")
        public void 예외_테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1234"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
