package featuretest;

import baseball.Application;
import baseball.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyApplicationTest {

    public Application application;

    @BeforeEach
    public void 멤버_초기화(){
        application = new Application();
    }

    @Test
    void 인풋데이터_예외_체크(){
        assertThrows(IllegalArgumentException.class, () -> {
            application.checkExceptionFromUserInputData("333");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            application.checkExceptionFromUserInputData("0");
        });
    }
}
