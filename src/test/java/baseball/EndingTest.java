package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

public class EndingTest {
    Application app = new Application();

    public static InputStream getConsoleInput(String input){
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    @DisplayName("정상 ending")
    void 엔딩_테스트1(){
        String input = "2";
        InputStream in = getConsoleInput(input);
        System.setIn(in);

        assertThat(app.isEnding()).isTrue();
    }

    @Test
    @DisplayName("정상 재시작")
    void 엔딩_테스트2(){
        String input = "1";
        InputStream in = getConsoleInput(input);
        System.setIn(in);

        assertThat(app.isEnding()).isFalse();
    }

    @Test
    @DisplayName("숫자 아닌 입력")
    void 엔딩_테스트3(){
        String input = "ㄱ";
        InputStream in = getConsoleInput(input);
        System.setIn(in);

        assertThatThrownBy(() -> app.isEnding())
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("1과 2가 아닌 입력")
    void 엔딩_테스트4(){
        String input = "10";
        InputStream in = getConsoleInput(input);
        System.setIn(in);

        assertThatThrownBy(() -> app.isEnding())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
