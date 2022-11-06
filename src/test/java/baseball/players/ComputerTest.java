package baseball.players;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    @Test
    void 컴퓨터의_숫자_생성을_확인하는_기능() {
        Player computer = new Computer();
        String computerNumbers = computer.generateNumbers();
        assertThat(computerNumbers.length()).isEqualTo(3);
    }

    @Test
    void 컴퓨터의_중복된_숫자_생성하는지_확인하는_기능() {
        Player computer = new Computer();
        String computerNumbers = computer.generateNumbers();
        String tmp = "";

        for (char x : computerNumbers.toCharArray()) {
            if(!tmp.contains(String.valueOf(x)))
                tmp += String.valueOf(x);
        }
        assertThat(tmp.length()).isEqualTo(3);
    }

}
