package baseball.applications;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameServiceTest {

    @Test
    void singletonTest() {
        GameService instance1 = GameService.getInstance();
        GameService instance2 = GameService.getInstance();

        assertThat(instance1).isEqualTo(instance2);
    }

}
