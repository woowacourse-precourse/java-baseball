package baseball.io;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputTest {

    private Input inputClass;

    @BeforeEach
    public void setUpStreams() {
        inputClass = new Input(3);
    }

    @Test
    public void Input클래스의_정상적인_작동_테스트() {
        String sysIn = "123";
        List<Character> result = List.of('1', '2', '3');
        Assertions.assertThat(inputClass.testReadAndMakeInputList(sysIn)).isEqualTo(result);
    }

    @Test
    public void Input클래스의_정상적인_작동_테스트2() {
        String sysIn = "456";
        List<Character> result = List.of('4', '5', '6');
        Assertions.assertThat(inputClass.testReadAndMakeInputList(sysIn)).isEqualTo(result);
    }

    @Test
    public void 입력으로_세_자릿_수가_아닌_경우() {
        String sysIn1 = "12";
        String sysIn2 = "1234";
        String sysIn3 = "12345";

        assertThatThrownBy(() -> {
            inputClass.testReadAndMakeInputList(sysIn1);
        }).isInstanceOf((IllegalArgumentException.class));
        assertThatThrownBy(() -> {
            inputClass.testReadAndMakeInputList(sysIn2);
        }).isInstanceOf((IllegalArgumentException.class));
        assertThatThrownBy(() -> {
            inputClass.testReadAndMakeInputList(sysIn3);
        }).isInstanceOf((IllegalArgumentException.class));
    }

    @Test
    public void 입력으로_중복된_숫자() {
        String sysIn1 = "112";
        String sysIn2 = "121";
        String sysIn3 = "211";
        String sysIn4 = "111";
        assertThatThrownBy(() -> {
            inputClass.testReadAndMakeInputList(sysIn1);
        }).isInstanceOf((IllegalArgumentException.class));
        assertThatThrownBy(() -> {
            inputClass.testReadAndMakeInputList(sysIn2);
        }).isInstanceOf((IllegalArgumentException.class));
        assertThatThrownBy(() -> {
            inputClass.testReadAndMakeInputList(sysIn3);
        }).isInstanceOf((IllegalArgumentException.class));
        assertThatThrownBy(() -> {
            inputClass.testReadAndMakeInputList(sysIn4);
        }).isInstanceOf((IllegalArgumentException.class));
    }

    @Test
    public void 입력으로_0_포함된_숫자() {
        String sysIn1 = "120";
        String sysIn2 = "102";
        String sysIn3 = "012";
        assertThatThrownBy(() -> {
            inputClass.testReadAndMakeInputList(sysIn1);
        }).isInstanceOf((IllegalArgumentException.class));
        assertThatThrownBy(() -> {
            inputClass.testReadAndMakeInputList(sysIn2);
        }).isInstanceOf((IllegalArgumentException.class));
        assertThatThrownBy(() -> {
            inputClass.testReadAndMakeInputList(sysIn3);
        }).isInstanceOf((IllegalArgumentException.class));
    }

    @Test
    public void 입력이_숫자인지() {
        String sysIn1 = "1ㄱr";
        String sysIn2 = "10r";
        String sysIn3 = "-=1";
        assertThatThrownBy(() -> {
            inputClass.testReadAndMakeInputList(sysIn1);
        }).isInstanceOf((IllegalArgumentException.class));
        assertThatThrownBy(() -> {
            inputClass.testReadAndMakeInputList(sysIn2);
        }).isInstanceOf((IllegalArgumentException.class));
        assertThatThrownBy(() -> {
            inputClass.testReadAndMakeInputList(sysIn3);
        }).isInstanceOf((IllegalArgumentException.class));
    }
}