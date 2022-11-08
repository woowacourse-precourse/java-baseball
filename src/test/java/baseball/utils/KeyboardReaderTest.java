package baseball.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.utils.resources.InputKey;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

;

class KeyboardReaderTest extends NsTest {
    private ReadingType readingType;
    private Object returnValue;

    interface ReadingType {
        Object read();
    }

    @Nested
    @DisplayName("키보드로 정수로 이루어진 문자열만 입력받기 테스트")
    class ReadOnlyIntegerTest {
        @BeforeEach
        void initializeReaderType() {
            setReadType(KeyboardReader::readLineOnlyInteger);
        }

        @Test
        @DisplayName("키보드 숫자 입력받기 : 정수값을 입력받은 경우 해당 문자열을 그대로 반환")
        void 키보드_숫자_입력받기_정수값을_입력받은_경우() {
            run("1");
            assertThat(returnValue.toString())
                    .isNotNull()
                    .isNotEmpty()
                    .isEqualTo("1");
        }

        @Test
        @DisplayName("키보드 숫자 입력받기 :0으로 시작하는 정수값을 입력받은 경우 해당 문자열을 그대로 반환")
        void 키보드_숫자_입력받기_0으로_시작하는_정수값을_입력받은_경우() {
            run("023");
            assertThat(returnValue.toString())
                    .isNotNull()
                    .isNotEmpty()
                    .isEqualTo("023");
        }

        @Test
        @DisplayName("키보드 숫자 입력받기 : 정수가 아닌 값을 입력받은 경우 예외발생")
        void 키보드_숫자_입력받기_예외테스트() {
            assertThatThrownBy(() -> run("ABC"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[오류] 입력값은 정수만 허용됩니다.");
        }

    }

    @Nested
    @DisplayName("키보드로 결정키워드 재시작/종료 입력받기 테스트")
    class ReadLineAsBooleanKeyTest {
        @BeforeEach
        void initializeReaderType() {
            setReadType(() -> KeyboardReader.readLineAsBooleanKey(InputKey.RESTART, InputKey.QUIT));
        }

        @Test
        @DisplayName("재시작/종료 키워드 입력받기 : 재시작 키워드를 받은 경우 true를 반환")
        void 키보드_결정_키워드_받기_재시작() {
            run(InputKey.RESTART.text());
            assertThat((boolean) returnValue).isTrue();
        }

        @Test
        @DisplayName("재시작/종료 키워드 입력받기 : 종료 키워드를 받은 경우 false를 반환")
        void 키보드_결정_키워드_받기_종료() {
            run(InputKey.QUIT.text());
            assertThat((boolean) returnValue).isFalse();
        }

        @Test
        @DisplayName("재시작/종료 키워드 입력받기 : 부정확한 키워드를 받은 경우 예외발생")
        void 키보드_재시작_종료_키워드_받기_부정확한_키워드_01_예외발생() {
            assertThatThrownBy(() -> run("01"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[오류] 잘못된 키워드를 입력하였습니다.");
        }
    }

    private void setReadType(ReadingType type) {
        this.readingType = type;
    }

    @Override
    public void runMain() {
        returnValue = readingType.read();
    }
}