package baseball.gamesetting;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

public class SettingTest {
    @Test
    void 컴퓨터_난수크기_테스트() {
        final Computer computerTest = new Computer();
        final List<String> randomNumber = computerTest.computerNumber();
        
        assertThat(randomNumber.size()).isEqualTo(3);
    }
    
    @Test
    void 컴퓨터_난수중복_테스트() {
        final Computer computerTest = new Computer();
        final List<String> randomNumber = computerTest.computerNumber();
        
        assertThat(randomNumber.get(0)).isNotEqualTo(randomNumber.get(1));
        assertThat(randomNumber.get(1)).isNotEqualTo(randomNumber.get(2));
        assertThat(randomNumber.get(2)).isNotEqualTo(randomNumber.get(0));
    }

    @Test
    void 게임종료시_문자포함_예외테스트() {
        final InputException inputTest = new InputException();
        
        assertThatThrownBy(() -> inputTest.restartJudgeException("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력하세요");
    }

    @Test
    void 게임종료시_자릿수_예외테스트() {
        final InputException inputTest = new InputException();
        
        assertThatThrownBy(() -> inputTest.restartJudgeException("12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("다시 시작하세요");
    }

    @Test
    void 게임종료시_다른_수_예외테스트() {
        final InputException inputTest = new InputException();
        
        assertThatThrownBy(() -> inputTest.restartJudgeException("4"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("다시 시작하세요");
    }
}
