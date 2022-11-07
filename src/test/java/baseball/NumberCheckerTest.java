package baseball;


import baseball.gameController.GameController;
import baseball.utils.NumberChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class NumberCheckerTest {


    @ParameterizedTest
    @ValueSource(strings={"1234", "1a1", "112", "6789", "gr4", "444"})
    void 유저_입력_오류_검사(String input){
        assertThatThrownBy(()->{
            NumberChecker.checkUserInput(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "12", "23", "34", "gfg"})
    void 게임_종료_후_유저의_입력_오류_검사(String input){
        assertThatThrownBy(()->{
            NumberChecker.isOneOrTwo(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
