package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    //pickNumInRange를 검증??

    @Nested
    @DisplayName("컴퓨터")
    class ComputerTest {

        @Nested
        @DisplayName("는 입력받은 숫자들이")
        class ComputerInputTest {
            @Test
            @DisplayName("정상이면 오류를 일으키지 않는다")
            void 입력_정상() {
                Computer computer = new Computer();
                computer.putAnswer(List.of(9,1,4));
            }

            @Test
            @DisplayName("세 개가 아니면 오류를 반환한다")
            void 입력_세개_아님_오류() {
                Computer computer = new Computer();
                assertThatThrownBy(() -> computer.putAnswer(List.of(1, 9)))
                        .isInstanceOf(IllegalArgumentException.class);
            }

            @Test
            @DisplayName("중복되면 오류를 반환한다")
            void 입력_중복_오류() {
                Computer computer = new Computer();
                assertThatThrownBy(() -> computer.putAnswer(List.of(1, 8, 8)))
                        .isInstanceOf(IllegalArgumentException.class);
            }
            @Test
            @DisplayName("1보다 작은 수가 껴있으면 오류를 반환한다")
            void 입력_정상() {
                Computer computer = new Computer();
                assertThatThrownBy(() -> computer.putAnswer(List.of(0, 8, 8)))
                        .isInstanceOf(IllegalArgumentException.class);
            }
            @Test
            @DisplayName("9보다 큰 수가 껴있으면 오류를 반환한다")
            void 입력_정상() {
                Computer computer = new Computer();
                assertThatThrownBy(() -> computer.putAnswer(List.of(1, 8, 10)))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        @DisplayName("입력받은 결과가")
        class ComputerResultTest {
            @Test
            @DisplayName("모두 동일하면 3스트라이크, 0볼을 반환한다")
            void 쓰리_스트라이크() {
                Computer computer = new Computer();
                computer.putAnswer(List.of(9,1,4));
                assertThat(computer.returnResult(List.of(9, 1, 4))).isEqualTo([3, 0]);
            }

            @Test
            @DisplayName("2스트라이크, 0볼을 반환한다")
            void 투_스트라이크() {
                Computer computer = new Computer();
                computer.putAnswer(List.of(9,1,4));
                assertThat(computer.returnResult(List.of(0, 1, 4))).isEqualTo([2, 0]);
            }

            @Test
            @DisplayName("1스트라이크, 2볼을 반환한다")
            void 원_스트라이크_투_볼() {
                Computer computer = new Computer();
                computer.putAnswer(List.of(4,1,9));
                assertThat(computer.returnResult(List.of(9, 1, 4))).isEqualTo([1, 2]);
            }

            @Test
            @DisplayName("1스트라이크, 1볼을 반환한다")
            void 원_스트라이크_원_볼() {
                Computer computer = new Computer();
                computer.putAnswer(List.of(9,1,4));
                assertThat(computer.returnResult(List.of(4, 1, 5))).isEqualTo([1, 1]);
            }

            @Test
            @DisplayName("1스트라이크, 0볼을 반환한다")
            void 원_스트라이크_원_볼() {
                Computer computer = new Computer();
                computer.putAnswer(List.of(9,1,4));
                assertThat(computer.returnResult(List.of(3, 6, 4))).isEqualTo([1, 0]);
            }

            @Test
            @DisplayName("0스트라이크, 1볼을 반환한다")
            void 원_스트라이크_원_볼() {
                Computer computer = new Computer();
                computer.putAnswer(List.of(9,1,4));
                assertThat(computer.returnResult(List.of(4,2,3))).isEqualTo([0, 1]);
            }

            @Test
            @DisplayName("0스트라이크, 2볼을 반환한다")
            void 원_스트라이크_원_볼() {
                Computer computer = new Computer();
                computer.putAnswer(List.of(9,1,4));
                assertThat(computer.returnResult(List.of(4,9,3))).isEqualTo([0, 2]);
            }

            @Test
            @DisplayName("0스트라이크, 3볼을 반환한다")
            void 원_스트라이크_원_볼() {
                Computer computer = new Computer();
                computer.putAnswer(List.of(9,1,4));
                assertThat(computer.returnResult(List.of(1,4,9))).isEqualTo([0, 3]);
            }

            @Test
            @DisplayName("0스트라이크, 0볼을 반환한다")
            void 원_스트라이크_원_볼() {
                Computer computer = new Computer();
                computer.putAnswer(List.of(9,1,4));
                assertThat(computer.returnResult(List.of(7,3,8))).isEqualTo([0, 0]);
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
