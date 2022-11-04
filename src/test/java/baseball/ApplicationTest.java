package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
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

    @Nested
    class 숫자_유효성_확인_기능 {
        @Nested
        class 중복_수_확인_기능 {
            @Test
            void 중복_값이_아닌_경우() {
                assertThat(Validate.validateSameNumber("123")).isEqualTo(true);
            }

            @Test
            void 중복_값인_경우() {
                assertThat(Validate.validateSameNumber("112")).isEqualTo(false);
            }
        }

        @Nested
        class 길이_확인_기능 {
            @Test
            void 길이가_같은_경우() {
                assertThat(Validate.validateCountNumber("123", 3)).isEqualTo(true);
            }

            @Test
            void 길이가_긴_경우() {
                assertThat(Validate.validateCountNumber("1234", 3)).isEqualTo(false);
            }

            @Test
            void 길이가_짧은_경우() {
                assertThat(Validate.validateCountNumber("12", 3)).isEqualTo(false);
            }
        }
    }
}
