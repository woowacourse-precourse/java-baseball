package baseball.view;

import baseball.validation.InputValidation;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class GameViewTest {

    GameView gv = new GameView(new InputValidation());

    @Test
    void announceStart() {
        gv.announceStart();
    }

    @Test
    void getInput() throws IOException {
        gv.getInput();
    }

    @Test
    void ballsAndStrikes() {
    }

    @Test
    void announceGameSet() {
    }

    @Test
    void isRestart() {
    }
}