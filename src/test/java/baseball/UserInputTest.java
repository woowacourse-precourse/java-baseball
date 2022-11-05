package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {

    UserInput userInput = new UserInput();

    @Test
    void inputNumber_사용자의_문자열_입력값을_리스트로_변환하여_반환() {
        String input = "357";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        List<Integer> numbers = userInput.inputNumber();
        assertThat(numbers).isEqualTo(List.of(3,5,7));
    }

    @Test
    void isContinue_메서드_테스트() {
        InputStream input1 = new ByteArrayInputStream("1".getBytes());
        System.setIn(input1);
        boolean aContinue = userInput.isContinue();
        assertThat(aContinue).isTrue();

        InputStream input2 = new ByteArrayInputStream("2".getBytes());
        System.setIn(input2);
        boolean aContinue2 = userInput.isContinue();
        assertThat(aContinue2).isFalse();
    }

    @Test
    void isContinue_사용자_입력이_유효하지_않은_경우_검사(){

        assertThrows(IllegalArgumentException.class, ()->{
            InputStream input = new ByteArrayInputStream("4".getBytes());
            System.setIn(input);
            userInput.isContinue();
        });
    }

}