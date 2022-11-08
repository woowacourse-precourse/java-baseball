package baseball.controllers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameControllerTest {
    @Test
    void getInstanceTest() {
        GameController instance1 = GameController.getInstance();
        GameController instance2 = GameController.getInstance();

        assertThat(instance1).isEqualTo(instance2);
    }
}
