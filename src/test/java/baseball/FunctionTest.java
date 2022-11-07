package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class FunctionTest {

    @Test
    void getComputerNumber() {
        List<Integer> computer = Application.getComputerNumber();
        Set<Integer> setComputer = new HashSet<>(computer);

        assertThat(computer.size()).isEqualTo(3);
        assertThat(setComputer.size()).isEqualTo(3);
    }

    @Test
    void getPlayerNumber() {
        ByteArrayInputStream input1 = new ByteArrayInputStream("1".getBytes());
        ByteArrayInputStream input2 = new ByteArrayInputStream("12".getBytes());
        ByteArrayInputStream input3 = new ByteArrayInputStream("102".getBytes());
        ByteArrayInputStream input4 = new ByteArrayInputStream("111".getBytes());
        ByteArrayInputStream input5 = new ByteArrayInputStream("121".getBytes());
        ByteArrayInputStream input6 = new ByteArrayInputStream("1234".getBytes());

        System.setIn(input1);
        assertThatThrownBy(Application::getPlayerNumber)
                .isInstanceOf(IllegalArgumentException.class);

        System.setIn(input2);
        assertThatThrownBy(Application::getPlayerNumber)
                .isInstanceOf(IllegalArgumentException.class);

        System.setIn(input3);
        assertThatThrownBy(Application::getPlayerNumber)
                .isInstanceOf(IllegalArgumentException.class);

        System.setIn(input4);
        assertThatThrownBy(Application::getPlayerNumber)
                .isInstanceOf(IllegalArgumentException.class);

        System.setIn(input5);
        assertThatThrownBy(Application::getPlayerNumber)
                .isInstanceOf(IllegalArgumentException.class);

        System.setIn(input6);
        assertThatThrownBy(Application::getPlayerNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isValidatePlayerNumber() {
        assertThat(Application.isValidatePlayerNumber("1")).isFalse();
        assertThat(Application.isValidatePlayerNumber("12")).isFalse();
        assertThat(Application.isValidatePlayerNumber("102")).isFalse();
        assertThat(Application.isValidatePlayerNumber("111")).isFalse();
        assertThat(Application.isValidatePlayerNumber("121")).isFalse();
        assertThat(Application.isValidatePlayerNumber("1234")).isFalse();

        assertThat(Application.isValidatePlayerNumber("123")).isTrue();
        assertThat(Application.isValidatePlayerNumber("456")).isTrue();
    }

    @Test
    void isSameComputerPlayer() {
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> correctPlayer = Arrays.asList(1, 2, 3);
        List<Integer> wrongPlayer = Arrays.asList(4, 5, 6);

        assertThat(Application.isSameComputerPlayer(computer, correctPlayer)).isTrue();
        assertThat(Application.isSameComputerPlayer(computer, wrongPlayer)).isFalse();
    }

    @Test
    void isExitGame() {
        ByteArrayInputStream input1 = new ByteArrayInputStream("0".getBytes());
        ByteArrayInputStream input2 = new ByteArrayInputStream("1".getBytes());
        ByteArrayInputStream input3 = new ByteArrayInputStream("2".getBytes());
        ByteArrayInputStream input4 = new ByteArrayInputStream("3".getBytes());
        ByteArrayInputStream input5 = new ByteArrayInputStream("4".getBytes());
        ByteArrayInputStream input6 = new ByteArrayInputStream("5".getBytes());

        System.setIn(input1);
        assertThatThrownBy(Application::isExitGame)
                .isInstanceOf(IllegalArgumentException.class);

        System.setIn(input2);
        assertThat(Application.isExitGame()).isFalse();

        System.setIn(input3);
        assertThat(Application.isExitGame()).isTrue();

        System.setIn(input4);
        assertThatThrownBy(Application::isExitGame)
                .isInstanceOf(IllegalArgumentException.class);

        System.setIn(input5);
        assertThatThrownBy(Application::isExitGame)
                .isInstanceOf(IllegalArgumentException.class);

        System.setIn(input6);
        assertThatThrownBy(Application::isExitGame)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isValidateUserSelect() {
        assertThat(Application.isValidateUserSelect("1")).isTrue();
        assertThat(Application.isValidateUserSelect("2")).isTrue();
        assertThat(Application.isValidateUserSelect("3")).isFalse();
        assertThat(Application.isValidateUserSelect("4")).isFalse();
        assertThat(Application.isValidateUserSelect("5")).isFalse();
        assertThat(Application.isValidateUserSelect("0")).isFalse();
    }
}