package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GameViewTest {
    GameView gameView;
    private OutputStream captor;
    @BeforeEach
    void init(){
        gameView = new GameView();
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @Test
    void printStart() {
        gameView.printStart();
        Assertions.assertThat(captor.toString().trim()).isEqualTo("숫자 야구 게임을 시작합니다.");
    }

    @Test
    void printInput() {
        gameView.printInput();
        Assertions.assertThat(captor.toString()).isEqualTo("숫자를 입력해주세요 : ");
    }

    @Test
    void printHint() {
        gameView.printHint(1,2);
        Assertions.assertThat(captor.toString()).isEqualTo("1볼 2스트라이크\n");
    }

    @Test
    void printRestart() {
        gameView.printRestart();
        Assertions.assertThat(captor.toString())
                .isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
    }
}