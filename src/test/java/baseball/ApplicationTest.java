package baseball;

import baseball.domain.BaseballNumber;
import baseball.domain.Computer;
import baseball.domain.Result;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Nested
    @DisplayName("컴퓨터 ->")
    class ComputerTest {

        @Nested
        @DisplayName("입력받은 숫자 ->")
        class ComputerInputTest {
            @Test
            @DisplayName("정상이면 오류를 일으키지 않는다")
            void 입력_정상() {
                Computer computer = new Computer(){
                    @Override
                    protected List<Integer> makeNotDuplicatedRandomNumbers() {
                        return List.of(9, 1, 4);
                    }
                };
                computer.putAnswer();
            }

            @Test
            @DisplayName("세 개가 아니면 오류를 반환한다")
            void 입력_세개_아님_오류() {
                Computer computer = new Computer(){
                    @Override
                    protected List<Integer> makeNotDuplicatedRandomNumbers() {
                        return List.of(9, 1);
                    }
                };
                assertThatThrownBy(() -> computer.putAnswer()).isInstanceOf(IllegalArgumentException.class);
            }

            @Test
            @DisplayName("중복되면 오류를 반환한다")
            void 입력_중복_오류() {
                Computer computer = new Computer(){
                    @Override
                    protected List<Integer> makeNotDuplicatedRandomNumbers() {
                        return List.of(1, 8, 8);
                    }
                };
                assertThatThrownBy(() -> computer.putAnswer()).isInstanceOf(IllegalArgumentException.class);
            }

            @Test
            @DisplayName("1보다 작은 수가 껴있으면 오류를 반환한다")
            void 입력_1보다_작은수_오류() {
                Computer computer = new Computer() {
                    @Override
                    protected List<Integer> makeNotDuplicatedRandomNumbers() {
                        return List.of(0, 8, 9);
                    }
                };
                assertThatThrownBy(() -> computer.putAnswer()).isInstanceOf(IllegalArgumentException.class);
            }

            @Test
            @DisplayName("9보다 큰 수가 껴있으면 오류를 반환한다")
            void 입력_1보다_큰수_오류() {
                Computer computer = new Computer() {
                    @Override
                    protected List<Integer> makeNotDuplicatedRandomNumbers() {
                        return List.of(1, 8, 10);
                    }
                };
                assertThatThrownBy(() -> computer.putAnswer()).isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        @DisplayName("입력받은 결과 -> ")
        class ComputerResultTest {
            @Test
            @DisplayName("모두 동일하면 3스트라이크, 0볼을 반환한다")
            void 쓰리_스트라이크() {
                Computer computer = new Computer(){
                    @Override
                    protected List<Integer> makeNotDuplicatedRandomNumbers() {
                        return List.of(9, 1, 4);
                    }
                };
                computer.putAnswer();
                assertThat(computer.returnResult(new BaseballNumber(List.of(9, 1, 4)))).isEqualTo(new Result(3, 0));
            }

            @Test
            @DisplayName("2스트라이크, 0볼을 반환한다")
            void 투_스트라이크() {
                Computer computer = new Computer(){
                    @Override
                    protected List<Integer> makeNotDuplicatedRandomNumbers() {
                        return List.of(9, 1, 4);
                    }
                };
                computer.putAnswer();
                assertThat(computer.returnResult(new BaseballNumber(List.of(8, 1, 4)))).isEqualTo(new Result(2, 0));
            }

            @Test
            @DisplayName("1스트라이크, 2볼을 반환한다")
            void 원_스트라이크_투_볼() {
                Computer computer = new Computer(){
                    @Override
                    protected List<Integer> makeNotDuplicatedRandomNumbers() {
                        return List.of(4, 1, 9);
                    }
                };
                computer.putAnswer();
                assertThat(computer.returnResult(new BaseballNumber(List.of(9, 1, 4)))).isEqualTo(new Result(1, 2));
            }

            @Test
            @DisplayName("1스트라이크, 1볼을 반환한다")
            void 원_스트라이크_원_볼() {
                Computer computer = new Computer(){
                    @Override
                    protected List<Integer> makeNotDuplicatedRandomNumbers() {
                        return List.of(9, 1, 4);
                    }
                };
                computer.putAnswer();
                assertThat(computer.returnResult(new BaseballNumber(List.of(4, 1, 5)))).isEqualTo(new Result(1, 1));
            }

            @Test
            @DisplayName("1스트라이크, 0볼을 반환한다")
            void 원_스트라이크_0_볼() {
                Computer computer = new Computer(){
                    @Override
                    protected List<Integer> makeNotDuplicatedRandomNumbers() {
                        return List.of(9, 1, 4);
                    }
                };
                computer.putAnswer();
                assertThat(computer.returnResult(new BaseballNumber(List.of(3, 6, 4)))).isEqualTo(new Result(1, 0));
            }

            @Test
            @DisplayName("0스트라이크, 1볼을 반환한다")
            void 영_스트라이크_원_볼() {
                Computer computer = new Computer(){
                    @Override
                    protected List<Integer> makeNotDuplicatedRandomNumbers() {
                        return List.of(9, 1, 4);
                    }
                };
                computer.putAnswer();
                assertThat(computer.returnResult(new BaseballNumber(List.of(4, 2, 3)))).isEqualTo(new Result(0, 1));
            }

            @Test
            @DisplayName("0스트라이크, 2볼을 반환한다")
            void 영_스트라이크_투_볼() {
                Computer computer = new Computer(){
                    @Override
                    protected List<Integer> makeNotDuplicatedRandomNumbers() {
                        return List.of(9, 1, 4);
                    }
                };
                computer.putAnswer();
                assertThat(computer.returnResult(new BaseballNumber(List.of(4, 9, 3)))).isEqualTo(new Result(0, 2));
            }

            @Test
            @DisplayName("0스트라이크, 3볼을 반환한다")
            void 영_스트라이크_쓰리_볼() {
                Computer computer = new Computer(){
                    @Override
                    protected List<Integer> makeNotDuplicatedRandomNumbers() {
                        return List.of(9, 1, 4);
                    }
                };
                computer.putAnswer();
                assertThat(computer.returnResult(new BaseballNumber(List.of(1, 4, 9)))).isEqualTo(new Result(0, 3));
            }

            @Test
            @DisplayName("0스트라이크, 0볼을 반환한다")
            void 영_스트라이크_영_볼() {
                Computer computer = new Computer(){
                    @Override
                    protected List<Integer> makeNotDuplicatedRandomNumbers() {
                        return List.of(9, 1, 4);
                    }
                };
                computer.putAnswer();
                assertThat(computer.returnResult(new BaseballNumber(List.of(7, 3, 8)))).isEqualTo(new Result(0, 0));
            }
        }
        // 의문 : 재입력 테스트..? 근데 이게 단위테스트가 맞나? 뭔가 "행동"에 관련된 테스트 아냐?? 음....
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
