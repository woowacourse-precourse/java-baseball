package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GameTest {
    Application app = new Application();

    @Test
    @DisplayName("3 스트라이크")
    void 게임1(){
        String result = app.getResult(List.of(1, 2, 3), List.of(1, 2, 3));
        assertThat(result).isEqualTo("3스트라이크");
    }

    @Test
    @DisplayName("2스트라이크")
    void 게임2(){
        String result = app.getResult(List.of(1, 2, 4), List.of(1, 2, 3));
        assertThat(result).isEqualTo("2스트라이크");
    }

    @Test
    @DisplayName("1스트라이크")
    void 게임3(){
        String result = app.getResult(List.of(1,4,5),List.of(1,2,3));
        assertThat(result).isEqualTo("1스트라이크");
    }

    @Test
    @DisplayName("1스트라이크 1볼")
    void 게임4(){
        String result = app.getResult(List.of(1,3,5),List.of(1,2,3));
        assertThat(result).isEqualTo("1스트라이크 1볼");
    }

    @Test
    @DisplayName("1스트라이크 2볼")
    void 게임5(){
        String result = app.getResult(List.of(1,3,2),List.of(1,2,3));
        assertThat(result).isEqualTo("1스트라이크 2볼");
    }

    @Test
    @DisplayName("3볼")
    void 게임6(){
        String result = app.getResult(List.of(1,3,5),List.of(3,5,1));
        assertThat(result).isEqualTo("3볼");
    }

    @Test
    @DisplayName("2볼")
    void 게임7(){
        String result = app.getResult(List.of(1,2,3), List.of(2,1,6));
        assertThat(result).isEqualTo("2볼");
    }

    @Test
    @DisplayName("1볼")
    void 게임8(){
        String result = app.getResult(List.of(1,2,3), List.of(4,5,1));
        assertThat(result).isEqualTo("1볼");
    }

    @Test
    @DisplayName("낫싱")
    void 게임9(){
        String result = app.getResult(List.of(1,2,3), List.of(4,5,6));
        assertThat(result).isEqualTo("낫싱");
    }

}
